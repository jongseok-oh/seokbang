package com.ssafy.model.service;

import com.ssafy.model.dto.User;

public interface UserService {

	boolean registerUser(User user);

	String login(String userId, String passWord);

	boolean modifyUser(User user);

	boolean deleteUser(String userId);

}