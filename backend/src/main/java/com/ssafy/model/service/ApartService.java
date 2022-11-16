package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseInfo;

public interface ApartService {
	public List<HouseInfo> getHouseInfoListByDongCode(String dongCode);
	
	public List<HouseDeal> getHouseDealListByAptCode(int aptCode);
}
