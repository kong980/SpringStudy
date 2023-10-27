package com.netsol7.member;

import com.netsol7.member.repository.MemberDao;
import com.netsol7.member.service.ChangePasswordService;
import com.netsol7.member.service.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		//System.out.println("어셈블 : " + pwdSvc);
		return pwdSvc;
		
	}
}
