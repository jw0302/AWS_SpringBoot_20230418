package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter          // mybatis가 값을 불러와 사용하기 위해선 @Getter를 사용해야 쓸 수 있다.
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	private int itm_id;
	private Instructor instructor;
	
	public LectureRespDto toDto() {
		String instructorName = null;
		
		// NUll 인지 아닌지 확인하는 부분
		if(instructor != null) {
			instructorName = instructor.getItm_name();
		}
		
		return LectureRespDto.builder()
				.lectureId(ltm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorName(instructorName)
				.build();
	}
}
