package com.web.study.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

@Mapper
public interface LectureRepository {
	
	// 등록(INSERT)
	public int registe(Lecture lecture);
	// 조회(SELECT)
	public List<Lecture> getLectureAll();
	// 검색 조회(SELECT)
	public List<Lecture> searchLecture(Map<String, Object> parameterMap);
}
