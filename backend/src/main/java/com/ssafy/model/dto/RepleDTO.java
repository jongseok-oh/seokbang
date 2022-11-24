package com.ssafy.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepleDTO {
	private Long no;
	private Long postNo;
	private Long userNo;
	private String content;
	private LocalDateTime repleDate;
	
	private String userName;
	private String dateString;
}
