package com.ssafy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.BoardDTO;
import com.ssafy.model.service.BoardService;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public ResponseEntity<?> getBoardAll(){
		List<BoardDTO> list = boardService.readAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBoardOne(@PathVariable Long id){
		BoardDTO board = boardService.read(id);
		return ResponseEntity.ok(board);
	}
	
	@PostMapping
	public ResponseEntity<?> createBoard(@RequestBody BoardDTO dto){
		boolean res = boardService.insert(dto);
		if(res) {
			return ResponseEntity.created(URI.create("api/board")).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<?> modifyBoard(@RequestBody BoardDTO dto){
		boolean res = boardService.modify(dto);
		if(res) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id){
		boolean res = boardService.delete(id);
		if(res) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
