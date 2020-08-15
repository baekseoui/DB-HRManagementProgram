package hr.util;
//싱글턴으로 디비컨 하나만 만들어서 여럿에서 사용하기
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
		System.out.print("정수 입력");
		return Integer.parseInt(sc.nextLine());
	}
	public static double inputDouble() {
		System.out.println("실수 입력");
		return Double.parseDouble(sc.nextLine());
	}
	
	public static String inputString() {
		System.out.println("문자 입력");
		return sc.nextLine();
	}
	

	public static ResultSet statementQuery(String sql) {
		try {
			if(st==null) {
			st=dbConn.createStatement(); //데이터를 주고받을수 있도록 연결
			}
			//4.resultSet 얻어오기
			//resultSet 실행결과 sql
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
			// 프로그램에서는 오토커밋 자동으로 커밋됨
			
		    resultValue=st.executeUpdate(sql); //변경된 계수를 리턴
//			if(n==1) { //n은 변경된 개수가 리턴  하나 넣으면 1리턴 2개는 2
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록안되");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 데이터를 주고받을수 있도록 연결
		finally {
//			DBConn.dbClose();
		}
		
		return resultValue;
	}
	
	
	public static Connection getInstance() {
		if(dbConn==null) {
			try {
				// 1.데이터베이스 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2.해당 데이터베이스 접속 url,user,pw
				String url = "jdbc:oracle:thin:@localhost:1522:xe";
				String user = "hr";
				String pw = "human";
				dbConn = DriverManager.getConnection(url, user, pw);
				System.out.println("데이터베이스 접속 성공");


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
	//닫아주는 메소드
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
