package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {
	int aptCode;
	String aptName;
	String dongCode;
	String dongName;
	int buildYear;
	String jibun;
	String lat;
	String lng;
	String img;
	
}
