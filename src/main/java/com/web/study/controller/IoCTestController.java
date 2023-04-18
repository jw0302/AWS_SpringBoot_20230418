package com.web.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.IocAndDi.IocTest;
import com.web.study.IocAndDi.IocTest2;

import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor // 자동으로 생성자 생성해주는 어노테이션
public class IoCTestController {

	// Ioc 사용 법 (@RequiredArgsConstructor를 사용 하지 않고 최대한 깔끔하게 사용하려면 @Autowired를 사용하면 된다.)
	@Autowired
	private IocTest iocTest;
	@Autowired
	private IocTest2 iocTest2;
	
	@GetMapping("/ioc/test")
	public Object test() {
		iocTest.run();
		iocTest2.run();
		return null;
	}
	
	// @Autowired 쓰지 않고 자동으로 기능 주입하려면 써야 하는 코드 
//	private final IocTest iocTest;
//	private final IocTest2 iocTest2;
//	public IoCTestController(IocTest iocTest, IocTest2 iocTest2) {
//		this.iocTest = iocTest;
//		this.iocTest2 = iocTest2;
//	}
	
//	public IoCTestController() {
//		iocTest = new IocTest(new TestA());
//		iocTest = new IocTest();
//	}
	
}
