package com.iu.s1;

import com.iu.s1.location.LocationDAO;
import com.iu.s1.test.DBTest;

public class DBMain {
	
	public static void main(String[] args) {
		System.out.println("DB Start");
		
		//클래스명 변수명 = new 생성자()
		DBTest dbTest = new DBTest();
		dbTest.getCount();
		//dbTest.getOne();
		//멤버 사용
		//참조변수명.변수명, 참조변수명.메서드명()
		//dbTest.connectTest();
		
		LocationDAO dao = new LocationDAO();
		//dao.getList();
		
		
		System.out.println("DB Finish");
	}

}
