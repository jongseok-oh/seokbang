package com.ssafy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
	@NonNull
	String userId;
	@NonNull
	String passWord;
	@NonNull
	String name;
	@NonNull
	String phoneNumber;
}
