package com.netsol7.member.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.netsol7.member.model.Member;

//실제 디비와 연결해서 디비와 작업하는 Persistence
//기능적인 것들을 구현하는 부분
public class MemberDao {
	// DB 대신에 메모리에 저장하는 방식으로 하겠다.
	private Map<String, Member> map = new HashMap<String, Member>();
	private static long nextId = 0;
	
	// 조회 기능(한 명만 조회)
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	// 조회 기능(모든 사람 조회)
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	// 저장 기능
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		System.out.println("insert test: " + map);
	}
	
	// 수정 기능
	public void update(Member member) {
		map.put(member.getEmail(), member);
		System.out.println("update test: " + member.getPassword());		
	}
}
