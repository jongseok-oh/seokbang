package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.BaseAddress;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;

public interface LocationService {

	BaseAddress getBaseAddressByDongCode(String dongCode);
	List<SidoCode> getSidoCodeAll();
	List<GugunCode> getGugunCodeAllBySidoCode(String sidoCode);
}