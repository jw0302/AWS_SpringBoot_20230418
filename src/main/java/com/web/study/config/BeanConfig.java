package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.study.IocAndDi.TestC;

@Configuration  // @Bean 을 등록하게 해주는 용도
public class BeanConfig {

	@Bean
	public TestC testC() {
		return new TestC();
	}
	
}
