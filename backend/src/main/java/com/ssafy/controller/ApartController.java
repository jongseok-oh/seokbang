package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping("/deals")
	public ResponseEntity<?> getHouseDealListByAptCode(@RequestParam int aptCode) {
		List<HouseDeal> houseDeals = apartService.getHouseDealListByAptCode(aptCode);
		log.info("houseDealList ok");
		return ResponseEntity.ok(houseDeals);
	}
	
	@GetMapping("/deals/pages")
	public ResponseEntity<?> getHouseDealPageCnt(@RequestParam int aptCode){
		return ResponseEntity.ok(apartService.getPageCntByAptCode(aptCode));
	}
	
	@GetMapping("/deals/pages/{aptCode}")
	public ResponseEntity<?> getHouseDealByPageNo(@RequestParam int pageNo,@PathVariable int aptCode){
		List<HouseDeal> list = apartService.getHouseDealListByAptCodeByPageNo(aptCode, pageNo);
		if(list != null) {
			return ResponseEntity.ok(list);
		}
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
