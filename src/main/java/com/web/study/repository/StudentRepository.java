package com.web.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Student;

@Mapper
public interface StudentRepository {
	
	// 등록(INSERT)
	public int saveStudent(Student student);
	// 조회(SELECT)
	public List<Student> getStudentAll();
	// 선택 조회
	public Student findStudentById(int id);
}
