package com.hzyc.niuben.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hzyc.niuben.bean.DakaBean;
import com.hzyc.niuben.bean.DakapingjiaBean;
import com.hzyc.niuben.service.DakaService;
import com.hzyc.niuben.service.DakapingjiaService;


@Controller
public class DakapingjiaController {
	@Autowired
	private DakapingjiaService ds;
	@Autowired
	private DakaService xx;
	@RequestMapping("updatepingjia.do")
	public String updatepingjia(HttpServletRequest request) throws Exception{
		DakapingjiaBean db = new DakapingjiaBean();
		
		db.setFriUsername(request.getParameter("friUsername"));
		db.setFriTime(request.getParameter("friTime"));
		db.setFridakaleibie(request.getParameter("fridakaleibie"));
		db.setShicaiyuliangNengliang(request.getParameter("shicaiyuliangNengliang"));
		db.setYingyangjisuan(request.getParameter("yingyangjisuan"));
		db.setYinshijianyi(request.getParameter("yinshijianyi"));
		db.setChanpintuijian(request.getParameter("chanpintuijian"));
		db.setZongnengliang(request.getParameter("zongnengliang"));
		ds.updatepingjia(db);
		/*ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("list", nb);
		modelAndView.setViewName("daka.jsp");*/
		return "updateDakaOne.do?daka_username="+request.getParameter("friUsername")+"&daka_time="+request.getParameter("friTime")+"&zongnengliang="+request.getParameter("zongnengliang");
	}
	@RequestMapping("selectDakapingjia.do")
	public void selectDakapingjia(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DakapingjiaBean db = new DakapingjiaBean();
		db.setFriUsername(request.getParameter("friUsername"));
		int id =Integer.parseInt(request.getParameter("pingjiaId"));
		List<DakaBean> nb = xx.selectDakaALLTextByid(id);
		db.setFriTime(nb.get(0).getDaka_time());
		try{
			List<DakapingjiaBean> dblist = ds.selectDakapingjia(db);
			
			System.out.println(dblist.size());
		Gson gson = new Gson();
		String data = gson.toJson(dblist);
		response.getWriter().print(data);
		}catch(Exception e){
			response.getWriter().print("false");
		}
		
	}
}
