package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserInfoDAO;
import com.ssafy.model.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfoDAO userInfoDao;
	
	@Override
	public boolean registerUser(UserInfo user){
		return userInfoDao.insertUser(user) > 0;
	}
	@Override
	public UserInfo login(Map<String, Object> m){
		return userInfoDao.login(m);
	}
	@Override
	public boolean modifyUser(UserInfo user){
		return userInfoDao.updateUser(user) > 0;
	}
	@Override
	public boolean deleteUser(String userId){
		return userInfoDao.deleteUser(userId) > 0;
	}
	
	
	@Override
	public UserInfo readUser(Long no) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserInfo> readUserAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
