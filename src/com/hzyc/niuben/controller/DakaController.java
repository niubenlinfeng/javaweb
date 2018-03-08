package com.hzyc.niuben.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hzyc.niuben.bean.DakaBean;
import com.hzyc.niuben.service.DakaService;

@Controller
public class DakaController {
	@Autowired
	private DakaService ds;
	@RequestMapping("selectDakaALLText.do")
	public ModelAndView selectDakaALLText() throws Exception{
		List<DakaBean> nb = ds.selectDakaALLText();	
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("list", nb);
		modelAndView.setViewName("daka.jsp");
		return modelAndView;
	}
	@RequestMapping("selectDakaALLTextByid.do")
	public ModelAndView selectDakaALLTextByid(int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<DakaBean> nb = ds.selectDakaALLTextByid(id);	
		ModelAndView modelAndView  = new ModelAndView();
		request.setAttribute("dakaState", nb.get(0).getDakaState());
		request.setAttribute("dakaimage", nb.get(0).getDakaimage());
		request.setAttribute("dakacanlei", nb.get(0).getDakacanlei());
		request.setAttribute("dakashicaiyuliang", nb.get(0).getDakashicaiyuliang());
		request.setAttribute("dakabuzhou", nb.get(0).getDakabuzhou());
		request.setAttribute("daka_username", nb.get(0).getDaka_username());
		request.setAttribute("daka_pingjia", nb.get(0).getDaka_pingjia());
		request.setAttribute("daka_time", nb.get(0).getDaka_time());
		modelAndView.addObject("list", nb);
		modelAndView.setViewName("pingjia.jsp");
		return modelAndView;
	}
	@RequestMapping("updateDaka.do")
	public void updateDaka(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DakaBean db=new DakaBean();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss     ");
		Date curDate=new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		db.setDaka_username(request.getParameter("daka_username"));
		db.setDakabuzhou(request.getParameter("dakabuzhou"));
		db.setDakacanlei(request.getParameter("dakacanlei"));
		db.setDakaimage(request.getParameter("dakaimage"));
		db.setDakashicaiyuliang(request.getParameter("dakashicaiyuliang"));
		db.setDakaState(request.getParameter("dakaState"));
		db.setDaka_time(str);
		db.setDaka_pingjia("审核中");
		ds.updateDaka(db);	
		response.getWriter().print("true");
	}
	@RequestMapping("updateDakaOne.do")
	public String updateDakaOne(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DakaBean db=new DakaBean();
		db.setDaka_username(request.getParameter("daka_username"));
		db.setDaka_time(request.getParameter("daka_time"));
		db.setDaka_pingjia("摄入总能量为"+request.getParameter("zongnengliang")+"cal");
		ds.updateDakaOne(db);	
		return "selectDakaALLText.do";
	}
	@RequestMapping("selectDaka.do")
	public void selectDaka(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("daka_username");
		try{
			List<DakaBean> dblist = ds.selectDaka(username);
		System.out.println(dblist.get(0).getDaka_pingjia());
		Gson gson = new Gson();
		String data = gson.toJson(dblist);
		response.getWriter().print(data);
		}catch(Exception e){
			response.getWriter().print("false");
		}
		
	}
	@RequestMapping("selectDakaId.do")
	public void selectDakaId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("pingjiaId"));
		try{
			List<DakaBean> dblist = ds.selectDakaALLTextByid(id);
			response.getWriter().print(dblist.get(0).getDakaimage());
		}catch(Exception e){
			response.getWriter().print("false");
		}
		
	}
}
