package com.hzyc.niuben.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.hzyc.niuben.bean.DakaBean;

public interface DakaService {
	public List<DakaBean> selectDakaALLText() throws Exception;
	public void updateDaka(DakaBean db) throws Exception;
	public List<DakaBean> selectDaka(String username) throws Exception;
	public List<DakaBean> selectDakaALLTextByid(int id) throws Exception;
	public void updateDakaOne(DakaBean db) throws Exception;
	
}
