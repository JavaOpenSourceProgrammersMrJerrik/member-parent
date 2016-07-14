package com.mango.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.mango.member.spi.IService;

@Controller
public class Test {
	@Resource
	IService testDubbo;

	String teString() {
		return "";
	}
}
