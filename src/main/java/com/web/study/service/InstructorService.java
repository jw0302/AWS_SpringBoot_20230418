package com.web.study.service;

import java.util.List;

import com.web.study.dto.request.instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;

public interface InstructorService {

	// 등록(INSERT)
	public void registeInstructor(InstructorReqDto instructorReqDto);
	
	// 전체 조회(SELECT)
	public List<InstructorRespDto> getInstructorAll();
	// 선택 조회
	public InstructorRespDto findInstructorById(int id);
}
