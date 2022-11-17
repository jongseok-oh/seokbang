package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Post;

@Mapper
public interface PostDAO {
	int insertPost(Post post);

	List<Post> getPosts(String gugunCode);
	
	Post getPost(Long no);
	
	int modifyPost(Post post);
	
	int deletePost(Long no);
	
	int hit(Long no);
}
