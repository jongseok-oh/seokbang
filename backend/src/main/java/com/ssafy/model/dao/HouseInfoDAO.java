package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.HouseInfo;

@Mapper
public interface HouseInfoDAO {
	
	List<HouseInfo> getHouseInfoByGugunCode(String gugunCodeSub);
}
