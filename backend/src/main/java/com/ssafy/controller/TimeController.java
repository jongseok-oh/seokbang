package com.ssafy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/times")
@RestController
public class TimeController {
	
	@GetMapping
	public String getCurrentDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		return date.format(new Date());
	}
}