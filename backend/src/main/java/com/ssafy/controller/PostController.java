package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.ssafy.model.dto.Post;
import com.ssafy.model.dto.PostLikes;
import com.ssafy.model.service.PostLikesService;
import com.ssafy.model.service.PostService;

@RequestMapping("/api/posts")
@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostLikesService postLikesService;
	
	@PostMapping
	public ResponseEntity<?> registPost(@RequestBody Post post) {
		boolean res = postService.insertPost(post);

		if(res)
			return ResponseEntity.ok(post);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@GetMapping("/{gugunCode}")
	public ResponseEntity<?> getPostListByGugunCode(@PathVariable String gugunCode) {
		List<Post> posts = postService.getPosts(gugunCode);
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<?> getPostByPostNo(@PathVariable Long no) {
		Post post = postService.getPost(no);
		return ResponseEntity.ok(post);
	}
	
	@PutMapping
	private ResponseEntity<?> modifyPost(@RequestBody Post post){
		boolean res = postService.modifyPost(post);
		
		if(res)
			return ResponseEntity.ok(post);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/{no}")
	private ResponseEntity<?> removePost(@PathVariable Long no){
		boolean res = postService.deletePost(no);
		
		if(res)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@PutMapping("/{no}")
	private ResponseEntity<?> hitPost(@PathVariable Long no){
		boolean res = postService.hit(no);
		
		if(res)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@PostMapping("/like/{postNo}")
	private ResponseEntity<?> likePost(HttpSession session, @PathVariable Long postNo){ 
		PostLikes postLikes = new PostLikes();
		postLikes.setPostNo(postNo);
		postLikes.setUserNo((UserInfo) session.getAttribute("user").getNo());
		
		boolean res = postLikesService.insertPostLike(postLikes);
		if(res)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.internalServerError().build();
	}
}
