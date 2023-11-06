package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class OracleConnectionTest {
	//junit이 test를 조금 더 전문적으로 사용할 수 있다 ->@Test
	@Test
	public void ConnectionTest() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "scott", "1111");
		
		System.out.println(conn);
		conn.close();
	}
}
