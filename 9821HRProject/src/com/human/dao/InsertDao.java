package com.human.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.human.dto.CountriesDto;
import com.human.dto.DepartmentsDto;
import com.human.dto.EmployeesDto;
import com.human.dto.JobsDto;
import com.human.dto.LocationsDto;
import com.human.dto.RegionsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class InsertDao {
	Scanner sc = new Scanner(System.in);
	public Connection dbConn = null;
	public Statement st = null;
//	public ResultSet rs = null;

	public InsertDao() {

		// --------Connection ����
		try {
			// 1.����� �����ͺ��̽� ����̺� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�ش� �����ͺ��̽��� ���� url,user,pw
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

		// statement ����
		try {
			st = dbConn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startDB() {
		// --------Connection ����
		try {
			// 1.����� �����ͺ��̽� ����̺� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�ش� �����ͺ��̽��� ���� url,user,pw
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "human";
			String pw = "human";
			dbConn = DriverManager.getConnection(url, user, pw);
			// System.out.println("�����ͺ��̽���
			// ���ӵǾ����ϴ�.####################################################");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startStat() {
		// --------statement ����
		try {
			st = dbConn.createStatement();
			// System.out.println("statement��
			// �����Ǿ����ϴ�.####################################################");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeStat() {
		try {
			st.close();
			// System.out.println("statement��
			// ����Ǿ����ϴ�.####################################################");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeDB() {

		try {
			dbConn.close();
			// System.out.println("�����ͺ��̽� ������
			// �����Ǿ����ϴ�.####################################################");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------employees �����߰�
	public void insert_employees() {
		EmployeesDto dto = new EmployeesDto();
		Request request = new Request();
		Response response = new Response();

		closeDB();
		startDB();

		
		String employee_id = null; 
		
		boolean flag = true;
		while (flag) {
			System.out.println("������ �߰��մϴ�.");
			System.out.println("1) �߰��� employeeId �Է�>>");
			employee_id= sc.nextLine();
			if(checkString_int(employee_id)) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

		if (exception_emp(0, employee_id)) {
			System.out.println("!!�̹� �����ϴ� �����Դϴ�.");
		} else {

			System.out.println("2) first_name �Է�>>");
			String first_name = DBConn.inputString();

			System.out.println("3) last_name �Է�>>");
			String last_name = DBConn.inputString();

			System.out.println("4) email �Է�>>");
			String email = DBConn.inputString();

			System.out.println("5) phone_number�� �Է�>>");
			String phone_number = DBConn.inputString();

			System.out.println("6) hire_date �Է�>>");
			// Date hire_date = DBConn.inputDate();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// String dtype = formatter.format(hire_date);
			System.out.print("��¥ �Է�(yyyy-MM-dd )>>");
			String dtype = sc.nextLine();

			search_jobs_id();
			System.out.println("7) job_id �Է�>>");
			String job_id = DBConn.inputString();

			
			String salary = null;
			while(flag) {
				System.out.println("8) salary �Է�>>");
				salary = sc.nextLine();
				if(checkString_int(salary)) {
					break;
				}
				System.out.println("�ٽ� �Է����ּ���");
			}

			String commission_pct = "";
			while(flag) {
				System.out.println("9) commission_pct�� �Է�>>");
				commission_pct = sc.nextLine();
				if(checkString_double(commission_pct)) {
					break;
				}
				System.out.println("�ٽ� �Է����ּ���");
			}
			

			System.out.println("10) managerId �Է�>>");
			int manager_id = DBConn.inputInt();

			search_dept_id();
			System.out.println("11) departmentId �Է�>>");
			int department_id = DBConn.inputInt();

			dto.setEmployeeId(Integer.parseInt(employee_id));
			dto.setFirstName(first_name);
			dto.setLastName(last_name);
			dto.setEmail(email);
			dto.setPhoneNumber(phone_number);
			dto.setHireDate(dtype);
			dto.setJobId(job_id);
			dto.setsalary(Integer.parseInt(salary));
			dto.setCommissionPct(Double.parseDouble(commission_pct));
			dto.setManagerId(manager_id);
			dto.setDepartmentId(department_id);

			request.setEmployeesDto(dto);
			response.getArrEmployeesDto();

			insert_ex(dto.getEmployeeId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPhoneNumber(),
					dto.getHireDate(), dto.getJobId(), dto.getsalary(), dto.getCommissionPct(), dto.getManagerId(),
					dto.getDepartmentId());
			// response.setResultValue(i);

			System.out.println("�˸��� " + request.getEmployeesDto().getEmployeeId() + "�� ������ �߰��Ǿ����ϴ�.");
			closeDB();
		}
	}

	public String inputJobID(String job_id) {
		String returnValue = null;
		boolean flag = true;
		while (flag) {
			switch (job_id) {
			case "1":
				returnValue = "IT_PROG";
				flag = false;
				break;
			case "2":
				returnValue = "ST_MAN";
				flag = false;
				break;
			case "3":
				returnValue = "ST_CLERK";
				flag = false;
				break;
			case "4":
				returnValue = "SA_MAN";
				flag = false;
				break;
			case "5":
				returnValue = "SA_REP";
				flag = false;
				break;
			case "6":
				returnValue = "AD_ASST";
				flag = false;
				break;
			case "7":
				returnValue = "MK_MAN";
				flag = false;
				break;
			case "8":
				returnValue = "MK_REP";
				flag = false;
				break;
			case "9":
				returnValue = "MK_REP";
				flag = false;
				break;
			case "10":
				returnValue = "AC_MGR";
				flag = false;
				break;
			case "11":
				returnValue = "AC_ACCOUNT";
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
		return returnValue;
	}

	public int insert_ex(int employee_id, String first_name, String last_name, String email, String phone_number,
			String hire_date, String job_id, int salary, double commission_pct, int manager_id, int department_id) {
		startDB();
		int returnValue = 0;
		// DBConn.getInstance();
		String sql = "INSERT INTO employees " + "VALUES (%d,'%s','%s','%s','%s'," + "to_date('%s','yyyy-mm-dd'),"
				+ "'%s',%d,%f,%d,%d)";

		sql = String.format(sql, employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary,
				commission_pct, manager_id, department_id);
		System.out.println(sql);

		startStat();
		try {
			if (st == null) {
				st = dbConn.createStatement();
			}
			returnValue = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DBConn.StatementUpdate(sql);
		// DBConn.closeStatement();
		// DBConn.dbClose();
		System.out.println("�Ϸ�");
		closeStat();
		closeDB();
		return returnValue;
	}

	// --------locations ���� �߰�
	public void insert_locations() {
		Request request = new Request();
		Response response = new Response();

		System.out.println("�ű� ������ �߰��մϴ�.");
		System.out.println("1) �߰��� location_id �Է�>>");
		String location_id = DBConn.inputString();
		if (exception_loca(0, location_id)) {
			System.out.println("!!�̹� �����ϴ� �����Դϴ�.");
		} else {

			System.out.println("2) street_address �Է�>>");
			String street_address = DBConn.inputString();

			System.out.println("3) postal_code �Է�>>");
			String postal_code = DBConn.inputString();

			System.out.println("4) city �Է�>>");
			String city = DBConn.inputString();

			System.out.println("5) state_province�� �Է�>>");
			String state_province = DBConn.inputString();

			search_countries();
			System.out.println("6) country_id�� �Է�>>");
			String country_id = DBConn.inputString();

			LocationsDto lDto = new LocationsDto();
			lDto.setLocationId(Integer.parseInt(location_id));
			lDto.setStreetAddress(street_address);
			lDto.setPostalCode(postal_code);
			lDto.setCity(city);
			lDto.setStateProvince(state_province);
			lDto.setCountryId(country_id);

			request.setLocationsDto(lDto);
			response.getArrLocationsDto();

			int i = insert_location(lDto.getLocationId(), lDto.getStreetAddress(), lDto.getPostalCode(), lDto.getCity(),
					lDto.getStateProvince(), lDto.getCountryId());
			response.setResultValue(i);

			System.out.println("�˸��� " + request.getLocationsDto().getCity() + "������ �߰��Ǿ����ϴ�.");

		}
	}

	public int insert_location(int location_id, String street_address, String postal_code, String city,
			String state_province, String country_id) {
		startDB();
		startStat();
		int returnValue = 0;
//		DBConn.getInstance();
		String sql = "INSERT INTO LOCATIONS " + "VALUES (%d,'%s','%s','%s','%s','%s')";

		sql = String.format(sql, location_id, street_address, postal_code, city, state_province, country_id);
		System.out.println(sql);
		try {
			returnValue = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		DBConn.dbClose();
		closeStat();
		closeDB();
		System.out.println("�Ϸ�");
		return returnValue;
	}

	// --------jobs ���� �߰�
	public void insert_jobs() {
		Request request = new Request();
		Response response = new Response();

		System.out.println("�ű� ������ �߰��մϴ�.");
		System.out.println("1) job_Id�� �Է�>>");
		String jobId = DBConn.inputString();
		if (exception_jobs(0, jobId)) {
			System.out.println("!!�̹� �����ϴ� �����Դϴ�.");
		} else {

			System.out.println("2) jobTitle�� �Է�>>");
			String jobTitle = DBConn.inputString();
			System.out.println("3) minSalary �Է�>>");
			String minSalary = DBConn.inputString();
			System.out.println("4) maxSalary �Է�>>");
			String maxSalary = DBConn.inputString();

			JobsDto jDto = new JobsDto();
			jDto.setJobId(jobId);
			jDto.setJobTitle(jobTitle);
			jDto.setMinSalary(Integer.parseInt(minSalary));
			jDto.setMaxSalary(Integer.parseInt(maxSalary));

			request.setJobsDto(jDto);
			response.getArrJobsDto();

			int i = insert_jobs(jDto.getJobId(), jDto.getJobTitle(), jDto.getMinSalary(), jDto.getMaxSalary());
			response.setResultValue(i);
		}
	}

	public void insert_jobs(String jobId, String jobTitle, String minSalary, String maxSalary) {
		Request request = new Request();
		Response response = new Response();

//		System.out.println("�ű� ������ �߰��մϴ�.");
//		System.out.println("1) job_Id�� �Է�>>");
//		String jobId = DBConn.inputString();
//		if (exception_jobs(0, jobId)) {
//			System.out.println("!!�̹� �����ϴ� �����Դϴ�.");
//		} else {
//
//			System.out.println("2) jobTitle�� �Է�>>");
//			String jobTitle = DBConn.inputString();
//			System.out.println("3) minSalary �Է�>>");
//			String minSalary = DBConn.inputString();
//			System.out.println("4) maxSalary �Է�>>");
//			String maxSalary = DBConn.inputString();

		JobsDto jDto = new JobsDto();
		jDto.setJobId(jobId);
		jDto.setJobTitle(jobTitle);
		jDto.setMinSalary(Integer.parseInt(minSalary));
		jDto.setMaxSalary(Integer.parseInt(maxSalary));

		request.setJobsDto(jDto);
		response.getArrJobsDto();

		int i = insert_jobs(jDto.getJobId(), jDto.getJobTitle(), jDto.getMinSalary(), jDto.getMaxSalary());
		response.setResultValue(i);
//		}
	}

	private int insert_jobs(String jobId, String jobTitle, int minSalary, int maxSalary) {
		int returnValue = 0;
//		DBConn.getInstance();
		String sql = "INSERT INTO JOBS " + "VALUES ('%s','%s', %d, %d)";
		sql = String.format(sql, jobId, jobTitle, minSalary, maxSalary);
		System.out.println(sql);
		try {
			returnValue = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		DBConn.dbClose();
		System.out.println("�Ϸ�");

		return returnValue;
	}

	// --------department �μ� �߰�
	public void insert_department() {
		Request request = new Request();
		Response response = new Response();
		DepartmentsDto dto = new DepartmentsDto();

		System.out.println("�ű� �μ��� �߰��մϴ�.");
		System.out.println("1) �ű� department_id �Է�>>");
		String dept_id = sc.nextLine();

		if (exception_dep(0, dept_id)) {
			System.out.println("!! �̹� �����ϴ� �μ��Դϴ�.");
		} else {

			dto.setDepId(Integer.parseInt(dept_id));
			System.out.println("2) �ű� department_name �Է�>>");
			dto.setDepName(DBConn.inputString());
			System.out.println("3) manager_ID �Է�>>");
			dto.setDepManager(DBConn.inputInt());

			search_location_id();
			System.out.println("4) location_ID �Է�>>");
			dto.setDepLocation(DBConn.inputInt());

			int i = insert_department(dto);
			response.setResultValue(i);
		}
	}

	private int insert_department(DepartmentsDto dto) {
		int returnValue = 0;
//		DBConn.getInstance();
		String sql = "INSERT INTO departments " + "VALUES (%d,'%s',%d,%d)";
		sql = String.format(sql, dto.getDepId(), dto.getDepName(), dto.getDepManager(), dto.getDepLocation());
		System.out.println(sql);
		try {
			returnValue = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		DBConn.dbClose();
		System.out.println(" �˸���  �ű� �μ� �߰� �۾��� �Ϸ� �߽��ϴ�.");

		return returnValue;
	}

	// --------RegionsDto ���
	public ArrayList<RegionsDto> search_regions() {
		ArrayList<RegionsDto> dtos = new ArrayList<RegionsDto>();
//		DBConn.getInstance();
		// String sql = "select * from regions";
		String sql = "select * from regions";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				RegionsDto dto = new RegionsDto();
				dto.setRegionID(rs.getInt("region_id"));
				dto.setRegionName(rs.getString("region_name"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (RegionsDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	// -------- CountriesDto ���
	public ArrayList<CountriesDto> search_countries() {
		ArrayList<CountriesDto> dtos = new ArrayList<CountriesDto>();
//		DBConn.getInstance();
		startDB();
		startStat();
		String sql = "select * from countries";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				CountriesDto dto = new CountriesDto();
				dto.setCountry_id(rs.getString("country_id"));
				dto.setCountry_name(rs.getString("country_name"));
				dto.setRegion_id(rs.getInt("region_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (CountriesDto dto : dtos) {
			System.out.println(dto);
		}
		closeStat();
		closeDB();
		return dtos;
	}

	// -------- EmployeesDto ���
	public ArrayList<EmployeesDto> search_employees() {
		ArrayList<EmployeesDto> dtos = new ArrayList<EmployeesDto>();
		// DBConn.getInstance();
		String sql = "select * from employees";
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setHireDate(rs.getString("hire_date"));
				dto.setJobId(rs.getString("job_id"));
				dto.setsalary(rs.getInt("salary"));
				dto.setCommissionPct(rs.getDouble("commmission_pct"));
				dto.setManagerId(rs.getInt("manager_id"));
				dto.setDepartmentId(rs.getInt("department_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (EmployeesDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	// -------- JobsDto ���
	public ArrayList<JobsDto> search_jobs() {
		ArrayList<JobsDto> dtos = new ArrayList<JobsDto>();
//		DBConn.getInstance();
		String sql = "select * from jobs";

//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				JobsDto dto = new JobsDto();
				dto.setJobId(rs.getString("jobId"));
				dto.setJobTitle(rs.getString("jobTitle"));
				dto.setMinSalary(rs.getInt("minSalary"));
				dto.setMaxSalary(rs.getInt("maxSalary"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (JobsDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	// -------- <JobsDto>-jobsID ���
	public ArrayList<JobsDto> search_jobs_id() {
		ArrayList<JobsDto> dtos = new ArrayList<JobsDto>();
//		DBConn.getInstance();
		startDB();
		startStat();
		String sql = "select * from jobs";
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				JobsDto dto = new JobsDto();
				dto.setJobId(rs.getString("job_id"));
				dto.setJobTitle(rs.getString("job_title"));
				dto.setMinSalary(rs.getInt("min_salary"));
				dto.setMaxSalary(rs.getInt("max_salary"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (JobsDto dto : dtos) {
			dto.flag = true;
			System.out.println(dto);
		}
		closeStat();
		closeDB();
		return dtos;
	}

	// -------- <LocationsDto>-location_id ���
	public ArrayList<LocationsDto> search_location_id() {
		ArrayList<LocationsDto> dtos = new ArrayList<LocationsDto>();
//		DBConn.getInstance();
		String sql = "select * from locations";
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				LocationsDto dto = new LocationsDto();
				dto.setLocationId(rs.getInt("location_Id"));
				dto.setStreetAddress(rs.getString("street_address"));
				dto.setPostalCode(rs.getString("postal_code"));
				dto.setCity(rs.getString("city"));
				dto.setStateProvince(rs.getString("state_province"));
				dto.setCountryId(rs.getString("country_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (LocationsDto dto : dtos) {
			dto.flag = true;
			System.out.println(dto);
		}

		return dtos;
	}

	// -------- <DepartmentsDto>-dept_id ���
	public ArrayList<DepartmentsDto> search_dept_id() {
		ArrayList<DepartmentsDto> dtos = new ArrayList<DepartmentsDto>();
//		DBConn.getInstance();
		startDB();
		startStat();
		String sql = "select * from departments";
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				DepartmentsDto dto = new DepartmentsDto();
				dto.setDepId(rs.getInt("department_id"));
				dto.setDepName(rs.getString("department_name"));
				dto.setDepManager(rs.getInt("manager_id"));
				dto.setDepLocation(rs.getInt("location_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (DepartmentsDto dto : dtos) {
			dto.flag = true;
			System.out.println(dto);
		}
		closeStat();
		closeDB();
		return dtos;
	}

	// -------- emp ����ó��
	public boolean exception_emp(int num, String find) { // ���̺�DTO, //num = 0~
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>(); // ���̺�DTO
//		DBConn.getInstance();
		startDB();
		startStat();
		String sql = "select * from Employees"; // ���̺��
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

				str = "";
				str += rs.getInt("salary");
				dto.add(str);

				str = "";
				str += rs.getDouble("commission_pct");
				dto.add(str);

				str = "";
				str += rs.getInt("manager_id");
				dto.add(str);

				str = "";
				str += rs.getInt("department_id");
				dto.add(str);

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).get(num).equals(find)) {
				return true;

			}

		}
//		DBConn.closeStatement();
//		DBConn.dbClose();
		closeStat();
		closeDB();
		return false;
	}

	// -------- jobs ����ó��
	public boolean exception_jobs(int num, String find) {
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>();
//		DBConn.getInstance();

		String sql = "select * from jobs";
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				ArrayList<String> dto = new ArrayList<String>();

				String str = "";

				dto.add(rs.getString("job_id"));
				dto.add(rs.getString("job_title"));

				str += rs.getInt("min_salary");
				dto.add(str);

				str = "";
				str += rs.getInt("max_salary");
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

	// -------- lacation ����ó��
	public boolean exception_loca(int num, String find) { // ���̺�DTO, //num = 0~
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>(); // ���̺�DTO
//		DBConn.getInstance();
		startDB();
		startStat();
		String sql = "select * from locations"; // ���̺��
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while (rs.next()) {
				ArrayList<String> dto = new ArrayList<String>();

				String str = "";
				str += rs.getInt("location_id");
				dto.add(str);

				dto.add(rs.getString("street_address"));
				dto.add(rs.getString("postal_code"));
				dto.add(rs.getString("city"));
				dto.add(rs.getString("state_province"));
				dto.add(rs.getString("country_id"));

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
		closeStat();
		closeDB();
		return false;
	}

	// -------- dep ����ó��
	public boolean exception_dep(int num, String find) { // ���̺�DTO, //num = 0~
		ArrayList<ArrayList<String>> dtos = new ArrayList<ArrayList<String>>(); // ���̺�DTO
//		DBConn.getInstance();
		String sql = "select * from Departments"; // ���̺��
//		ResultSet rs = DBConn.StatementQuery(sql);
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	public boolean checkString_double(String input) {
		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9') && input.charAt(i) != '.') {
				return false;
			}
			if (input.charAt(i) == '.') {
				count++;
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}

}
