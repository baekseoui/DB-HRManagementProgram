package com.human.util;
	import java.sql.Connection;
	import java.util.Date;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Scanner;
	
public class DBConn {

		//.getInstnce() : 싱글턴, 하나의 객체만 생성 가능
		private DBConn() {};
		private static Connection dbConn=null;
		private static Statement st=null;
		private static ResultSet rs=null;
		private static Scanner sc=new Scanner(System.in); 
		
		public static ResultSet statementQuerry(String sql) {
			try {
				if(st==null) {
					st=dbConn.createStatement();
				}
				//4.ResultSet 얻어오기 실행결과
				rs=st.executeQuery(sql);
				
			} catch (SQLException e) {			
				e.printStackTrace();			
			}finally {
			
			}
			return rs;
		}
		
		
		public static int statementUpdate(String sql) {
			int resultValue=0;
			
			DBConn.getInstance();
					
			try{
				if(st==null) {
					st=dbConn.createStatement();
				}
				//프로그램에서는 auto commit 기본값
				resultValue=st.executeUpdate(sql);
						
			}catch (SQLException e) {			
				e.printStackTrace();
			
			}finally {
				DBConn.dbClose();
			}		
			return resultValue;
		}
		
		
		public static Connection getInstance() {
			if(dbConn==null) {
				try {
					//1.사용할 데이터베이스 드라이브 등록
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("드라이브  로딩 완료");
					
					//2.해당 데이터베이스 접속 : url, user, pw 필요
					String url="jdbc:oracle:thin:@localhost:1521:xe";
					String user="hr";
					String pw="hr";
					
					dbConn=DriverManager.getConnection(url,user,pw);
					System.out.println("데이터베이스 접속성공");
					
				} catch (ClassNotFoundException e) {			
					e.printStackTrace();
					
				} catch (SQLException e) {			
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
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				rs=null;
				st=null;
				dbConn=null;
			}
		}
		
		public static int inputInt(){
			System.out.print("정수 입력 : ");
			return Integer.parseInt(sc.nextLine());
		}
		
		public static String inputString() {
			System.out.println("만약 날짜 형식이라면 (yy/mm/dd)형식으로 입력하세요.");
			System.out.print("문자 입력 : ");
			return sc.nextLine();
		}
}
