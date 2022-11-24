package com.ssafy.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	private Long no;
	private Long userNo;
	private String gugunCode;
	private String title;
	private String content;
	private int hit;
	private LocalDateTime postDate;
	
	private String userName;
	private int likesCnt;
	private String dateString;
}
