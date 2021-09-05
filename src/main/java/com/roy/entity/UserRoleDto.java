package com.roy.entity;

import lombok.Data;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:25 2021-03-26
 */
@Data
public class UserRoleDto {
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 角色名
	 */
	private String roleName;
}
