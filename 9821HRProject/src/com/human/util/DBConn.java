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
	static Scanner sc = new Scanner(System.in);

	// .getInstance()
	// new DBConn();
	private DBConn() {
	};

	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static int StatementUpdate(String sql) {
		int resultValue = 0;
		DBConn.getInstance();
		try {
			if (st == null) {

				st = dbConn.createStatement();

			}
			// 프로그램에서는 auto commit 기본값
			resultValue = st.executeUpdate(sql);
			// if(n==1) {//n은 변경된 개수
			// System.out.println("정상동작");
			// }else {
			// System.out.println("비정상동작");
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DBConn.dbClose();
		}

		return resultValue;
	}

	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				// 1.사용할 데이터베이스 드라이브 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.해당 데이터베이스에 접속 url,user,pw
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw = "human";
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
			if (st != null)
				st.close();
			if (dbConn != null)
				dbConn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn = null;
		}
	}

	public static ResultSet StatementQuery(String sql) {
		try {
			if (st == null) {
				st = dbConn.createStatement();
			}

			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return rs;
	}

	public static int inputInt() {
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}

	public static String inputString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static Date inputDate() {
		Date returnValue = null;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("날짜 입력(yyyy-MM-dd )>>");
		String inputString = sc.nextLine();
		try {
			returnValue = (Date) transFormat.parse(inputString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public static String dateToString(Date d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}

	public static double inputDouble() {
		Scanner sc = new Scanner(System.in);
		System.out.println("실수입력>>");
		return Double.parseDouble(sc.nextLine());
	}
}
