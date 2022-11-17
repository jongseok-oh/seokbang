package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Reple;

public interface RepleService {
	boolean insertReple(Reple reple);

	List<Reple> getReples(Long postNo);
	
	Reple getReple(Long no);
	
	boolean modifyReple(Reple reple);
	
	boolean deleteReple(Long no);
}
