package com.ssafy.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/users")
@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping
	private ResponseEntity<?> delete(@RequestParam Long no){
		boolean res = userService.deleteUser(no);
		
		if(res)
			return ResponseEntity.noContent().build();
		else return ResponseEntity.internalServerError().build();
	}
	
	@PutMapping
	private ResponseEntity<?> modify(@RequestBody UserInfo user){
		log.info(user.toString());
		boolean res = userService.modifyUser(user);
		
		if(res) return ResponseEntity.ok(user);
		else return ResponseEntity.internalServerError().build();
	}

	@GetMapping("/logout")
	private ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/login")
	private ResponseEntity<?> login(HttpSession session, @RequestBody Map<String,Object> m){
		String userId = (String) m.get("userId");
		String password = (String) m.get("password");
		log.info(userId+", "+password);
		
		UserInfo info = userService.login(m);

		if(info != null) {
			session.setAttribute("user", info);
			log.info(session.toString());
			log.info("login sucess " + info.toString());
			info.setPassword(null);
			return ResponseEntity.ok(info);
		}else
			return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/id")
	private ResponseEntity<?> checkValidId(@RequestParam String userId){
		boolean res = userService.checkValidID(userId);
		if(res) return ResponseEntity.status(200).build();
		else return ResponseEntity.status(409).build();
	}
	
	@PostMapping
	private ResponseEntity<?> register(@RequestBody UserInfo user){
		log.info(user.toString());
		user.setJoinDate(LocalDateTime.now());
		try {
			boolean res = userService.registerUser(user);
			if(res)
				return ResponseEntity.ok().build();
			else return ResponseEntity.internalServerError().build();
		}catch(DuplicateKeyException e) {
			return ResponseEntity.status(409).build();
		}
	}
	
	@GetMapping("/{no}")
	private ResponseEntity<?> readUser(HttpSession session, @PathVariable Long no){
		
		UserInfo user =(UserInfo) session.getAttribute("user");
		// 어드민이거나 로그인한 같은 사람이면
		if(user.getAdmin() || user.getNo() == no) {
			UserInfo res = userService.readUser(no);
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<?> readAllUser(HttpSession session){
		UserInfo user =(UserInfo) session.getAttribute("user");
		if(user.getAdmin()) {
			List<UserInfo> list = userService.readUserAll();
			return ResponseEntity.ok(list);
		}
		else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
}
