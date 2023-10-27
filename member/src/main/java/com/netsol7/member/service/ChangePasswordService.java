package com.netsol7.member.service;

import com.netsol7.member.model.Member;
import com.netsol7.member.repository.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService() {}
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("ChangePasswordService : " + memberDao);
	}
	public void changePassword(String email, String oldPass, String newPass) {
		//멤버를 계속 전달해줘야함 
		
		//무조건 업데이트보다는 해당하는 그 사람이 있는지 먼저 확인(= 해당 이메일이 존재하는지 여부 검사)
		//System.out.println(email + ", " + oldPass + ", " + newPass);
		Member member = memberDao.selectByEmail(email);
		System.out.println("change Password: " + member);
		if(member == null) {
			System.out.println("해당 멤버가 없습니다.");
			return;
		}
		
		// 현재 비밀번호가 맞는지 확인하고 비밀번호 변경 -> MemberDto에서
		member.changePassword(oldPass, newPass);
		memberDao.update(member);
	}
	
	
}
