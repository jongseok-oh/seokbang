package com.ssafy.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Reple;
import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.RepleLikesService;
import com.ssafy.model.service.RepleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/reples")
@RestController
public class RepleController {
	
	@Autowired
	private RepleService repleService;

	@Autowired
	private RepleLikesService repleLikesService;
	
	@PostMapping
	public ResponseEntity<?> registReple(@RequestBody Reple reple) {
		reple.setRepleDate(LocalDateTime.now());
		boolean res = repleService.insertReple(reple);

		if(res)
			return ResponseEntity.ok(reple);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@GetMapping("/{postNo}")
	public ResponseEntity<?> getRepleListByPostNo(HttpSession session, @PathVariable Long postNo) {
		List<Integer> likesCnt = repleLikesService.getRepleLikesCount(postNo);
		List<Reple> reples = repleService.getReples(postNo);
		
		Map<String, Long> params = new HashMap<>();
		params.put("userNo", ((UserInfo)session.getAttribute("user")).getNo());
		params.put("postNo", postNo);
		List<Integer> isLiked = repleLikesService.getRepleIsLiked(params);
		
		Map<String, Object> res = new HashMap<>();
		res.put("reples", reples);
		res.put("isLiked", isLiked);
		res.put("likesCnt", likesCnt);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<?> getRepleByRepleNo(@PathVariable Long no) {
		Reple reple = repleService.getReple(no);
		return ResponseEntity.ok(reple);
	}
	
	@PutMapping
	private ResponseEntity<?> modifyReple(@RequestBody Reple reple){
		reple.setRepleDate(LocalDateTime.now());
		boolean res = repleService.modifyReple(reple);
		
		if(res)
			return ResponseEntity.ok(reple);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/{no}")
	private ResponseEntity<?> removeReple(@PathVariable Long no){
		boolean res = repleService.deleteReple(no);
		
		if(res)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.internalServerError().build();
	}
	
}
