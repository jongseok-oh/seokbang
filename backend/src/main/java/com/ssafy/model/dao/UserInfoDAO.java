package com.ssafy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.UserInfo;

@Mapper
public interface UserInfoDAO {
	int insertUser(UserInfo user);
	
	UserInfo login(Map<String, String> map);
	
	int updateUser(UserInfo user);
	
	int deleteUser(String userId);
	
	UserInfo readUser(Long no);
	
	List<UserInfo> readUserAll();
}
