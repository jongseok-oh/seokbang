package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.BoardDAO;
import com.ssafy.model.dto.BoardDTO;

@Transactional
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boarddao;
	
	@Override
	public boolean insert(BoardDTO dto) {
		return boarddao.insert(dto) >0;
	}

	@Override
	public BoardDTO read(Long id) {
		return boarddao.read(id);
	}

	@Override
	public List<BoardDTO> readAll() {
		return boarddao.readAll();
	}

	@Override
	public boolean modify(BoardDTO dto) {
		return boarddao.modify(dto) >0;
	}

	@Override
	public boolean delete(Long id) {
		return boarddao.delete(id) >0;
	}

}
