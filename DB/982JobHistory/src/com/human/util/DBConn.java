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

		//.getInstnce() : �̱���, �ϳ��� ��ü�� ���� ����
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
				//4.ResultSet ������ ������
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
				//���α׷������� auto commit �⺻��
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
					//1.����� �����ͺ��̽� ����̺� ���
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("����̺�  �ε� �Ϸ�");
					
					//2.�ش� �����ͺ��̽� ���� : url, user, pw �ʿ�
					String url="jdbc:oracle:thin:@localhost:1521:xe";
					String user="hr";
					String pw="hr";
					
					dbConn=DriverManager.getConnection(url,user,pw);
					System.out.println("�����ͺ��̽� ���Ӽ���");
					
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
			System.out.print("���� �Է� : ");
			return Integer.parseInt(sc.nextLine());
		}
		
		public static String inputString() {
			System.out.println("���� ��¥ �����̶�� (yy/mm/dd)�������� �Է��ϼ���.");
			System.out.print("���� �Է� : ");
			return sc.nextLine();
		}
}
