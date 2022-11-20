package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.SidoCode;

@Mapper
public interface SidoCodeDAO {
	public List<SidoCode> readAll();
}
