package com.web.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
//		iocAndDiTest();
	}
	
	
	// Ioc (Inversion of Control) : 제어의 역전 (제어를 개발자가 안하고 프로그램이 한다)
//	public static void iocAndDiTest() {
//		// IocTest라는 객체를 생성하는데 여기에 외부에서 TestA라는 객체를 의존 받는다. TestA 사용 가능
//		// Di 를 이용하면 IcoTest는 매번 바꾸지 않고 여기서 (TestA, TestB, TestC)를 호출해서 사용가능
//		IocTest iocTest = new IocTest(new TestA());
//		iocTest.run();
//	}

}
