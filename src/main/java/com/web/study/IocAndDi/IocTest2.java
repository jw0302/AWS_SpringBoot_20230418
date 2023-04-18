package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IocTest2 {

	// 인터페이스 기능을 만들어 TestA, TestB, TestC 클래스에 부여하면 굳이 각 클래스를 불러와 쓰지 않고 인터페이스만 불러와도 세가지 클래스를 다 사용 가능
	@Qualifier("testC")
	@Autowired
	private Test test;
	
	// Di(객체를 직접 생성하는 게 아니라 외부에서 생성한 후 주입 시켜주는 방식) : 외부에서 인터페이스 Test를 주입 해줘서 사용하는 것 (의존성을 외부에서 받는다)
//	public IocTest(Test test) {
//		this.test = test;
//	}
	
	public void run() {
		test.printTest();
		System.out.println("IoCTest2 출력!");
	}
}
