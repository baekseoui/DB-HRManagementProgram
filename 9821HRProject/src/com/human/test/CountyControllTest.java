package com.human.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.human.dao.ActDB;
import com.human.dao.DeleteDao;
import com.human.dao.InsertDao;
import com.human.dao.SelectDao;
import com.human.dao.UpdateDao;

public class CountyControllTest {

	static Scanner sc = new Scanner(System.in);
	static DeleteDao ddao = new DeleteDao(); // 서의
	static UpdateDao udao = new UpdateDao(); // 하은
	static InsertDao jDao = new InsertDao(); // 희현
	static ActDB ad = new ActDB(); // 성준
	static SelectDao dao = new SelectDao(); // 성준

	static boolean a = true;

	static String sub_query = null;

	public static void main(String[] args) throws SQLException {

		int input;

		////////////////////////////// RG
//		jDao.insert_jobs("RG","Resignatio,"0","0");

		System.out.println("근태관리, 급여관리, 계약관리... \n귀찮고 반복적인 인사관리 업무?");
		System.out.println("이제 XXX에 맡기세요!");
		System.out.println("\n복잡하고 어려운 인사관리를 비교적 단순하게 관리하여 높은 효율성을 추구하며,");
		System.out.println("체계적인 인사관리 프로세스로 담당자가 바뀌어도 안정적인 운영이 가능합니다!");
		System.out.println("\n중소기업 경영자를 위한 XXX 서비스가\n여러분의 재무관리자가 되어 드리겠습니다.");
		System.out.println("\n문의: 02)1500-0000 | abc123@korea.com");
		System.out.println("\n[기능안내] \n*입퇴사자 관리 \n*조회 및 수정 \n*부서 관리 \n*신규 지점 등록및 변경 삭제  \n*급여관리");

		while (a) {
			System.out.println();
			System.out.println("=================================================");
			System.out.println("  1.직원관리      2.부서관리      3.기타관리      4.급여관리       5.종료");
			System.out.println("=================================================");
			System.out.println("메뉴를 입력하세요☞ ");
			input = Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				boolean flag = true;
				while (flag) {
					if(!one_1()) {
						break;
					}
				}
				break;
			case 2:
				while (!one_2()) {
				}
				break;

			case 3:
				while (!one_3()) {
				}
				break;

			case 4:
				while (!one_4()) {
				}

				break;
			case 5:
				a = false;
				System.out.println("종료되었습니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	public static boolean one_1() {

		boolean returnValue = true;

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println(" 직원관리    //  1.입사처리   2.퇴사처리   3.정보 변경   4.직원조회");
		System.out.println("-------------------------------------------------");
		int no1 = Integer.parseInt(sc.nextLine());
		switch (no1) {
		case 1: // 입사처리
			System.out.println();
			jDao.insert_employees();
			break;
		case 2: // 퇴사처리
			System.out.println();
			ddao.employee_delete();

			break;
		case 3: // 직원 수정
			System.out.println();
			System.out.println("정보 변경을 시작합니다! 해당하는 번호를 선택하세요");
			System.out.println("1.전화번호 변경   2.e-mail변경   3.직급 변경    ");
			int no2 = Integer.parseInt(sc.nextLine());
			switch (no2) {
			case 1: // 전화번호 변경
				udao.update_phoneNumber();
				break;
			case 2: // e-mail변경
				boolean flag = true;
				while (flag) {
					if (udao.update_email()) {
						break;
					}
				}
				break;
			case 3: // 직급 변경
				udao.update_job_id();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");

				break;
			}
			break;
		case 4:
			System.out.println();
			System.out.println("직원 조회를 시작합니다! 해당하는 번호를 선택하세요");
			System.out.println("1.전체조회   2.부서별조회   3.이름순 조회");
			int no3 = Integer.parseInt(sc.nextLine());
			switch (no3) {
			case 1: // 전체 조회
				ad = new ActDB();
				ad.getFieldSeq1 = "all";
				try {
					dao.search_employees(ad, 0, false, sub_query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2: // 부서별 조회
				ad = new ActDB();
				ad.getFieldSeq1 = "all";
				ad.order = true;
				ad.order_field_num_list.add(11);
				System.out.print("[오름차순 A, 내림차순D] 입력 >> ");
				String str = sc.nextLine();
				if (str.equals("A") || str.equals("D")) {
					ad.order_option_list.add(str);
				} else {
					System.out.println("올바른 입력이 아닙니다. 기본기능인 오름차순 정렬을 실시합니다.");
					ad.order_option_list.add("A");
				}
				try {
					dao.search_employees(ad, 0, false, sub_query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3: // 이름순 조회(오름차순)
				ad = new ActDB();
				ad.getFieldSeq1 = "all";
				ad.order = true;
				ad.order_field_num_list.add(2);
				ad.order_option_list.add("A");
				try {
					dao.search_employees(ad, 0, false, sub_query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			returnValue = false;
			break;
		}
		return returnValue;
	}

	public static boolean one_2() {

		boolean returnValue = true;

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("부서관리     //  1.부서등록   2.부서조회   3.부서수정   4.부서삭제");
		System.out.println("-------------------------------------------------");
		int no4 = Integer.parseInt(sc.nextLine());
		switch (no4) {
		case 1:
			System.out.println();
			InsertDao dDao = new InsertDao();
			dDao.insert_department();

			break;
		case 2: // Department_Id 내림차순
			System.out.println();
			dao.search_employees_departments_join();
			break;
		case 3: // 부서 수정
			System.out.println();
			udao.update_department_name();
			break;
		case 4:
			System.out.println();
			ddao.department_delete();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			returnValue = false;
			break;
		}
		return returnValue;
	}

	public static boolean one_3() {

		boolean returnValue = true;

		System.out.println(" ");
		System.out.println("----------------------------------------------------------");
		System.out.println(" 기타관리   //  1.신규지점등록  2.지점정보변경  3.지점삭제  4.지점조회  5.직무등록");
		System.out.println("----------------------------------------------------------");
		int no5 = Integer.parseInt(sc.nextLine());
		switch (no5) {
		case 1: // 신규 지점 등록
			jDao.insert_locations();
			break;
		case 2: // 지점 정보 변경
			udao.update_locations();
			break;
		case 3: // 지점 삭제
			ddao.locations_delete();
			break;
		case 4: // 지점 조회
			ad = new ActDB();
			dao.setActDB(ad);
			ad.columnlist_init();
			dao.search_locations(6, null);
			break;
		case 5: // 직무 등록
			jDao.insert_jobs();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			returnValue = false;
			break;
		}
		return returnValue;
	}

	private static boolean one_4() {
		boolean returnValue = true;
		System.out.println(" ");
		System.out.println("-------------------------------------------------");
		System.out.println(" 급여관리     //  1.부서별 조회   2.이름순 조회   3.연봉순 조회");
		System.out.println("-------------------------------------------------");
		int no6 = Integer.parseInt(sc.nextLine());
		switch (no6) {
		case 1: // 부서별
			ad = new ActDB();
			ad.getFieldSeq1 = "part";
			ad.getFieldSeq2 = "3";
			ad.getFieldSeq4.add("2");
			ad.getFieldSeq4.add("8");
			ad.getFieldSeq4.add("11");
			ad.order = true;
			ad.order_field_num_list.add(11);
			ad.order_option_list.add("A");
			ad.order_field_num_list.add(8);
			ad.order_option_list.add("A");
			try {
				dao.search_employees(ad, 0, false, sub_query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 0은 수학안쓰겠단 뜻임
			break;
		case 2: // 이름순
			ad = new ActDB();
			ad.getFieldSeq1 = "part";
			ad.getFieldSeq2 = "2";
			ad.getFieldSeq4.add("2");
			ad.getFieldSeq4.add("8");
			ad.order = true;
			ad.order_field_num_list.add(2);
			ad.order_option_list.add("A");
			ad.order_field_num_list.add(8);
			ad.order_option_list.add("A");
			try {
				dao.search_employees(ad, 0, false, sub_query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 0은 수학안쓰겠단 뜻임
			break;
		case 3: // 연봉순, select First_Name, Last_Name, Salary from employees order by salary
				// desc;
			ad = new ActDB();
			ad.getFieldSeq1 = "part";
			ad.getFieldSeq2 = "3";
			ad.getFieldSeq4.add("2");
			ad.getFieldSeq4.add("3");
			ad.getFieldSeq4.add("8");
			ad.order = true;
			ad.order_option_list.add("D");
			ad.order_field_num_list.add(8);
			try {
				dao.search_employees(ad, 0, false, sub_query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			returnValue = false;
			break;
		}
		return returnValue;
	}

}
