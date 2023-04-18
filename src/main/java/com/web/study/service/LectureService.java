package com.web.study.service;

import java.util.List;

import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;

public interface LectureService {
	
	// 등록(INSERT)
	public void registeLecture(LectureReqDto lectureReqDto);
	// 조회(SELECT)
	public List<LectureRespDto> getLectureAll();
	
	public List<LectureRespDto> searchLecture(int type, String searchValue);
}
