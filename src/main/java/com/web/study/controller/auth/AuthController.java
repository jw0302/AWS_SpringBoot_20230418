package com.web.study.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	
	// 회원가입 구현
	@PostMapping("auth/register")
	public ResponseEntity<? extends ResponseDto> registe(@RequestBody RegisteUserReqDto registeUserReqDto) {
		
		authService.duplicatedUsername(registeUserReqDto); // 중복확인 오류 없으면 다음으로 넘어감
		authService.registeUser(registeUserReqDto);
		
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	
	// 로그인 구현
	@PostMapping("auth/login")
	public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(authService.login(loginReqDto)));
	}
}
