package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	
	@Override
	public Map<String,String> doLogin(String uiId, String uiPwd) {
		Map<String,String> user = new HashMap<>();
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return udao.selectUser(user);
	}

	@Override
	public List<Map<String, String>> getUserList(Map<String, String> user) {
		
		return udao.selectUserList(user);
	}

}