package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;
import com.web.study.dto.request.BasicTestDto2;

/*
 *  class: BasicRestController2

	get요청
		param 1개
		param 여러개 -> Dto 만들어서 1, Dto 없이 1

	post요청
		param 여러개 -> formData 1, JSON 1
 *  
 *  
 */

@RestController
public class BasicRestController2 {
	
	
	// param 1개
	@GetMapping("/ex1")
	public String exTest() {
		
		return "Wellcome!";
	}
	
	
	// Dto 사용한 param 여러개
	@GetMapping("/user")
	public ResponseEntity<? extends ResponseDto> user(BasicTestDto2 basicTestDto2) {
		String userInfo = "username: " + basicTestDto2.getUsername() + 
							"password: " + basicTestDto2.getPassword() +
							"name: " + basicTestDto2.getName() +
							"email: " + basicTestDto2.getEmail();
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	
	// Dto 없이 param 여러개
	@GetMapping("/user2")
	public ResponseEntity<? extends ResponseDto> user2(
			@RequestParam("username") String username,
			@RequestParam("age") int age,
			@RequestParam("address") String address) {
		
		String userInfo2 = username + "(" + age + ")" + "(" + address + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo2));
	}
	
	
	// @RequestBody 사용여부에 따라 formData (사용 X) / JSON (사용 O) 요청 가능
	@PostMapping("/test11")                            
	public ResponseEntity<? extends ResponseDto> createTest(@RequestBody BasicTestDto2 basicTestDto2) {
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto2));
	}
}





