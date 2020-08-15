package com.human.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConn {
	private DBConn() {};
	private static Connection dbConn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	private static Scanner sc=new Scanner(System.in);
	
	public static ResultSet statementQuery(String sql) {
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			rs=st.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {}
		return rs;
	}
	public static int statementUpdate(String sql) {
		int resultValue=0;
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			resultValue=st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {}
		return resultValue;
	}
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="human";
				String pw="human";
				dbConn=DriverManager.getConnection(url,user,pw);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(dbConn!=null)dbConn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			rs=null;
			st=null;
			dbConn=null;
		}
	}
	public static int inputInt() {
		System.out.println("정수를 입력하세요.");
		return Integer.parseInt(sc.nextLine());
	}
	public static String inputString() {
		System.out.println("문자를 입력하세요.");
		return sc.nextLine();
	}
	
}
