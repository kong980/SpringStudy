package com.netsol7.member.common;

import org.springframework.stereotype.Component;

import com.netsol7.member.model.Member;

//멤버 정보를 모아서 어떻게 이쁘게 보여줄까?
@Component
public class MemberPrinter {
	public void print(Member member) {
		System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(), member.getName(),
				member.getRegisterDate());
	}
}
