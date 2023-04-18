package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // Spring 에서는 RestController 을 달아줘야 servlet에서 서버 열어주는 것과 동일한 기능을 한다.
public class HelloController {
	
	@GetMapping("/hello")
	public Map<String, String> hello(String name) {
		
		// Spring boot에서는  json 이런 것들을 보낼때 servlet처럼 많이 안적어도 됨
		Map<String, String> testMap = new HashMap<>();
		testMap.put("name", name);
		testMap.put("age", "25");
		testMap.put("address", "부산 부산진구 연지동");
		return testMap;
	}
}
