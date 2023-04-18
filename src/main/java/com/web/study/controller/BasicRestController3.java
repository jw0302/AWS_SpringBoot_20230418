package com.web.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.request.BasicTestDto2;


@RestController
public class BasicRestController3 {
	
	
	// get요청 제일 기본
	@GetMapping("/test1")
	public String test1() {
		return "Nice to me you!";
	}
	
	
	// get요청 기본 (param 여러개, Map 사용)
	@GetMapping("/test2")
	public Map<Integer, String> test2() {
		Map<Integer, String> testMap = new HashMap<>();
		
		testMap.put(1, "a");
		testMap.put(2, "b");
		testMap.put(3, "c");
		testMap.put(4, "d");
		testMap.put(5, "e");
		
		return testMap;
	}
	
	
	// List 사용
	@GetMapping("/test3")
	public List<String> test3(String carId, String carName, String carModel) {
		List<String> carList = new ArrayList<>();
		
		carList.add(carId);
		carList.add(carName);
		carList.add(carModel);
		
		return carList;
	}
	
	
	@GetMapping("/test4")
	public String test4(BasicTestDto2 basicTestDto2) {
		
		return "username: " + basicTestDto2.getUsername() +
				"password: " + basicTestDto2.getPassword() +
				"name: " + basicTestDto2.getName() +
				"email: " + basicTestDto2.getEmail();
	}
	
	
}





