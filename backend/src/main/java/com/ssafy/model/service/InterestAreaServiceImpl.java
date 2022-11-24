package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.InterestAreaDAO;
import com.ssafy.model.dto.InterestArea;

@Service
public class InterestAreaServiceImpl implements InterestAreaService {
	
	@Autowired
	private InterestAreaDAO interestAreaDAO;

	@Override
	public List<String> getUserAreaListByUserNo(Long userNo) {
		return interestAreaDAO.getInterestAreaListByUserNo(userNo);
	}

	@Override
	public boolean deleteUserArea(Long userNo, String gugunCode) {
		return interestAreaDAO.remove(userNo, gugunCode) > 0;
	}

	@Override
	public boolean registerUserArea(InterestArea interestArea) {
		return interestAreaDAO.registerInterestArea(interestArea) >0;
	}
}
