package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GugunAddress {
	private Long no;
	private String sidoName;
	private String gugunName;
	private String gugunCode;
	private String lat;
	private String lng;
}