package com.netsol7.member.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsol7.member.common.MemberPrinter;
import com.netsol7.member.model.Member;
import com.netsol7.member.repository.MemberDao;

@Service("listPrinter")
public class MemberListPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	@Autowired
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memDao.selectAll();
		
		if(members == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		for(Member m: members) {
			printer.print(m);
		}
		System.out.println();
	}
}
