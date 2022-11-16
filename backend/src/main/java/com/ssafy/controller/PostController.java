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
import com.ssafy.model.dto.PostDTO;
import com.ssafy.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/posts")
@RestController
@Slf4j
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<?> getPostAll(){
		List<PostDTO> list = postService.readAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostOne(@PathVariable Long id){
		PostDTO post = postService.read(id);
		if(post == null) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(post);
	}
	
	@GetMapping("/board/{boardNo}")
	public ResponseEntity<?> getPostByBoardNo(@PathVariable Long boardNo){
		List<PostDTO> list = postService.readAllbyBoardNo(boardNo);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody PostDTO dto){
		boolean res = postService.insert(dto);
		if(res) {
			return ResponseEntity.created(URI.create("api/post")).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<?> modifyPost(@RequestBody PostDTO dto){
		boolean res = postService.modify(dto);
		if(res) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id){
		boolean res = postService.delete(id);
		if(res) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
