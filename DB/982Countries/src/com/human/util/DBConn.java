package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DBConn {
	Scanner sc=new Scanner(System.in);
	//.getInstance()
	//new DBConn();
	private DBConn() {};
	private static Connection dbConn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	public static int StatementUpdate(String sql) {
		int resultValue=0;
		// DBConn.getInstance();
		try {
			if(st==null) {
				st = dbConn.createStatement();
			}
		//���α׷������� auto commit �⺻��
		resultValue=st.executeUpdate(sql);
		// if(n==1) {//n�� ����� ����
		// System.out.println("������");
		// }else {
		// System.out.println("��������");
		// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// DBConn.dbClose();
		}
		
		return resultValue;
	}
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				//1.����� �����ͺ��̽� ����̺� ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//2.�ش� �����ͺ��̽��� ���� url,user,pw
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="human";
				String pw="human";
				dbConn=DriverManager.getConnection(url,user,pw);
				
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
			if(st!=null)st.close();
			if(dbConn!=null)dbConn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConn=null;
		}
	}
	public static ResultSet StatementQuery(String sql) {
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			rs=st.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		}
		return rs;
	}
	public static int inputInt() {
		Scanner sc=new Scanner(System.in);
		System.out.println("�����Է�>>");
		return Integer.parseInt(sc.nextLine());
	}
	public static String inputString() {
		Scanner sc=new Scanner(System.in);
		System.out.println("�����Է�>>");
		return sc.nextLine();
	}
}
