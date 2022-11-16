package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.HouseInfo;
import com.ssafy.model.service.ApartService;

@RequestMapping("/api/aparts")
@RestController
public class ApartController{
	
	@Autowired
	private ApartService apartService;
	
	@GetMapping
	public ResponseEntity<?> getHouseinfoListByDongCode(@RequestParam String dongCode) {
		List<HouseInfo> houseinfos = apartService.getHouseInfoListByDongCode(dongCode);
		return ResponseEntity.ok(houseinfos);
	}
	
	@GetMapping("/deals")
	public ResponseEntity<?> getHouseDealListByAptCode(@RequestParam int aptCode) {
		List<HouseDeal> houseDeals = apartService.getHouseDealListByAptCode(aptCode);
		return ResponseEntity.ok(houseDeals);
	}
}
