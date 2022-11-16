package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.HouseDeal;

@Mapper
public interface HouseDealDAO {
	
	List<HouseDeal> getHouseDealByAptCode(int aptCode);
}
