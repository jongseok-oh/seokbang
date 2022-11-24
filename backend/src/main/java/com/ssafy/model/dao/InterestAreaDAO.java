package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.InterestArea;

@Mapper
public interface InterestAreaDAO {
	int registerInterestArea(InterestArea interestArea);
	
	List<String> getInterestAreaListByUserNo(Long userNo);
	
	int remove(Long userNo, String gugunCode);
}
