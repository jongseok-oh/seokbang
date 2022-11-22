package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.RepleLikes;

public interface RepleLikesService {
	boolean insertRepleLike(RepleLikes repleLikes);

	boolean deleteRepleLike(RepleLikes repleLikes);
	
	List<Integer> getRepleIsLiked(Map<String, Long> map);
	
	List<Integer> getRepleLikesCount(Long postNo);
}
