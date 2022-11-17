package com.ssafy.model.service;

import com.ssafy.model.dto.PostLikes;

public interface PostLikesService {
	boolean insertPostLike(PostLikes postLikes);

	boolean deletePostLike(PostLikes postLikes);
	
	boolean getPostLike(PostLikes postLikes);
	
	int getPostLikesCount(Long postNo);
}
