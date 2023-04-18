package com.web.study.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.UserAdditionDto;

class UserStore {
	public static Map<Integer, UserAdditionDto> userMap = new HashMap<>();
}

@RestController
public class UserRestController {
	
	
	// 기본적인 post요청 코드
	@PostMapping("/api/user/addition")
	public ResponseEntity<? extends ResponseDto> addUser(@RequestBody UserAdditionDto userAdditionDto) {
		
		Map<Integer, UserAdditionDto> userMap = UserStore.userMap;
		
		int maxKey = 0;
		
		if(!userMap.keySet().isEmpty()) {
			maxKey = Collections.max(userMap.keySet());
		}
		
		userMap.put(maxKey + 1, userAdditionDto);
		System.out.println(userMap);
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap));
	}
	
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<? extends ResponseDto> getUser(@PathVariable int id) {
		// userMap에서 해당 id를 가진 객체를 응답, 만약에 해당 id가 존재하지 않으면 ErrorResponse를 응답으로 준다. errorMessage = 존재하지 않는 id 입니다.
		
		// 강사님이 작성하신 코드
		Map<Integer, UserAdditionDto> userMap = UserStore.userMap;
		UserAdditionDto userAdditionDto = userMap.get(id);
		try {
			if(userAdditionDto == null) {
				throw new RuntimeException("존재하지 않는 id입니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
		}
		
		return ResponseEntity.ok().body(DataResponseDto.of(userAdditionDto));
		
		// 내가 작성한 코드
//		if(UserStore.userMap.get(id) == null) {
//			try {
//				throw new RuntimeException("오류났어!!!");				
//			} catch (Exception e) {
//				return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
//			}
//		}
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(UserStore.userMap.get(id)));
	}
	
	
	// user/addition 에서 등록한 정보가 여기에 받아진다.
	@GetMapping("/api/users")
	public ResponseEntity<? extends ResponseDto> getUsers() {
		
		return ResponseEntity.ok().body(DataResponseDto.of(UserStore.userMap.values()));
	}

}
