package com.web.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Instructor;

@Mapper
public interface InstructorRepository {

	// 등록(INSERT)
	public int saveInstructor(Instructor instructor);
	// 조회(SELECT)
	public List<Instructor> getInstructorAll();
	// 선택 조회 (한가지만 조회를 하는 것이기 때문에 List가 아니다)
	public Instructor findInstructorById(int id);
}
