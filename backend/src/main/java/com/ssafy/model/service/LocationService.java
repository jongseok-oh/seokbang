package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.GugunAddress;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;

public interface LocationService {

	GugunAddress getGugunAddressByGugunCode(String gugunCode);
	List<SidoCode> getSidoCodeAll();
	List<GugunCode> getGugunCodeAllBySidoCode(String sidoCode);
}