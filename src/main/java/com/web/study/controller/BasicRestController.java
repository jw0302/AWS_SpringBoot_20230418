package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;

import lombok.Data;

//@Data        // Params 객체 생성
//class Params {
//	private int age;
//	private String name;
//}


@RestController
public class BasicRestController {

	// GET 요청의 param을 처리하는 방법
//	@GetMapping("/read")
//	public ResponseEntity<? extends ResponseDto> read(Params params) {
//			@RequestParam("age") int userAge,
//			@RequestParam("name") String userName) {
		
//		String userInfo = params.getName() + "(" + params.getAge() + ")";
		
//		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
//		return ResponseEntity.ok().body(null);
//		return ResponseEntity.badRequest().body(null);
//		return ResponseEntity.badRequest().header(userInfo, null).body(null);
//	}
	

	// GET 요청의 param을 처리하는 방법(실제 사용하는 SpringBoot 처럼 간결하게 바꾼 코드)
	@GetMapping("/read")
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {
		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	
	// 경로 자체에 값을 입력하는 방식 -@PathVariable-
	@GetMapping("/read2/{id}")          // 1. @PathVariable("id") int userId / 2. @PathVariable int id -> 둘다 사용가능 2번처럼 ("id")는 생략 가능하지만 @PathVariable은 생략 불가능
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
		Map<Integer, String> userMap = new HashMap<>();
		
		userMap.put(1, "장진일");
		userMap.put(2, "장진이");
		userMap.put(3, "장진삼");
		userMap.put(4, "장진사");
		userMap.put(5, "장진오");
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
	}
	
	
	// Post 요청의 데이터 처리 -> .created(url을 넣을 수 있다.) 성공후 넘어갈 url -> .ok() 일반적인 성공에 대한 요청 
	@PostMapping("/create")                            // JSON 데이터을 받으려면 무조건 @RequestBody를 넣어줘야 한다. form에서 요청 오면 다시 빼줘야 함
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
	}
}





