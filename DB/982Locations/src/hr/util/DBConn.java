package hr.util;
//�̱������� ����� �ϳ��� ���� �������� ����ϱ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DBConn {
	//.getInstance()
	//new DBConn();
	private DBConn() {};
	private static Connection dbConn=null;
	private static Statement st = null;
	private static ResultSet rs=null;
	private static Scanner sc=new Scanner(System.in);
	
	public static int inputInt() {
		System.out.print("���� �Է�");
		return Integer.parseInt(sc.nextLine());
	}
	public static double inputDouble() {
		System.out.println("�Ǽ� �Է�");
		return Double.parseDouble(sc.nextLine());
	}
	
	public static String inputString() {
		System.out.println("���� �Է�");
		return sc.nextLine();
	}
	

	public static ResultSet statementQuery(String sql) {
		try {
			if(st==null) {
			st=dbConn.createStatement(); //�����͸� �ְ������ �ֵ��� ����
			}
			//4.resultSet ������
			//resultSet ������ sql
			rs=st.executeQuery(sql);

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
			// ���α׷������� ����Ŀ�� �ڵ����� Ŀ�Ե�
			
		    resultValue=st.executeUpdate(sql); //����� ����� ����
//			if(n==1) { //n�� ����� ������ ����  �ϳ� ������ 1���� 2���� 2
//				System.out.println("������");
//			} else {
//				System.out.println("��Ͼȵ�");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // �����͸� �ְ������ �ֵ��� ����
		finally {
//			DBConn.dbClose();
		}
		
		return resultValue;
	}
	
	
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				// 1.�����ͺ��̽� ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.�ش� �����ͺ��̽� ���� url,user,pw
				String url = "jdbc:oracle:thin:@localhost:1522:xe";
				String user = "hr";
				String pw = "human";
				dbConn = DriverManager.getConnection(url, user, pw);
				System.out.println("�����ͺ��̽� ���� ����");


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
	//�ݾ��ִ� �޼ҵ�
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
	
	
}
