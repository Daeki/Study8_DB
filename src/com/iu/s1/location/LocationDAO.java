package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO {
	
	public void getOne(int location_id) {
		
		
		
		
	}
	
	
	public void getList() {
		//LOCATIONS Table을 조회해서 출력
		
	
		
		//2. Driver를 메모리에 로딩
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		
		//3. DB Connection
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결성공");
			
		//4. SQL문 생성
			String sql ="SELECT * FROM Locations";
		
		//5. 미리 전송
			st = con.prepareStatement(sql);
			
		//6. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("STREET_ADDRESS"));
				System.out.println(rs.getInt("LOCATION_ID"));
				System.out.println("------------");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
