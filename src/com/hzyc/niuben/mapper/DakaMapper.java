package com.hzyc.niuben.mapper;

import java.util.List;

import com.hzyc.niuben.bean.DakaBean;

public interface DakaMapper {
	public List<DakaBean> selectDakaALLText() throws Exception;
	public void updateDaka(DakaBean db) throws Exception;
	public List<DakaBean> selectDaka(String username) throws Exception;
	public List<DakaBean> selectDakaALLTextByid(int id) throws Exception;
	public void updateDakaOne(DakaBean db) throws Exception;
}
