package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.UserArea;

@Mapper
public interface UserAreaDAO {
	int registerUserArea(UserArea userArea);
	
	List<UserArea> getUserAreaListByUserId(String userId);
	
	int remove(String userId, String dongCode);
}
