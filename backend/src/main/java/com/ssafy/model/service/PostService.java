package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Post;

public interface PostService {
	boolean insertPost(Post post);

	List<Post> getPosts(String gugunCode);
	
	Post getPost(Long no);
	
	boolean modifyPost(Post post);
	
	boolean deletePost(Long no);
	
	boolean hit(Long no);
}
