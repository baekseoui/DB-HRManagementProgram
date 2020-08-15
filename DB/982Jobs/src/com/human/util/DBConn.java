package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConn {
	// .getInstance() <- 싱글턴
	// new DBConn(); 생성방지
	private DBConn() {
	};

	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	
	public static ResultSet statementQuery(String sql) {
		try {
			if(st==null) {
				st = dbConn.createStatement();
			}
			// 프로그램에서는 auto commit 기본값

			rs = st.executeQuery(sql);
//			if (n == 1) { // n은 변경된 개수
//				System.out.println("정상동작");
//			} else {
//				System.out.println("비정상동작");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			DBConn.dbClose();
		}
		return rs;
	}
	
	public static int statementUpdate(String sql) {
		int resultValue=0;
		
//		DBConn.getInstance();

		try {
			if(st==null) {
				st = dbConn.createStatement();
			}
			// 프로그램에서는 auto commit 기본값

			resultValue = st.executeUpdate(sql);
//			if (n == 1) { // n은 변경된 개수
//				System.out.println("정상동작");
//			} else {
//				System.out.println("비정상동작");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			DBConn.dbClose();
		}
		return resultValue;
	}
	
	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				// 1. 사용할 데이터베이스 드라이버 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩완료");
				// 2. 해당 데이터베이스에 접속, url , user, pw 필요
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "0000";

				dbConn = DriverManager.getConnection(url, user, pw);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return dbConn;

	}

	public static void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (dbConn != null)
				dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			dbConn = null;
		}
	}

	public static String inputString() {
		System.out.println("문자열입력>>");
		return sc.nextLine();
	}

	public static int inputInt() {
		System.out.println("정수입력>>");
		return Integer.parseInt(sc.nextLine());
	}

}
