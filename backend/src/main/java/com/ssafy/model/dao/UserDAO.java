package com.ssafy.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.User;

@Mapper
public interface UserDAO {
	int insertUser(User user);
	
	String login(Map<String, String> map);
	
	int updateUser(User user);
	
	int deleteUser(String userId);
}
