package com.ssafy.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;
	
	@Override
	public boolean registerUser(User user){
		return userDao.insertUser(user) > 0;
	}
	@Override
	public String login(String userId,String passWord){
		Map<String, String> m = new HashMap<>();
		m.put("userId", userId);
		m.put("passWord", passWord);
		return userDao.login(m);
		
	}
	@Override
	public boolean modifyUser(User user){
		return userDao.updateUser(user) > 0;
	}
	@Override
	public boolean deleteUser(String userId){
		return userDao.deleteUser(userId) > 0;
	}
}
