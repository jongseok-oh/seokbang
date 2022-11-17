package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.UserInfo;

public interface UserService {

	boolean registerUser(UserInfo user);

	UserInfo login(String userId, String passWord);

	boolean modifyUser(UserInfo user);

	boolean deleteUser(String userId);
	
	UserInfo readUser(Long no);
	
	List<UserInfo> readUserAll();
}