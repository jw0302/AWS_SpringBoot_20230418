package com.web.study.dto.request.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.web.study.domain.entity.User;

import lombok.Data;

@Data
public class RegisteUserReqDto {
	
	private String username;
	private String password;
	private String name;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))		// password 값 암호화로 받기
				.name(name)
				.email(email)
				.build();
	}
}
