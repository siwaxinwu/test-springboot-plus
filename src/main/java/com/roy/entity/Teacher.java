package com.roy.entity;

import lombok.Data;

import java.util.List;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 9:09 2021-02-19
 */
@Data
public class Teacher {
	private String name;
	private Integer age;

	private List<Student> students;

}
