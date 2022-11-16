package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.PostDAO;
import com.ssafy.model.dto.PostDTO;

@Transactional
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postdao;
	
	@Override
	public boolean insert(PostDTO dto) {
		return postdao.insert(dto) >0;
	}

	@Override
	public PostDTO read(Long id) {
		return postdao.read(id);
	}

	@Override
	public List<PostDTO> readAll() {
		return postdao.readAll();
	}

	@Override
	public boolean modify(PostDTO dtd) {
		return postdao.modify(dtd) >0;
	}

	@Override
	public boolean delete(Long id) {
		return postdao.delete(id) >0;
	}

	@Override
	public List<PostDTO> readAllbyBoardNo(Long boardNo) {
		return postdao.readAllbyBoardNo(boardNo);
	}

}
