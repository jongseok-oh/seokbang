package com.ssafy.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.BaseAddress;

@Mapper
public interface BaseAddressDAO {

	BaseAddress getBaseAddressByDongCode(String dongCode);
}
