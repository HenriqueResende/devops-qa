package com.projects.praticandoAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
}
