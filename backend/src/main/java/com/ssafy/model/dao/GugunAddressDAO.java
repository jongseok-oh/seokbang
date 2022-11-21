package com.ssafy.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.GugunAddress;

@Mapper
public interface GugunAddressDAO {
	GugunAddress getGugunAddressByGugunCode(String gugunCode);
}
