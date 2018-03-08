package com.hzyc.niuben.service;

import java.util.List;

import com.hzyc.niuben.bean.NewsBean;

public interface NewsService {
	public List<NewsBean> selectNewsALLText() throws Exception;
}
