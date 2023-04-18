package com.web.study.exception;

import java.util.Map;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	/**
	 * 		230412 예외처리 수업 {Custom 예외 클래스}
	 */
	private static final long serialVersionUID = 2658314737117138818L;
	
	private Map<String, String> errorMap;
	
	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, Map<String, String> errorMap) {
		super(message);
		this.errorMap = errorMap;
	}

}
