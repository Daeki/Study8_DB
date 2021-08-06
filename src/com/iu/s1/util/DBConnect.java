package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {

	public Connection getConnection() throws Exception {
		//1. 접속 정보
		String user="user02";
		String password="user02";
		//String password="########";
		//jdbc:oracle:thin:@ip:port:sid
		// express edition = xe
		// 정식 버전         = orcl
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//String url = "jdbc:oracle:thin:#####_high?TNS_ADMIN=#####";
		String driver = "oracle.jdbc.driver.OracleDriver";



		//2. 드라이버 로딩	
		//	Class.forName(driver);
		//	System.out.println("Driver 로딩 성공");

		//3. DB 접속
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("접속 성공");
		System.out.println(con);

		return con;

	}
	
	public void disConnect(ResultSet rs, PreparedStatement st, Connection con) {
		try {
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
