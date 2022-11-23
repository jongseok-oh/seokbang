package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Reple;
import com.ssafy.model.dto.RepleDTO;

@Mapper
public interface RepleDAO {
	int insertReple(Reple reple);

	List<RepleDTO> getReples(Long postNo);
	
	RepleDTO getReple(Long no);
	
	int modifyReple(Reple reple);
	
	int deleteReple(Long no);
}
