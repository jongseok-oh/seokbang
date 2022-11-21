package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.GugunAddress;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;
import com.ssafy.model.service.LocationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/locations")
@RestController
public class LocationController{
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/coordinate")
	private ResponseEntity<?> getCoordinate(@RequestParam String gugunCode) {
		log.info(gugunCode);
		GugunAddress address = locationService.getGugunAddressByGugunCode(gugunCode);
		return ResponseEntity.ok(address);
	}
	
	@GetMapping("/sidocode")
	private ResponseEntity<?> getSidoCodeAll() {
		List<SidoCode> sidoList = locationService.getSidoCodeAll();
		return ResponseEntity.ok(sidoList);
	}
	
	@GetMapping("/guguncode")
	private ResponseEntity<?> getGugunCodeAllBySidoCode(@RequestParam String sido) {
		List<GugunCode> gugunList = locationService.getGugunCodeAllBySidoCode(sido);
		return ResponseEntity.ok(gugunList);
	}
}
