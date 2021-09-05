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
public class Role {
	private Long id;
	private String roleName;
	private String description;
}