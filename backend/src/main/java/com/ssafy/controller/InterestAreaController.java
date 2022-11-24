package com.ssafy.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.InterestArea;
import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.InterestAreaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/interest")
@RestController
public class InterestAreaController{
	@Autowired
	private InterestAreaServiceImpl areaService;
	
	@DeleteMapping("/{gugunCode}")
	private ResponseEntity<?> removeInterest(HttpSession session, @PathVariable String gugunCode){
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		
		boolean res = areaService.deleteUserArea(user.getNo(), gugunCode);
		if(res) {
			log.info("area delete sucess");
			return ResponseEntity.noContent().build();
		}
		else {
			log.info("area delete fail");
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("/{gugunCode}")
	private ResponseEntity<?> registInterest(HttpSession session, @PathVariable String gugunCode){
		UserInfo user = (UserInfo) session.getAttribute("user");
		log.info(user.toString());
		log.info("gwansimRegist dongCode = " + gugunCode);
		
		boolean res = areaService.registerUserArea(new InterestArea(user.getNo(),gugunCode));
		
		if(res) {
			log.info("area insert sucess");
			return ResponseEntity.created(URI.create("api/areas" + gugunCode)).build();
		}
		else {
			log.info("area insert fail");
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	private ResponseEntity<?> getInterestAreaListByUserNo(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		log.info("userId : "+user);
		List<String> interestareas = areaService.getUserAreaListByUserNo(user.getNo());
		
		if(!interestareas.isEmpty())
			return ResponseEntity.ok(interestareas);
		else return ResponseEntity.noContent().build();
	}
}
