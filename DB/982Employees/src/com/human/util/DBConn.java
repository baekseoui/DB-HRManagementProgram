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

	//.getInstance()	�̱��� : ��ü�� �Ѱ��� ����
	//new DBConn() �۾��� ���ƾ��� �ƴϸ� ��ü�� ������
	
	private static Scanner sc = new Scanner(System.in);
	private DBConn() {};						//private �ܺο��� ȣ���Ҽ� ���� 
	private static Connection dbConn = null;	//�����ڰ�  private //�ν��Ͻ��� �������ϱ⿡ static ��� 
	private static Statement st = null;
	private static ResultSet rs = null;
	
	
	//1.����̹� �ε� �޼ҵ�
	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				//1.����̹� �ε�
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.�����ͺ��̽� ����: url, user, pw
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
		System.out.println("�ε��Ϸ�");
		return dbConn;
	}
	
	
	
	//sql�� ���� �Է� �޼ҵ�
	public static int inputInt() {
		System.out.print("�����Է�>>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static Double inputDouble() {
		System.out.print("�Ǽ��Է�>>");
		return Double.parseDouble(sc.nextLine());
	}
	public static Date inputDate() {
		Date returnvalue = null;
		System.out.print("��¥�Է�(yyyy-MM-dd HH:mm:ss)>>");
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
		System.out.print("���ڿ��Է�>>");
		return sc.nextLine();
	}
	
	public static String dateToString(Date a) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(a);
	}
	
	
	
	
	
	
	//sql�� ���� �޼ҵ�
	public static void StatementUpdate(String sql){
		int resultvalue=0;
		
		if(st ==null) {
			try {
				st = dbConn.createStatement();
				resultvalue = st.executeUpdate(sql);
				
				if(resultvalue>0) {
					System.out.println("������");
				}else {
					System.out.println("��������");
				}
			} catch (SQLException e) {
			
			}
		}
		
		
	}
	
	//sql�� ���(select) �޼ҵ�
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
	

	
	
	//datebace �ݴ� �޼ҵ�
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

