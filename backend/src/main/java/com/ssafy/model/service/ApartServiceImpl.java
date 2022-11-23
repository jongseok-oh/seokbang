package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.HouseDealDAO;
import com.ssafy.model.dao.HouseInfoDAO;
import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseDealEntity;
import com.ssafy.model.dto.HouseInfo;

@Service
public class ApartServiceImpl implements ApartService {
	@Autowired
	private HouseInfoDAO houseInfoDao;
	
	@Autowired
	private HouseDealDAO houseDealDao;
	
	private final int PER_PAGE = 4;
	
	
	public List<HouseInfo> getHouseInfoListByGugunCode(String gugunCode){
		String gugunCodeSub = gugunCode.substring(0, 5);
		return houseInfoDao.getHouseInfoByGugunCode(gugunCodeSub);
	}
	
	public List<HouseDeal> getHouseDealListByAptCode(int aptCode){
		return houseDealDao.getHouseDealByAptCode(aptCode);
	}
	
	public int getPageCntByAptCode(int aptCode) {
		int cnt = houseDealDao.getAptCnt(aptCode);
		return (cnt + PER_PAGE - 1)/ PER_PAGE;
	}

	@Override
	public List<HouseDeal> getHouseDealListByAptCodeByPageNo(int aptCode, int pageNo) {
		if(pageNo <=0) return null;
		Map<String, Object> m = new HashMap<>();
		
		m.put("aptCode", aptCode);
		
		int start = (pageNo-1) * PER_PAGE, end = PER_PAGE;
		
		m.put("start", start);
		m.put("end", end);
		
		return houseDealDao.getHouseDealByAptCodeLimit(m);
	}

	@Override
	public List<HouseDealEntity> getHouseDealListByKeyword(String keyword) {
		return houseDealDao.getHouseDealByKeyWord(keyword);
	}
}
