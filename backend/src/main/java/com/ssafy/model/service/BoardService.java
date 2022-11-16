package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.BoardDTO;

public interface BoardService {
	boolean insert(BoardDTO dto);
	BoardDTO read(Long id);
	List<BoardDTO> readAll();
	boolean modify(BoardDTO dto);
	boolean delete(Long id);
}
