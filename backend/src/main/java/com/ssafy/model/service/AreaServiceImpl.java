package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserAreaDAO;
import com.ssafy.model.dto.UserArea;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private UserAreaDAO userAreaDao;

	public boolean registerUserArea(UserArea userArea){
		return userAreaDao.registerUserArea(userArea) > 0;
	}

	public List<UserArea> getUserAreaListByUserId(String userId) {
		return userAreaDao.getUserAreaListByUserId(userId);
	}

	public boolean deleteUserArea(String userId, String dongCode) {
		return userAreaDao.remove(userId,dongCode) > 0;
	}
}
