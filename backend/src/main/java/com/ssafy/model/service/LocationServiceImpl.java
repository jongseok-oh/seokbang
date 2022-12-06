package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.GugunAddressDAO;
import com.ssafy.model.dao.GugunCodeDAO;
import com.ssafy.model.dao.SidoCodeDAO;
import com.ssafy.model.dto.GugunAddress;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;

//@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private SidoCodeDAO sidoCodeDAO;
	
	@Autowired
	private GugunCodeDAO gugunCodeDAO;
	
	@Autowired
	private GugunAddressDAO gugunAddressDAO; 

	@Override
	public GugunAddress getGugunAddressByGugunCode(String gugunCode) {
		return gugunAddressDAO.getGugunAddressByGugunCode(gugunCode);
	}
	@Override
	public List<SidoCode> getSidoCodeAll() {
		return sidoCodeDAO.readAll();
	}
	@Override
	public List<GugunCode> getGugunCodeAllBySidoCode(String sidoCode) {
		String sidoCodeSub = sidoCode.substring(0, 2);
		return gugunCodeDAO.readAllBySidoCode(sidoCodeSub);
	}
}
