package com.exam;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//어떤 DBCP를 쓰냐에 따라 다양한 테스트를 해볼 수 있다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testHikari() {
		try(Connection con = dataSource.getConnection()) {
			System.out.println(con);
		}catch(Exception err){
			err.printStackTrace();
		}		
	}
}
