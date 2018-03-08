package com.hzyc.niuben.service;

import java.util.List;

import com.hzyc.niuben.bean.DakapingjiaBean;

public interface DakapingjiaService {
	public void updatepingjia(DakapingjiaBean db) throws Exception;
	public List<DakapingjiaBean> selectDakapingjia(DakapingjiaBean db) throws Exception;
}
