package com.hzyc.niuben.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.niuben.bean.UserBean;

public interface UserService {
	public UserBean selectALL() throws Exception;
	public UserBean login_app(String userName) throws Exception;
	public void register_app(UserBean ub) throws Exception;
	public void updateUser(UserBean ub) throws Exception;
	public List<UserBean> selectUser(String userName) throws Exception;
}
