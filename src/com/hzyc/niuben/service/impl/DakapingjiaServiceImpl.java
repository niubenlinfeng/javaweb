package com.hzyc.niuben.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.niuben.bean.DakapingjiaBean;
import com.hzyc.niuben.mapper.DakapingjiaMapper;
import com.hzyc.niuben.service.DakapingjiaService;
@Service
public class DakapingjiaServiceImpl implements DakapingjiaService{
	@Autowired
	private DakapingjiaMapper dm;

	public void updatepingjia(DakapingjiaBean db) throws Exception {
		// TODO Auto-generated method stub
		dm.updatepingjia(db);
	}

	public List<DakapingjiaBean> selectDakapingjia(DakapingjiaBean db)
			throws Exception {
		// TODO Auto-generated method stub
		return dm.selectDakapingjia(db);
	}
}
