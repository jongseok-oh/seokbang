package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.InterestArea;

public interface InterestAreaService {
	public boolean registerUserArea(InterestArea userArea);
	
	public List<String> getUserAreaListByUserNo(Long userNo);
	
	public boolean deleteUserArea(InterestArea interestArea);
}
