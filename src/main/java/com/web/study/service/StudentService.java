package com.web.study.service;

import java.util.List;

import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;

public interface StudentService {

	// 등록(INSERT)
	public void registeStudent(StudentReqDto studentReqDto);
	
	// 조회(SELECT)
	public List<StudentRespDto> getStudentAll();
	// 선택 조회
	public StudentRespDto findStudentById(int id);
}
