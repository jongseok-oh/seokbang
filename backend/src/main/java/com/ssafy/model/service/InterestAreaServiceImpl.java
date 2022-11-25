package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.InterestAreaDAO;
import com.ssafy.model.dto.InterestArea;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class InterestAreaServiceImpl implements InterestAreaService {
	
	@Autowired
	private InterestAreaDAO interestAreaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<String> getUserAreaListByUserNo(Long userNo) {
		return interestAreaDAO.getInterestAreaListByUserNo(userNo);
	}

	@Override
	public boolean deleteUserArea(InterestArea interestArea) {
		return interestAreaDAO.remove(interestArea) > 0;
	}

	@Override
	public boolean registerUserArea(InterestArea interestArea) {
		return interestAreaDAO.registerInterestArea(interestArea) >0;
	}
}
