package com.hzyc.niuben.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.niuben.bean.UserBean;
import com.hzyc.niuben.mapper.UserMapper;
import com.hzyc.niuben.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper um;
	public UserBean selectALL() throws Exception{
		return um.selectALL();
	}
	public UserBean login_app(String userName)
			throws Exception {
		// TODO Auto-generated method stub
		return um.login_app(userName);
	}
	public void register_app(UserBean ub) throws Exception {
		// TODO Auto-generated method stub
		um.register_app(ub);
	}
	public void updateUser(UserBean ub) throws Exception {
		// TODO Auto-generated method stub
		um.updateUser(ub);
	}
	public List<UserBean> selectUser(String userName) throws Exception {
		// TODO Auto-generated method stub
		return um.selectUser(userName);
	}
}
