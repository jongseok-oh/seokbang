package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.UserInfo;

public interface UserService {

	boolean registerUser(UserInfo user);

	UserInfo login(Map<String, Object> m);

	boolean modifyUser(UserInfo user);

	boolean deleteUser(String userId);
	
	UserInfo readUser(Long no);
	
	List<UserInfo> readUserAll();
}