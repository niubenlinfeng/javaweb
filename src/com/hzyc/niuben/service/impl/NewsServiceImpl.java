package com.hzyc.niuben.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.niuben.bean.NewsBean;
import com.hzyc.niuben.mapper.NewsMapper;
import com.hzyc.niuben.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsMapper nm;
	public List<NewsBean> selectNewsALLText() throws Exception {
		// TODO Auto-generated method stub
		return nm.selectNewsALLText();
	}

}
