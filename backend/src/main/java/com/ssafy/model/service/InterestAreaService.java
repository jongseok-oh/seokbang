package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.InterestArea;

public interface InterestAreaService {
	public boolean registerUserArea(InterestArea userArea);
	
	public List<InterestArea> getUserAreaListByUserNo(Long userNo);
	
	public boolean deleteUserArea(Long userNo, String dongCode);
}
