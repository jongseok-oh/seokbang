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
@RequestMapping("/api/interestareas")
@RestController
public class InterestAreaController{
	@Autowired
	private InterestAreaServiceImpl areaService;
	
	@DeleteMapping("/{dongCode}")
	private ResponseEntity<?> gwansimDelete(HttpSession session, @PathVariable String dongCode){
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		
		boolean res = areaService.deleteUserArea(user.getNo(), dongCode);
		if(res) {
			log.info("area delete sucess");
			return ResponseEntity.noContent().build();
		}
		else {
			log.info("area delete fail");
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("/{dongCode}")
	private ResponseEntity<?> gwansimRegist(HttpSession session, @PathVariable String dongCode){
		UserInfo user = (UserInfo) session.getAttribute("user");
		log.info(user.toString());
		log.info("gwansimRegist dongCode = " + dongCode);
		
		boolean res = areaService.registerUserArea(new InterestArea(user.getNo(),dongCode));
		
		if(res) {
			log.info("area insert sucess");
			return ResponseEntity.created(URI.create("api/areas" + dongCode)).build();
		}
		else {
			log.info("area insert fail");
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	private ResponseEntity<?> getUserAreaListByUserId(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		log.info("userId : "+user);
		List<InterestArea> userareas = areaService.getUserAreaListByUserNo(user.getNo());
		
		if(!userareas.isEmpty())
			return ResponseEntity.ok(userareas);
		else return ResponseEntity.noContent().build();
	}
}
