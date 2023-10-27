package com.netsol7.member.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsol7.member.model.Member;
import com.netsol7.member.model.RegisterRequest;
import com.netsol7.member.repository.MemberDao;

// 회원가입을 시켜주는 서비스
@Service("memberRegSvc")
public class MemberRegisterService {
	private MemberDao memberDao;
	
	//기본 생성자
	public MemberRegisterService() {}
	
	//생성자
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//Dao에 있는 insert 메소드 호출
	public void regist(RegisterRequest req) {
		//같은 이메일이 있는지 여부 검사		
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일이 있습니다.");
			return;
		}
		Member newMem = new Member(req.getEmail(), req.getName(), req.getPassword(), new Date());
		memberDao.insert(newMem);
	}
	
	
}
