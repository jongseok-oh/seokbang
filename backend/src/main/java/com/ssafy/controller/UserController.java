package com.ssafy.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/user")
@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping
	private ResponseEntity<?> delete(@RequestParam String userId){
		boolean res = userService.deleteUser(userId);
		
		if(res)
			return ResponseEntity.noContent().build();
		else return ResponseEntity.internalServerError().build();
	}
	
	@PutMapping
	private ResponseEntity<?> modify(@RequestBody User user){
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
	private ResponseEntity<?> login(HttpSession session, @RequestBody Map<String,String> m){
		String userId = m.get("userId");
		String passWord = m.get("passWord");
		log.info(userId+","+passWord);
		
		String name = null;
		try {
			name = userService.login(userId, passWord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(name != null) {
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			return ResponseEntity.ok().build();
		}else
			return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	private ResponseEntity<?> register(@RequestBody User user){
		log.info(user.toString());
		boolean res = userService.registerUser(user);

		if(res)
			return ResponseEntity.ok(user);
		else return ResponseEntity.internalServerError().build();
	}
}
