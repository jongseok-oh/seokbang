package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLikes {
	private Long no;
	private Long userNo;
	private Long postNo;
}
