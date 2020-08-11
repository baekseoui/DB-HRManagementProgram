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

public class UpdateDao {
	Scanner sc = new Scanner(System.in);

	// -------- 예외처리
	public boolean exception_emp(int num, String find) {
		// 어레이리스트 안에 스트링을 담을 수 있는 어레이리스트 넣어줌으로써 스트링을 넣을 수 있는 2차원 배열 생성합니다. 
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>();
		DBConn.getInstance();
		//임플로이 테이블에 모든 정보를 받아서 2차원 배열에 저장합니다. 이때 열에는 데이터베이스 컬럼값을 의미하고. 
		//행은 사원 한명당 정보를 의미하게 됩니다.
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
				// 원래는 디티오 클래스에 값넣어주는 거였는데, 디티오를 클래스가 아닌 어레이리스트로 해서 넣어줬다. 

				str = "";
				str += rs.getInt("salary");
				dto.add(str);
				//스트링을 넣는 배열이라 스트링으로 받기 위해서 dto에 저장하기 전에 정수값인 샐러리를 스트링으로 바꾸어서 
				//dto에 저장합니다.
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

				//여기까지가 한 사원의 정보였다면, 다음사원의 정보인 행도  저장하기 위해서 어레이리스트에 방금만든 스트링 어레이리스트를 
				//추가해줍니다. (dtos)
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//이 포문은 각각의 행을 탐색합니다. 
		for (int i = 0; i < dtos.size(); i++) {//이 함수는 컬럼에 해당하는 정수값과 그 컬럼에서 비교하고 싶은 스트링값을 매개변수로 받는데,
			//예를 들어, 행에 값을 저장할 때 첫번째로 저장되는 것이 임플로이 아이디라 매개변수 인트 넘은 1일 것이므로 첫번째 열을 탐색하면
			//파인드와 같은 값이 있는지 찾게 됩니다. 
			//이때 같은 값이 있다면, 트루를 리턴하고 이 함수를 종료하게 됩니다. 
			if (dtos.get(i).get(num).equals(find)) {
				return true;
			}
		}
		//포문을 다 돌아도 같은 값이 없을때 폴스를 반환하고 함수를 종료합니다. 
		return false;
	}

	// -------- 예외처리
	public boolean exception_loca(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>();
		DBConn.getInstance();
		String sql = "select * from locations";
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

	// -------- 예외처리
	public boolean exception_dep(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>();
		DBConn.getInstance();
		String sql = "select * from Departments";
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

	// -------- phone_Number 변경
	public void update_phoneNumber() {
		EmployeesDto dto = new EmployeesDto();
		Request request = new Request();
		Response response = new Response();

		System.out.println("연락처를 변경합니다.");
		System.out.println("1) 정보 수정을 원하는 employeeId 입력>>");

		String emp_id = sc.nextLine();

		if (!exception_emp(0, emp_id)) {
			// false면
			System.out.println("!!없는 employee_id 입니다.");
		} else {
			// true면
			dto.setEmployeeId(Integer.parseInt(emp_id));

			System.out.println("2) 변경할 phoneNumber 입력>>");
			String phone_number = DBConn.inputString();
			dto.setPhoneNumber(phone_number);

			request.setEmployeesDto(dto);

			int i = update_phoneNumberSql(dto.getEmployeeId(), dto.getPhoneNumber());
			response.setResultValue(i);

			System.out.println("알림☞ " + request.getEmployeesDto().getEmployeeId() + "번 직원의 전화번호가 "
					+ (request.getEmployeesDto().getPhoneNumber() + "로 변경되었습니다."));

		}

		// String employee_id = DBConn.inputi();
		// 100번 입력 . 그 함수안에서 조회해서 100번이 있으면 실행. 없으면 없다고 종료.
	}

	public int update_phoneNumberSql(int employee_id, String phone_number) {

		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update employees " + "set phone_number='%s' " + "where employee_id=%d";

		sql = String.format(sql, phone_number, employee_id);
		returnValue = DBConn.StatementUpdate(sql);

		return returnValue;
	}

	// -------- 직책 변경 (job_Id , salary)
	public void update_job_id() {

		EmployeesDto dto = new EmployeesDto();
		Request request = new Request();
		Response response = new Response();

		System.out.println("직책을 변경합니다.");
		System.out.println("1) 정보 수정을 원하는 employeeId 입력>>");
		String emp_id = sc.nextLine();

		if (!exception_emp(0, emp_id)) {
			// false면
			System.out.println("!!없는 employee_id 입니다.");
		} else {

			dto.setEmployeeId(Integer.parseInt(emp_id));

			System.out.println("2) 변경할 job_id 입력");
			String job_id = DBConn.inputString();

			dto.setJobId(job_id);

			request.setEmployeesDto(dto);

			int i = update_job_idSql(dto.getEmployeeId(), dto.getJobId());
			response.setResultValue(i);

			System.out.println("알림☞ " + request.getEmployeesDto().getEmployeeId() + "번 직원의 직책이 "
					+ (request.getEmployeesDto().getJobId() + "로 변경되었습니다."));

		}
	}

	public int update_job_idSql(int employee_id, String job_id) {

		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update employees " + "set employee_id='%s', job_id='%s' ,salary= "
				+ "( select((min_salary+max_salary)*0.5) from jobs where job_id='%s') " + "where employee_id=%d";

		sql = String.format(sql, employee_id, job_id, job_id, employee_id);
		returnValue = DBConn.StatementUpdate(sql);
		// DBConn.dbClose();

		return returnValue;
	}

	// -------- email 변경
	public boolean update_email() {

		EmployeesDto dto = new EmployeesDto();

		System.out.println("email을 변경합니다.");
		System.out.println("1) 정보 수정을 원하는 employeeId 입력>>");
		String emp_id = sc.nextLine();

		if (!exception_emp(0, emp_id)) {
			// false면 
			System.out.println("!!없는 employee_id 입니다.");
			return false;
		} else {
			dto.setEmployeeId(Integer.parseInt(emp_id));
			System.out.println("2) 변경할 email 입력>>");
			String email = DBConn.inputString();
			// 트루일 경우는 변경할 수 있습니다. 
			// 디티오에 값을 셋하면 이메일 들어갑니다. 
			dto.setEmail(email);
			
			update_emailSql(dto.getEmployeeId(), dto.getEmail());
			
			System.out.println("알림☞ " + dto.getEmployeeId() + "번 직원의 email이 "
					+ (dto.getEmail() + "로 변경되었습니다."));
			return true;
		}
	}

	public void update_emailSql(int employee_id, String email) {

		DBConn.getInstance();
//db연결하고
		String sql = "update employees " + "set email='%s' " + "where employee_id=%d";
//쿼리문 형식을 선언하고 매개변수를 넣고 쿼리문 완성합니다.
		sql = String.format(sql, email, employee_id);
		DBConn.StatementUpdate(sql);
	}

	// -------- 부서명 변경 수정
	public void update_department_name() {

		DepartmentsDto dto = new DepartmentsDto();
		Request request = new Request();
		Response response = new Response();
		System.out.println("부서 정보를 변경합니다");
		System.out.println("1) 정보 수정을 원하는 dept_id 입력>> ");
		String dept_id = sc.nextLine();

		if (!exception_dep(0, dept_id)) {
			System.out.println("!!없는 부서 입니다.");
		} else {
			dto.setDepId(Integer.parseInt(dept_id));

			System.out.println("2) 변경할 부서명 입력 >>");
			String departments_name = DBConn.inputString();

			dto.setDepName(departments_name);

			request.setDepartmentsDto(dto);

			int i = update_department_nameSql(dto.getDepId(), dto.getDepName());
			response.setResultValue(i);

			System.out.println("알림☞ " + request.getDepartmentsDto().getDepId() + "번 부서의 부서명이 "
					+ (request.getDepartmentsDto().getDepName() + "로 변경되었습니다."));

		}

	}

	public int update_department_nameSql(int department_id, String department_name) {

		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update departments " + "set department_name='%s' " + "where department_id=%d";

		sql = String.format(sql, department_name, department_id);
		returnValue = DBConn.StatementUpdate(sql);

		return returnValue;
	}

	// -------- 지점 변경(도시,우편번호,주소) 수정
	public void update_locations() {

		LocationsDto dto = new LocationsDto();
		Request request = new Request();
		Response response = new Response();

		System.out.println("지점 정보를 변경합니다");
		System.out.println("1) 정보 수정을 원하는location_id 입력>> ");
		String loc_id = sc.nextLine();

		if (!exception_loca(0, loc_id)) {
			System.out.println("!!없는 지점입니다.");
		} else {
			dto.setLocationId(Integer.parseInt(loc_id));

			System.out.println("2) 도시 입력 >>");
			String city = DBConn.inputString();
			System.out.println("3) 우편번호 입력 >>");
			String postal_code = DBConn.inputString();
			System.out.println("4) 주소 입력 >>");
			String street_adress = DBConn.inputString();

			dto.setCity(city);
			dto.setPostalCode(postal_code);
			dto.setStreetAddress(street_adress);

			request.setLocationsDto(dto);

			int i = update_locationsSql(dto.getLocationId(), dto.getCity(), dto.getPostalCode(),
					dto.getStreetAddress());
			response.setResultValue(i);

			System.out.println(request.getLocationsDto().getLocationId() + "번 지점의 주소가  \n"
					+ ("city : " + request.getLocationsDto().getCity() + "\npostal_code : "
							+ request.getLocationsDto().getPostalCode() + "\nstreet_address : "
							+ request.getLocationsDto().getStreetAddress() + "로 변경되었습니다."));

		}
	}

	public int update_locationsSql(int location_id, String city, String postal_code, String street_address) {

		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update locations " + "set city='%s', postal_code='%s', street_address='%s' "
				+ "where location_id=%d";

		sql = String.format(sql, city, postal_code, street_address, location_id);
		returnValue = DBConn.StatementUpdate(sql);

		return returnValue;
	}
}
