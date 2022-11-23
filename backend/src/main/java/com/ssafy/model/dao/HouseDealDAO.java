package com.ssafy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.HouseDeal;

@Mapper
public interface HouseDealDAO {
	
	List<HouseDeal> getHouseDealByAptCode(int aptCode);
	int getAptCnt(int aptCode);
	
	List<HouseDeal> getHouseDealByKeyWord(String keyword);
	
	// int aptCode, int start, int end
	List<HouseDeal> getHouseDealByAptCodeLimit(Map<String, Object> m);
}
