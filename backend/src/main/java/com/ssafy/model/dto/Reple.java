package com.ssafy.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reple {
	private Long no;
	private Long postNo;
	private Long userNo;
	private String content;
	private Date repleDate;
}
