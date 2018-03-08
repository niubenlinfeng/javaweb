package com.hzyc.niuben.mapper;

import java.util.List;

import com.hzyc.niuben.bean.NewsBean;

public interface NewsMapper {
	public List<NewsBean> selectNewsALLText() throws Exception;
}
