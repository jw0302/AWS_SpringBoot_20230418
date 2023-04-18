package com.web.study.service;

import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;

public interface AuthService {
	
	// 회원가입 기능
	public void registeUser(RegisteUserReqDto registeUserReqDto);					// 회원가입(user 정보 = registeUserReqDto)
	public void duplicatedUsername(RegisteUserReqDto registeUserReqDto);			// username 중복 확인
	
	// 로그인 기능
	public JwtTokenRespDto login(LoginReqDto loginReqDto);
	
}
