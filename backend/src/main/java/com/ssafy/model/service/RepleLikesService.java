package com.ssafy.model.service;

import com.ssafy.model.dto.RepleLikes;

public interface RepleLikesService {
	boolean insertRepleLike(RepleLikes repleLikes);

	boolean deleteRepleLike(RepleLikes repleLikes);
	
	boolean getRepleLike(RepleLikes repleLikes);
	
	int getRepleLikesCount(Long repleNo);
}
