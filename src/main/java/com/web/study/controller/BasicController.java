package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;

//@Controller
@RestController     // RestController : 데이터를 return 하는 용도 / Controller : view를 return 하는 용도
public class BasicController {

//	@ResponseBody     // Controller 를 사용할때 에는 ResponseBody를 해주지 않으면 500 error이 나게 된다. 데이터를 응답하려면 꼭 필수
	@GetMapping("/view/test")
	public ResponseEntity<? extends ResponseDto> view() {		// 응답은 String 일때에만 text로 전달되고 나머지는 Json으로 전달된다. *Object로 return 해주면 전부 Json으로 받아준다
		// <? extends ResponseDto> ResponseDto를 상속받은 것들은 다 된다
		// DataResponseDto : 응답 인터페이스
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		
		if(strList.contains("e")) {
			try {
				throw new RuntimeException("오류났어!!!");				
			} catch (Exception e) {
//				return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));
			}
		}
		
//		return ResponseEntity.badRequest().body(DataResponseDto.of(strList));
		return ResponseEntity.ok().body(DataResponseDto.of(strList));
//		return ResponseEntity.ok(DataResponseDto.of(strList));
	}
	
}
