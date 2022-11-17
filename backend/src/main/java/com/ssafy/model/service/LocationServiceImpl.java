package com.ssafy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.BaseAddressDAO;
import com.ssafy.model.dto.BaseAddress;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private BaseAddressDAO baseAddressDAO;
	
	private LocationServiceImpl() {
	}
	@Override
	public BaseAddress getBaseAddressByDongCode(String dongCode) {
		return baseAddressDAO.getBaseAddressByDongCode(dongCode);
	}
}
