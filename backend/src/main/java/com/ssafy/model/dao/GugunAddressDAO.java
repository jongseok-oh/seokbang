package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.GugunAddress;

@Mapper
public interface GugunAddressDAO {
	GugunAddress getGugunAddressByGugunCode(String gugunCode);
	List<GugunAddress> getGugunAddressAll();
}
