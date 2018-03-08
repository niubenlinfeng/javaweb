package com.hzyc.niuben.mapper;

import java.util.List;

import com.hzyc.niuben.bean.UserBean;

public interface UserMapper {
	public UserBean selectALL() throws Exception;
	public UserBean login_app(String userName) throws Exception;
	public void register_app(UserBean ub) throws Exception;
	public void updateUser(UserBean ub) throws Exception;
	public List<UserBean> selectUser(String userName) throws Exception;
}
