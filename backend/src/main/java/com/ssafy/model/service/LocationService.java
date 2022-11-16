package com.ssafy.model.service;

import com.ssafy.model.dto.BaseAddress;

public interface LocationService {

	BaseAddress getBaseAddressByDongCode(String dongCode);

}