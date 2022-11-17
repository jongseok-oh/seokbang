package com.ssafy.controller;

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

import com.ssafy.model.dto.Reple;
import com.ssafy.model.service.RepleService;

@RequestMapping("/api/reples")
@RestController
public class RepleController {
	
	@Autowired
	private RepleService repleService;
	
	@PostMapping
	public ResponseEntity<?> registReple(@RequestBody Reple reple) {
		boolean res = repleService.insertReple(reple);

		if(res)
			return ResponseEntity.ok(reple);
		else
			return ResponseEntity.internalServerError().build();
	}
	
	@GetMapping("/{postNo}")
	public ResponseEntity<?> getRepleListByPostNo(@PathVariable Long postNo) {
		List<Reple> reples = repleService.getReples(postNo);
		
		return ResponseEntity.ok(reples);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<?> getRepleByRepleNo(@PathVariable Long no) {
		Reple reple = repleService.getReple(no);
		return ResponseEntity.ok(reple);
	}
	
	@PutMapping
	private ResponseEntity<?> modifyReple(@RequestBody Reple reple){
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
