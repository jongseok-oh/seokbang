package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDeal {
	int no;
	int aptCode;
	String dealAmount;
	String dealYear;
	String dealMonth;
	String dealDay;
	String area;
	String floor;
	String type;
	String rentMoney;
}
