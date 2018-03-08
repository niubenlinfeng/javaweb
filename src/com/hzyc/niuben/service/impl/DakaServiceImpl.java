package com.hzyc.niuben.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.niuben.bean.DakaBean;
import com.hzyc.niuben.mapper.DakaMapper;
import com.hzyc.niuben.service.DakaService;

@Service
public class DakaServiceImpl implements DakaService{
	@Autowired
	private DakaMapper dm;

	public List<DakaBean> selectDakaALLText() throws Exception {
		// TODO Auto-generated method stub
		return dm.selectDakaALLText();
	}

	public void updateDaka(DakaBean db) throws Exception {
		// TODO Auto-generated method stub
		dm.updateDaka(db);
	}

	public List<DakaBean> selectDaka(String username) throws Exception {
		// TODO Auto-generated method stub
		return dm.selectDaka(username);
	}

	public List<DakaBean> selectDakaALLTextByid(int id) throws Exception {
		// TODO Auto-generated method stub
		return dm.selectDakaALLTextByid(id);
	}

	public void updateDakaOne(DakaBean db) throws Exception {
		// TODO Auto-generated method stub
		dm.updateDakaOne(db);
	}
	
}
