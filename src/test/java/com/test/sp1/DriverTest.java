package com.test.sp1;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DriverTest {

	@Test
	public void test() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		ds.setUsername("jtest");
		ds.setPassword("ezen1234");
		Connection con = null;
		try {
			con = ds.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
