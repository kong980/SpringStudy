package com.netsol7.member.service;

import com.netsol7.member.common.MemberPrinter;
import com.netsol7.member.model.Member;
import com.netsol7.member.repository.MemberDao;

// 멤버 정보 출력 얘도 서비스
public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	
}
