package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConn {
	// .getInstance() <- �̱���
	// new DBConn(); ��������
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
			// ���α׷������� auto commit �⺻��

			rs = st.executeQuery(sql);
//			if (n == 1) { // n�� ����� ����
//				System.out.println("������");
//			} else {
//				System.out.println("��������");
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
			// ���α׷������� auto commit �⺻��

			resultValue = st.executeUpdate(sql);
//			if (n == 1) { // n�� ����� ����
//				System.out.println("������");
//			} else {
//				System.out.println("��������");
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
				// 1. ����� �����ͺ��̽� ����̹� ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("����̹� �ε��Ϸ�");
				// 2. �ش� �����ͺ��̽��� ����, url , user, pw �ʿ�
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
		System.out.println("���ڿ��Է�>>");
		return sc.nextLine();
	}

	public static int inputInt() {
		System.out.println("�����Է�>>");
		return Integer.parseInt(sc.nextLine());
	}

}
