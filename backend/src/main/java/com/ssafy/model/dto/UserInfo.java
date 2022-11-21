package com.ssafy.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserInfo {
	
	private Long no;
	private String userId;
	private String password;
	private String userName;
	private String phoneNumber;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String gender;
	private Date joinDate;
	private Boolean admin;
}
