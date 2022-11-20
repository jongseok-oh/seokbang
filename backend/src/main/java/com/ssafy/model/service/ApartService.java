package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseInfo;

public interface ApartService {
	public List<HouseInfo> getHouseInfoListByGugunCode(String gugunCode);
	
	public List<HouseDeal> getHouseDealListByAptCode(int aptCode);
}
