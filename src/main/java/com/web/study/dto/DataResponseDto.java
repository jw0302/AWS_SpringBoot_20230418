package com.web.study.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data      // Data를 해주지 않으면 JSON으로 못 받아와서 오류난다
public class DataResponseDto<T> extends ResponseDto {
	
	private final T data;
	
	private DataResponseDto(T data) {
		super(true, HttpStatus.OK.value(), "Successfully");     // HttpStatus 클래스 (enum)  객체 생성
		this.data = data;
	}

	private DataResponseDto(T data, String message) {
		super(true, HttpStatus.OK.value(), message);
		this.data = data;
	}
	
	public static <T> DataResponseDto<T> of(T data) {
		return new DataResponseDto<T>(data);
	}
	
	public static <T> DataResponseDto<T> of(T data, String message) {
		return new DataResponseDto<T>(data, message);
	}
	
	public static <T> DataResponseDto<T> empty() {
		return new DataResponseDto<T>(null);
	}

}
