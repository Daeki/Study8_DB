package com.iu.s1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iu.s1.util.DBConnect;

public class DBTest {
	
	private DBConnect dbConnect;
	
	public DBTest() {
		dbConnect = new DBConnect();
	}
	
	
	//접근지정자 [그외지정자] 리턴타입 메서드명([매개변수]) - 선언부, 헤더
	//{}										   - 내용, body
	public void getList() {
		Connection con=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		
			con = dbConnect.getConnection();
		
		//4. SQL문 생성
			String sql = "SELECT * FROM DEPARTMENTS";
			
		//5. SQL문 미리 보내기
			st = con.prepareStatement(sql);
			
		//7. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("DEPARTMENT_ID")+"\t");
				System.out.print(rs.getString("DEPARTMENT_NAME")+"\t");
				System.out.println(rs.getInt("MANAGER_ID"));
				System.out.println("---------------");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
	}
	
	
	public void getOne() {
		
		Connection con= null;
		PreparedStatement st=null;
		ResultSet rs = null;
		
		//3. Connection
		try {
			con = dbConnect.getConnection();
			int id=40;
		//4. SQL문 생성
			String sql ="SELECT DEPARTMENT_NAME AS DE FROM DEPARTMENTS WHERE DEPARTMENT_ID= ?";
		
		//5. 미리 전송
			st = con.prepareStatement(sql);
			
		//6. ?값을 설정
			//setXXX(?의 인덱스번호, 값)
			st.setInt(1, id);

		//7. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				System.out.println(rs.getString("DE"));
			}else {
				System.out.println("그런 번호는 없다");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		
		
	}
	
	public void getCount() {
		//SELECT COUNT(DEPARTMENT_ID) FROM DEPARTMENTS;
		//count 함수의 결과물 출력
		
		
		Connection con= null;
		PreparedStatement st=null;
		ResultSet rs = null;
		
		// Connection
		try {
			con = dbConnect.getConnection();	
			
			//sql
			String sql = "SELECT COUNT(DEPARTMENT_ID) FROM DEPARTMENTS";
			
			//미리전송
			st = con.prepareStatement(sql);
			
			//?
			
			//최종
			rs = st.executeQuery();
			
			rs.next();
			
			System.out.println(rs.getInt(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		
	}
	

}
