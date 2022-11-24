package com.ssafy.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

import com.ssafy.model.dto.Reple;
import com.ssafy.model.dto.RepleDTO;
import com.ssafy.model.service.RepleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/reples")
@RestController
public class RepleController {
	
	@Autowired
	private RepleService repleService;

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
		List<RepleDTO> reples = repleService.getReples(postNo);
		
		for(RepleDTO reple : reples) {
			LocalDateTime date1 = LocalDateTime.now();
			LocalDateTime date2 = reple.getRepleDate();
			
			LocalDateTime dayDate1 = date1.truncatedTo(ChronoUnit.DAYS);
	        LocalDateTime dayDate2 = date2.truncatedTo(ChronoUnit.DAYS);
	 
	        int compareResult = dayDate1.compareTo(dayDate2);
	        if(compareResult != 0)
	        	reple.setDateString(date2.format(DateTimeFormatter.ofPattern("MM-dd")));
	        else
	        	reple.setDateString(date2.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		}
		
		return ResponseEntity.ok(reples);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<?> getRepleByRepleNo(@PathVariable Long no) {
		RepleDTO reple = repleService.getReple(no);
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
