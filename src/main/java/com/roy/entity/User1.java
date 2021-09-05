package com.roy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:25 2021-03-26
 */
@AllArgsConstructor
@Data
public class User1 {
	private Long id;
	private String username;
	private String password;
	private String phoneNum;
	private String email;
	private Role role;
}
