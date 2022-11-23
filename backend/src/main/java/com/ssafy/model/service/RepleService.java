package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Reple;
import com.ssafy.model.dto.RepleDTO;

public interface RepleService {
	boolean insertReple(Reple reple);

	List<RepleDTO> getReples(Long postNo);
	
	RepleDTO getReple(Long no);
	
	boolean modifyReple(Reple reple);
	
	boolean deleteReple(Long no);
}
