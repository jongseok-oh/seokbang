package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.HouseDealDAO;
import com.ssafy.model.dao.HouseInfoDAO;
import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseInfo;

@Service
public class ApartServiceImpl implements ApartService {
	@Autowired
	private HouseInfoDAO houseInfoDao;
	
	@Autowired
	private HouseDealDAO houseDealDao;
	
	public List<HouseInfo> getHouseInfoListByDongCode(String dongCode){
		return houseInfoDao.getHouseInfoByDongCode(dongCode);
	}
	
	public List<HouseDeal> getHouseDealListByAptCode(int aptCode){
		return houseDealDao.getHouseDealByAptCode(aptCode);
	}
}
