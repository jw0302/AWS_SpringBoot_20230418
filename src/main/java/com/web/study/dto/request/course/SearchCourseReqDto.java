package com.web.study.dto.request.course;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchCourseReqDto {
	
	@Min(value = 1)
	@Max(value = 3)
	private int type;
	
	@NotBlank(message = "검색 내용을 입력해주세요.")			// 에러메세지 설정 가능
	private String searchValue;
}
