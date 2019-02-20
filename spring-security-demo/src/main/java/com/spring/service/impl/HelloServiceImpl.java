/**
 *
 */
package com.spring.service.impl;

import org.springframework.stereotype.Service;

import com.spring.service.HelloService;


@Service
public class HelloServiceImpl implements HelloService {

	/* (non-Javadoc)
	 * @see HelloService#greeting(java.lang.String)
	 */
	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello "+name;
	}

}
