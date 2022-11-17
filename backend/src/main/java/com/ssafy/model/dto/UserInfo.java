package com.ssafy.model.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserInfo {
	
	@NonNull
	private Long no;
	@NonNull
	private String userId;
	@NonNull
	private String password;
	@NonNull
	private String userName;
	@NonNull
	private String phoneNumber;
	@NonNull
	private int birthYear;
	@NonNull
	private int birthMonth;
	@NonNull
	private int birthDay;
	@NonNull
	private String gender;
	@NonNull
	private Date joinDate;
	@NonNull
	private Boolean admin;
}
