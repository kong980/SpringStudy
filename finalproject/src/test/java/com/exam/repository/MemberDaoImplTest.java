package com.exam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.RegisterRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoImplTest {

	@Autowired
	private MemberDao memberDao;
	
	@Ignore @Test
	public void registerTest() throws Exception {
		RegisterRequest regreq = new RegisterRequest();
		regreq.setEmail("hong@test.com1");
		regreq.setName("홍길동1");
		regreq.setPassword("11111");
		
		memberDao.RegisterMember(regreq);
		System.out.println(regreq.getEmail());
		System.out.println(regreq.getName());
		System.out.println(regreq.getPassword());
	}
	
	@Test
	public void testSelectWithPass() throws Exception {
		assertNotNull(memberDao.selectWithPass("hong@test.com", "1111"));
		assertNull(memberDao.selectWithPass("hong@test.com3", "1111"));
	}

}
