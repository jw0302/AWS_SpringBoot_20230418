package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Instructor;
import com.web.study.dto.request.instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
	
	private final InstructorRepository instructorRespository;

	// 등록(INSERT)
	@Override
	public void registeInstructor(InstructorReqDto instructorReqDto) {
		
		instructorRespository.saveInstructor(instructorReqDto.toEntity());
	}

	// 전체 조회(SELECT)
	@Override
	public List<InstructorRespDto> getInstructorAll() {
		
		List<InstructorRespDto> dtos = new ArrayList<>();
		
		instructorRespository.getInstructorAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	// id 선택 조회
	@Override
	public InstructorRespDto findInstructorById(int id) {
		return instructorRespository.findInstructorById(id).toDto();
	}

	

}
