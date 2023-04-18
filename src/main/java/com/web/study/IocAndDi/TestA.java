package com.web.study.IocAndDi;

import org.springframework.stereotype.Component;

@Component("t1")
public class TestA implements Test {
	
	
	// TestA에서 만든 메소드가 아닌 인터페이스에서 오버라이드 한 메소드를 사용한다.
//	public void printTestA() {
//		System.out.println("TestA 클래스!!!");
//	}

	@Override
	public void printTest() {
		System.out.println("TestA 클래스!!!");	
	}
}
