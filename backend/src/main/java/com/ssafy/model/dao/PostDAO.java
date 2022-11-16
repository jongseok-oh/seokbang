package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PostDTO;

@Mapper
public interface PostDAO {
	int insert(PostDTO dto);
	PostDTO read(Long id);
	List<PostDTO> readAll();
	
	int modify(PostDTO dtd);
	int delete(Long id);
	
	List<PostDTO> readAllbyBoardNo(Long boardNo);
}
