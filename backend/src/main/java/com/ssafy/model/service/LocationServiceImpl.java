package com.ssafy.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.BaseAddressDAO;
import com.ssafy.model.dto.BaseAddress;
import com.ssafy.model.dto.DongCode;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;

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
