package com.roy.controller;

import com.roy.annotation.CurrentUserName;
import com.roy.annotation.IP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:21 2021-03-17
 */
@Slf4j
@RestController
public class VOTestController {

	@GetMapping("vo/test")
	public String test(@IP String ip){
		log.info("请求的ip地址为:{}",ip);
		return "ok";
	}

	@GetMapping("vo/user")
	public String test1(@CurrentUserName String name){
		log.info("请求的ip地址为:{}",name);
		return "ok";
	}
}
