package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Reple;

@Mapper
public interface RepleDAO {
	int insertReple(Reple reple);

	List<Reple> getReples(Long postNo);
	
	Reple getReple(Long no);
	
	int modifyReple(Reple reple);
	
	int deleteReple(Long no);
}
