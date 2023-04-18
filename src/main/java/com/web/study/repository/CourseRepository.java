package com.web.study.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Course;

@Mapper
public interface CourseRepository {

	// 등록
	public int saveCourse(Course course);
	// 전체 조회
	public List<Course> getCourseAll();
	// search 조회
	public List<Course> searchCourse(Map<String, Object> parameterMap);
}
