package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.PostDTO;

public interface PostService {
	boolean insert(PostDTO dto);
	PostDTO read(Long id);
	List<PostDTO> readAll();
	
	boolean modify(PostDTO dtd);
	boolean delete(Long id);
	
	List<PostDTO> readAllbyBoardNo(Long boardNo);
}
