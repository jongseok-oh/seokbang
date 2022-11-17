package com.ssafy.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	private Long no;
	private Long userNo;
	private String gugunCode;
	private String title;
	private String content;
	private int hit;
	private Date postDate;
}
