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

	//.getInstance()	싱글턴 : 객체를 한개만 생성
	//new DBConn() 작업을 막아야함 아니면 객체가 생성됨
	
	private static Scanner sc = new Scanner(System.in);
	private DBConn() {};						//private 외부에서 호출할수 없음 
	private static Connection dbConn = null;	//제어자가  private //인스턴스를 생성못하기에 static 사용 
	private static Statement st = null;
	private static ResultSet rs = null;
	
	
	//1.드라이버 로딩 메소드
	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				//1.드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.데이터베이스 연결: url, user, pw
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "hr";
				
				dbConn = DriverManager.getConnection(url,user,pw);
		
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("로딩완료");
		return dbConn;
	}
	
	
	
	//sql문 실행 입력 메소드
	public static int inputInt() {
		System.out.print("정수입력>>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static Double inputDouble() {
		System.out.print("실수입력>>");
		return Double.parseDouble(sc.nextLine());
	}
	public static Date inputDate() {
		Date returnvalue = null;
		System.out.print("날짜입력(yyyy-MM-dd HH:mm:ss)>>");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String inputString = sc.nextLine();
		
		try {
			returnvalue = transFormat.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return returnvalue;
	}
	
	public static String inputString() {
		System.out.print("문자열입력>>");
		return sc.nextLine();
	}
	
	public static String dateToString(Date a) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(a);
	}
	
	
	
	
	
	
	//sql문 실행 메소드
	public static void StatementUpdate(String sql){
		int resultvalue=0;
		
		if(st ==null) {
			try {
				st = dbConn.createStatement();
				resultvalue = st.executeUpdate(sql);
				
				if(resultvalue>0) {
					System.out.println("정상동작");
				}else {
					System.out.println("비정상동작");
				}
			} catch (SQLException e) {
			
			}
		}
		
		
	}
	
	//sql문 출력(select) 메소드
	public static ResultSet statementQuery(String sql){
		
		if(rs==null) {
			try {
				st = dbConn.createStatement();
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}
	

	
	
	//datebace 닫는 메소드
	public static void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(dbConn!=null)dbConn.close();
		}catch(SQLException e) {
			
		}finally {
			rs=null;
			st=null;
			dbConn = null;
		}
	}	
}

