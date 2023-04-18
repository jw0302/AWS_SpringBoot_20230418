package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	
	// 등록(INSERT)
	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		// Dto -> Entity 로 변환하는 과정
		studentRepository.saveStudent(studentReqDto.toEntity());
	}

	// 전체 조회(SELECT)
	@Override
	public List<StudentRespDto> getStudentAll() {
		List<StudentRespDto> dtos = new ArrayList<>();
		studentRepository.getStudentAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	// id 선택 조회
	@Override
	public StudentRespDto findStudentById(int id) {
		return studentRepository.findStudentById(id).toDto();
	}

}
