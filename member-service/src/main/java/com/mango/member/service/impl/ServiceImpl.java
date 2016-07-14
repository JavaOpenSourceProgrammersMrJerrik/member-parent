package com.mango.member.service.impl;

import com.mango.member.spi.IService;

public class ServiceImpl implements IService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
