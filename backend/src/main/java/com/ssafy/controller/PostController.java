package com.ssafy.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ssafy.model.dto.PostDTO;
import com.ssafy.model.dto.PostLikes;
import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.PostLikesService;
import com.ssafy.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/posts")
@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostLikesService postLikesService;
	
	@PostMapping
	public ResponseEntity<?> registPost(@RequestBody Post post) {
		log.info("regist post");
		post.setPostDate(LocalDateTime.now());
		boolean res = postService.insertPost(post);

		if(res)
			return ResponseEntity.ok(post);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@GetMapping("/{gugunCode}")
	public ResponseEntity<?> getPostListByGugunCode(@PathVariable String gugunCode) {
		List<PostDTO> posts = postService.getPosts(gugunCode);
		for(PostDTO post : posts) {
			LocalDateTime date1 = LocalDateTime.now();
			LocalDateTime date2 = post.getPostDate();
			
			LocalDateTime dayDate1 = date1.truncatedTo(ChronoUnit.DAYS);
	        LocalDateTime dayDate2 = date2.truncatedTo(ChronoUnit.DAYS);
	 
	        int compareResult = dayDate1.compareTo(dayDate2);
	        if(compareResult != 0)
	        	post.setDateString(date2.format(DateTimeFormatter.ofPattern("MM-dd")));
	        else
	        	post.setDateString(date2.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		}
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<?> getPostByPostNo(HttpSession session, @PathVariable Long no) {
		Map<String, Object> res = new HashMap<>();
		
		PostDTO post = postService.getPost(no);
		post.setDateString(post.getPostDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		res.put("post", post);
		
		PostLikes postLikes = new PostLikes();
		postLikes.setUserNo(((UserInfo) session.getAttribute("user")).getNo());
		postLikes.setPostNo(no);
		res.put("isLiked", postLikesService.getPostLike(postLikes));
		
		log.info(res.get("post").toString());
		return ResponseEntity.ok(res);
	}
	
	@PutMapping
	private ResponseEntity<?> modifyPost(@RequestBody Post post){
		boolean res = postService.modifyPost(post);
		post.setPostDate(LocalDateTime.now());
		
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
		postLikes.setUserNo(((UserInfo)session.getAttribute("user")).getNo());
		postLikes.setPostNo(postNo);
		
		boolean res = postLikesService.insertPostLike(postLikes);
		if(res)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/like/{postNo}")
	private ResponseEntity<?> unlikePost(HttpSession session, @PathVariable Long postNo){ 
		PostLikes postLikes = new PostLikes();
		postLikes.setUserNo(((UserInfo)session.getAttribute("user")).getNo());
		postLikes.setPostNo(postNo);
		
		boolean res = postLikesService.deletePostLike(postLikes);
		if(res)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@GetMapping("/notices")
	public ResponseEntity<?> getNoticeList() {
		List<PostDTO> notices = postService.getNotices();
		return ResponseEntity.ok(notices);
	}
}
