package com.ssafy.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.RepleLikes;

@Mapper
public interface RepleLikesDAO {
	int insertRepleLike(RepleLikes repleLikes);

	int deleteRepleLike(RepleLikes repleLikes);
	
	RepleLikes getRepleLike(RepleLikes repleLikes);
	
	int getRepleLikesCount(Long repleNo);
}
