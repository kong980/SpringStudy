package com.exam.repository;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;

public interface MemberDao {

	// 회원가입을 위한 서비스
	public void RegisterMember(RegisterRequest dto) throws Exception;
	
	// 회원 조회
	public Member selectMember(String email) throws Exception;
	
	// 회원 인증
	public Member selectWithPass(String email, String pw) throws Exception;
	
	// 회원 수정
	
	// 회원 삭제
}
