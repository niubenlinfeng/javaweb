package com.hzyc.niuben.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hzyc.niuben.bean.NewsBean;
import com.hzyc.niuben.service.NewsService;

@Controller
public class NewsController {
	@Autowired
	private NewsService ns;
	@RequestMapping("selectNewsALLText.do")
	public void selectNewsALLText(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<NewsBean> nb = ns.selectNewsALLText();
		Gson gson = new Gson();
		String data = gson.toJson(nb);
		response.getWriter().print(data);
		out.flush();
		out.close();
	}
}
