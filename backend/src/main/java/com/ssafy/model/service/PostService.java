package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Post;
import com.ssafy.model.dto.PostDTO;

public interface PostService {
	boolean insertPost(Post post);

	List<PostDTO> getPosts(String gugunCode);
	
	PostDTO getPost(Long no);
	
	boolean modifyPost(Post post);
	
	boolean deletePost(Long no);
	
	boolean hit(Long no);
}
