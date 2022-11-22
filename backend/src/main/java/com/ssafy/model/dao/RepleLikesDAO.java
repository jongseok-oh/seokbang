package com.ssafy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.RepleLikes;

@Mapper
public interface RepleLikesDAO {
	int insertRepleLike(RepleLikes repleLikes);

	int deleteRepleLike(RepleLikes repleLikes);
	
	List<Integer> getRepleIsLiked(Map<String, Long> map);
	
	List<Integer> getRepleLikesCount(Long postNo);
}
