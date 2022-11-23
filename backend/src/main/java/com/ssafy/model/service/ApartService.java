package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseDealEntity;
import com.ssafy.model.dto.HouseInfo;

public interface ApartService {
	public List<HouseInfo> getHouseInfoListByGugunCode(String gugunCode);
	
	public List<HouseDeal> getHouseDealListByAptCode(int aptCode);
	
	public List<HouseDeal> getHouseDealListByAptCodeByPageNo(int aptCode, int pageNo);
	
	public int getPageCntByAptCode(int aptCode);
	
	public List<HouseDealEntity> getHouseDealListByKeyword(String keyword);
}
