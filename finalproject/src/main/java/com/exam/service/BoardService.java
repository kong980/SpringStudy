package com.exam.service;

import java.util.List;

import com.exam.domain.Board;

public interface BoardService {
	//리스트 페이지 보기
	public List<Board> getList() throws Exception;
	
	//글 조회
	public Board read(int bNo) throws Exception;
	
	//저장
	public void write(Board board) throws Exception;
	
	//수정
	public void update(Board board) throws Exception;
	
	//삭제
	public void delete(int bNo) throws Exception;
}
