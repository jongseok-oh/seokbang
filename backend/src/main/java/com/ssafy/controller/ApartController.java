package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseInfo;
import com.ssafy.model.service.ApartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/aparts")
@RestController
public class ApartController{
	
	@Autowired
	private ApartService apartService;
	
	@GetMapping()
	public ResponseEntity<?> getHouseinfoListByDongCode(@RequestParam String gugunCode) {
		List<HouseInfo> houseinfos = apartService.getHouseInfoListByGugunCode(gugunCode);
		log.info("houseList ok");
		return ResponseEntity.ok(houseinfos);
	}
	
	@GetMapping("/deals/{aptCode}")
	public ResponseEntity<?> getHouseDealListByAptCode(@PathVariable int aptCode) {
		List<HouseDeal> houseDeals = apartService.getHouseDealListByAptCode(aptCode);
		return ResponseEntity.ok(houseDeals);
	}
}
