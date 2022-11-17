package com.ssafy.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PostLikes;

@Mapper
public interface PostLikesDAO {
	int insertPostLike(PostLikes postLikes);

	int deletePostLike(PostLikes postLikes);
	
	PostLikes getPostLike(PostLikes postLikes);
	
	int getPostLikesCount(Long postNo);
}
