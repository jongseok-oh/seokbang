package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.GugunCode;

@Mapper
public interface GugunCodeDAO {
	public List<GugunCode> readAllBySidoCode(String sidoCodeSub);
}
