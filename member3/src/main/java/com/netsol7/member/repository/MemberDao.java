package com.netsol7.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.netsol7.member.model.Member;

//@Component로 하면 구분하기가 힘듬, @Repository : 뚜렷한 목적이 있는 경우
@Repository
public class MemberDao {
	// 진짜 DB
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 조회 기능(한 명만 조회)
	public Member selectByEmail(String email) {
		String sql = "select * from member where email=?";
		Member mem = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
		}, new ResultSetExtractor<Member>() {

			@Override
			public Member extractData(ResultSet rs) throws SQLException, DataAccessException {
				Member member = null;
				if(rs.next()) {
					member = new Member(
							rs.getString("email"),
							rs.getString("name"),
							rs.getString("password"),
							rs.getTimestamp("registerDate"));
					member.setId(rs.getLong("id"));
				}
				return member;
			}
		});
		
		return mem;
	}
	
	// 조회 기능(모든 사람 조회)
	public Collection<Member> selectAll(){
		//1. 전달할 쿼리문
		//select * from member;로 할 시에는 rs로 데이터를 가지고 올 때 순서대로 가지고 와야한다.
		//String sql = "select email, password, name, registerDate, id from member";
		String sql = "select * from member order by id";
		//원래는 rowmapper를 생성후에 객체를 가지고 와야하지만 내가 이거를 재활용할게 아니라면
		//그냥 바로 여기에다가 인터페이스를 상속받은 객체를 무명클래스(new RowMapper)를 바로 넣어준다.
		List<Member> result = jdbcTemplate.query(sql, new RowMapper() {
			
			//데이터를 계속 쌓아서 result로 보내는거야
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				//Member dto로 해서 rs로 데이터 가지고와
				//생성자에 만들어진 순서대로 해야함 -> Member.java public Member(String email, String name, String password, Date registerDate){}의 순서
				Member dto = new Member(
						rs.getString("email"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getTimestamp("registerDate"));
				dto.setId(rs.getLong("id"));
				return dto;
			}
			
		});
		
		return result;
	}
	
	// 저장 기능
	public void insert(Member member) {
		/*1.
		//인자값으로 무명클래스를 이용해 클래스를 만들어줄수 있다.
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into member(id, email, password, name, registerDate) values(seq_id.nextVal,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}
			
		});
		*/
		/*
		// 2.람다식 매개변수 -> 조심할점 : 오버라이딩하는 인터페이스가 하나여야함
		jdbcTemplate.update(
			(Connection con) -> {
				String sql = "insert into member(id, email, password, name, registerDate) values(seq_id.nextVal,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}			
		);
		*/
		/*
		// 3.일회용으로 사용하겠다.
		String sql = "insert into member(id, email, password, name, registerDate) values(seq_id.nextVal,?,?,?,?)";
		
		Object[] values = new Object[] {member.getEmail(), member.getPassword(), member.getName(), new Timestamp(member.getRegisterDate().getTime())};
		//sql->이 명령어를 실행하겠다. ,
		jdbcTemplate.update(sql, values);
		*/
		//4.
		String sql = "insert into member(id, email, password, name, registerDate) values(seq_id.nextVal,?,?,?,?)";
		
		jdbcTemplate.update(sql, member.getEmail(), member.getPassword(), member.getName(), new Timestamp(member.getRegisterDate().getTime()));
		
		
	}
	
	// 수정 기능
	public void update(Member member) {
		String sql = "update member set password=? where email=?";
		
		jdbcTemplate.update(sql, member.getPassword(), member.getEmail());
	}
	
}

