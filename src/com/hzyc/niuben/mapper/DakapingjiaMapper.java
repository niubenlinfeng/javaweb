package com.hzyc.niuben.mapper;

import java.util.List;

import com.hzyc.niuben.bean.DakapingjiaBean;

public interface DakapingjiaMapper {
	public void updatepingjia(DakapingjiaBean db) throws Exception;
	public List<DakapingjiaBean> selectDakapingjia(DakapingjiaBean db) throws Exception;
}
