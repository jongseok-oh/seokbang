package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.UserArea;

public interface AreaService {
	public boolean registerUserArea(UserArea userArea);
	
	public List<UserArea> getUserAreaListByUserId(String userId);
	
	public boolean deleteUserArea(String userId, String dongCode);
}
