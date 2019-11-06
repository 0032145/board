package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public Map<String,String> doLogin(String uiId, String uiPwd);
	public List<Map<String,String>> getUserList(Map<String,String> user);
}