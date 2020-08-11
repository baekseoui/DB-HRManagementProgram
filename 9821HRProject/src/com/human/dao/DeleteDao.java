package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.human.dto.DepartmentsDto;
import com.human.dto.EmployeesDto;
import com.human.dto.LocationsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class DeleteDao {

	// --------퇴사
	public void employee_delete() {

		Scanner sc = new Scanner(System.in);
		Request request = new Request();
		Response response = new Response();
		EmployeesDto dto = new EmployeesDto();

		System.out.println("퇴사처리를 시작합니다.");
		String employee_id = null;

		while (true) {
			System.out.println("1) 퇴사 예정자 employeeId 입력>>");
			employee_id = sc.nextLine();
			if (checkString_int(employee_id)) {
				break;
			} else {
				System.out.println("정확한 employee_id를 정수로 입력하세요.");
			}
		}

		if (!exception_emp(0, employee_id)) {
			System.out.println("!!없는 employeeId 입니다.");
		} else {
			dto.setEmployeeId(Integer.parseInt(employee_id));
			System.out.println("2) 변경사항 입력(퇴사처리를 원할경우 RG입력)>>");
			String job_id = DBConn.inputString();

			dto.setJobId(job_id);
			request.setEmployeesDto(dto);

			int i = employee_deleteSql(dto.getEmployeeId(), dto.getJobId());
			response.setResultValue(i);

			System.out.println("알림☞  " + request.getEmployeesDto().getEmployeeId() + "번 직원의 퇴사처리가 "
					+ (request.getEmployeesDto().getJobId() + "로 완료되었습니다."));
		}
	}

	public int employee_deleteSql(int employee_id, String job_id) {

		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update employees " + "set job_id='%s' " + "where employee_id=%d";

		sql = String.format(sql, job_id, employee_id);
		returnValue = DBConn.StatementUpdate(sql);
		// DBConn.dbClose();

		return returnValue;
	}

	// --------지점 삭제
	public void locations_delete() {

		Scanner sc = new Scanner(System.in);
		LocationsDto dto = new LocationsDto();
		Request request = new Request();
		Response response = new Response();

		System.out.println("지점 삭제를 시작합니다");
		String location_id = null;

		while (true) {
			System.out.println("1) 삭제할 location_id 입력>>");
			location_id = sc.nextLine();
			if (checkString_int(location_id)) {
				break;
			} else {
				System.out.println("정확한 location_id를 정수로 입력하세요.");
			}
		}

		if (!exception_loca(0, location_id)) {
			System.out.println("!!없는 location_id 입니다.");
		} else {
			dto.setLocationId(Integer.parseInt(location_id));
			request.setLocationsDto(dto);

			int i = locations_deleteSpl(dto.getLocationId());
			response.setResultValue(i);
			System.out.println("알림☞ 해당 지점" + request.getLocationsDto().getLocationId() + "은(는) 삭제되었습니다.");
		}
	}

	public int locations_deleteSpl(int location_id) {
		// TODO Auto-generated method stub
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "delete locations " + "where location_id=%d";
		sql = String.format(sql, location_id);
		returnValue = DBConn.StatementUpdate(sql);
		// DBConn.dbClose();

		return returnValue;
	}

	// --------부서 삭제
	public void department_delete() {

		Scanner sc = new Scanner(System.in);
		DepartmentsDto dto = new DepartmentsDto();
		Request request = new Request();
		Response response = new Response();

		int answer = 0;

		System.out.println("부서 삭제를 시작합니다");
		String department_id = null;

		while (true) {
			System.out.println("1) 삭제할 department_id를 입력>>");
			department_id = sc.nextLine();
			if (checkString_int(department_id)) {
				break;
			} else {
				System.out.println("정확한 department_id를 정수로 입력하세요.");
			}
		}

		if (!exception_dep(0, department_id)) {
			System.out.println("!!없는 department_id 입니다.");
		} else {
			dto.setDepId(Integer.parseInt(department_id));

			request.setDepartmentsDto(dto);

			int i = department_deleteSpl(dto.getDepId());
			response.setResultValue(i);
			System.out.println("알림☞  department_id " + request.getDepartmentsDto().getDepId() + "인 부서가 삭제되었습니다.");
		}
	}

	public int department_deleteSpl(int department_id) {
		// TODO Auto-generated method stub
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "delete departments " + "where department_id=%d";
		sql = String.format(sql, department_id);
		returnValue = DBConn.StatementUpdate(sql);
		// DBConn.dbClose();

		return returnValue;
	}

	// -------- 퇴사 예외처리
	public boolean exception_emp(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>();
		DBConn.getInstance();
		String sql = "select * from Employees";
		ResultSet rs = DBConn.StatementQuery(sql);

		try {
			while (rs.next()) {
				ArrayList<String> dto = new ArrayList<String>();

				String str = "";
				str += rs.getInt("employee_id");
				dto.add(str);

				dto.add(rs.getString("first_name"));
				dto.add(rs.getString("last_name"));
				dto.add(rs.getString("email"));
				dto.add(rs.getString("phone_number"));
				dto.add(rs.getString("hire_date"));
				dto.add(rs.getString("job_id"));

//					dto.setEmployeeId(rs.getInt("employee_id"));
//					dto.setFirstName(rs.getString("first_name"));
//					dto.setLastName(rs.getString("last_name"));
//					dto.setEmail(rs.getString("email"));
//					dto.setPhoneNumber(rs.getString("phone_number"));
//					dto.setHireDate(rs.getString("hire_date"));
//					dto.setJobId(rs.getString("job_id"));

				str = "";
				str += rs.getInt("salary");
				dto.add(str);
//					dto.setsalary(rs.getInt("salary"));

				str = "";
				str += rs.getDouble("commission_pct");
				dto.add(str);
//					dto.setCommissionPct(rs.getDouble("commmission_pct"));

				str = "";
				str += rs.getInt("manager_id");
				dto.add(str);
//					dto.setManagerId(rs.getInt("manager_id"));

				str = "";
				str += rs.getInt("department_id");
				dto.add(str);
//					dto.setDepartmentId(rs.getInt("department_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).get(num).equals(find)) {
				return true;
			}
		}
		return false;
	}

	// -------- 지점삭제 예외처리
	public boolean exception_loca(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>(); // 테이블DTO
		DBConn.getInstance();
		String sql = "select * from locations"; // 테이블명
		ResultSet rs = DBConn.StatementQuery(sql);

		try {
			while (rs.next()) {
				ArrayList<String> dto = new ArrayList<String>();

				String str = "";
				str += rs.getInt("location_Id");
				dto.add(str);

				dto.add(rs.getString("street_Address"));
				dto.add(rs.getString("postal_Code"));
				dto.add(rs.getString("city"));
				dto.add(rs.getString("state_Province"));
				dto.add(rs.getString("country_Id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).get(num).equals(find)) {
				return true;
			}
		}
		return false;
	}

	// -------- 부서삭제 예외처리
	public boolean exception_dep(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>(); // 테이블DTO
		DBConn.getInstance();
		String sql = "select * from Departments"; // 테이블명
		ResultSet rs = DBConn.StatementQuery(sql);

		try {
			while (rs.next()) {
				ArrayList<String> dto = new ArrayList<String>();

				String str = "";
				str += rs.getInt("department_id");
				dto.add(str);
				dto.add(rs.getString("department_name"));

				str = "";
				str += rs.getInt("manager_id");
				dto.add(str);

				str = "";
				str += rs.getInt("location_id");
				dto.add(str);

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).get(num).equals(find)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkString_int(String input) {
		for (int i = 0; i < input.length(); i++) {
			// System.out.println(input.charAt(i));
			if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}
}
