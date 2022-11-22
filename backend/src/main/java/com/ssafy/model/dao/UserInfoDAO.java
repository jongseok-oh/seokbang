package com.ssafy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.UserInfo;

@Mapper
public interface UserInfoDAO {
	int insertUser(UserInfo user);
	
	UserInfo login(Map<String, Object> map);
	
	int updateUser(UserInfo user);
	
	int deleteUser(Long no);
	
	UserInfo readUser(Long no);
	
	UserInfo readUserById(String userId);
	
	List<UserInfo> readUserAll();
	
}
