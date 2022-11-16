package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseAddress {
	int no;
	String sidoName;
	String gugunName;
	String dongName;
	String dongCode;
	String lat;
	String lng;
	
}