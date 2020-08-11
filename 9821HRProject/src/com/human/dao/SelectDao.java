package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.human.dto.CountriesDto;
import com.human.dto.DepartmentsDto;
import com.human.dto.EmployeesDto;
import com.human.dto.JobHistoryDto;
import com.human.dto.JobsDto;
import com.human.dto.LocationsDto;
import com.human.dto.RegionsDto;
import com.human.util.DBConn;

public class SelectDao {
	static ActDB act;
	static String select_sql = "select ";
	static String sub_query = null;

	public void setActDB(ActDB a) {
		act = a;
	}

	public boolean string_ok(String str) {
		if (str.equals("Y") || str.equals("y") || str.equals("N") || str.equals("n")) {
			return true;
		} else {
			return false;
		}
	}

	public String math_string(int math) {
		if (math == 1) {
			return "총합";
		} else if (math == 2) {
			return "평균";
		} else if (math == 3) {
			return "최대값";
		} else {
			return "최소값";
		}
	}

	public String returnField_employees(ArrayList<Integer> arrList, int arrIndex, ArrayList<EmployeesDto> dtos,
			int dtosIndex) {
		switch (arrList.get(arrIndex)) {
		case 1:
			return "" + dtos.get(dtosIndex).getEmployeeId();
		case 2:
			return "" + dtos.get(dtosIndex).getFirstName();
		case 3:
			return "" + dtos.get(dtosIndex).getLastName();
		case 4:
			return "" + dtos.get(dtosIndex).getEmail();
		case 5:
			return "" + dtos.get(dtosIndex).getPhoneNumber();
		case 6:
			return "" + dtos.get(dtosIndex).getHireDate();
		case 7:
			return "" + dtos.get(dtosIndex).getJobId();
		case 8:
			return "" + dtos.get(dtosIndex).getsalary();
		case 9:
			return "" + dtos.get(dtosIndex).getCommissionPct();
		case 10:
			return "" + dtos.get(dtosIndex).getManagerId();
		case 11:
			return "" + dtos.get(dtosIndex).getDepartmentId();
		case 12:
			return "" + dtos.get(dtosIndex).getTotalSalary();
		default:
			return null;
		}
	}

	public String return_employees_value(ArrayList<Integer> arrList, int arrIndex, ArrayList<EmployeesDto> dtos) {
		switch (arrList.get(arrIndex)) {
		case 1:
			return "employeeId ";
		case 2:
			return "firstName ";
		case 3:
			return "lastName ";
		case 4:
			return "Email ";
		case 5:
			return "phoneNumber ";
		case 6:
			return "hireDate ";
		case 7:
			return "jobId ";
		case 8:
			return "salary ";
		case 9:
			return "commissionPct ";
		case 10:
			return "managerId ";
		case 11:
			return "departmentId ";
		case 12:
			return "total_salary ";
		default:
			return null;
		}
	}

	public String return_employees_value(EmployeesDto dto, int num) {
		String str = "";
		switch (num) {
		case 1:
			return str += dto.getEmployeeId();
		case 2:
			return str += dto.getFirstName();
		case 3:
			return str += dto.getLastName();
		case 4:
			return str += dto.getEmail();
		case 5:
			return str += dto.getPhoneNumber();
		case 6:
			return str += dto.getHireDate();
		case 7:
			return str += dto.getJobId();
		case 8:
			return str += dto.getsalary();
		case 9:
			return str += dto.getCommissionPct();
		case 10:
			return str += dto.getManagerId();
		case 11:
			return str += dto.getDepartmentId();
		case 12:
			return str += dto.getTotalSalary();
		default:
			return null;
		}
	}

	public String returnField_employees(int num) {
		switch (num) {
		case 1:
			return "employeeId ";
		case 2:
			return "firstName ";
		case 3:
			return "lastName ";
		case 4:
			return "Email ";
		case 5:
			return "phoneNumber ";
		case 6:
			return "hireDate ";
		case 7:
			return "jobId ";
		case 8:
			return "salary ";
		case 9:
			return "commissionPct ";
		case 10:
			return "managerId ";
		case 11:
			return "departmentId ";
		case 12:
			return "total_salary ";
		default:
			return null;
		}
	}

	public String returnField_departments(int num) {
		if (num == 1) {
			return "department_id ";
		} else if (num == 2) {
			return "department_name ";
		} else if (num == 3) {
			return "manager_id ";
		} else if (num == 4) {
			return "location_id ";
		} else {
			return "";
		}
	}

	public String get_departments_value(DepartmentsDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getDepId();
		} else if (num == 2) {
			str += dto.getDepName();
		} else if (num == 3) {
			str += dto.getDepManager();
		} else if (num == 4) {
			str += dto.getDepLocation();
		}
		return str;
	}

	public String returnField_location(int num) {
		if (num == 1) {
			return "location_id ";
		} else if (num == 2) {
			return "street_address ";
		} else if (num == 3) {
			return "postal_code ";
		} else if (num == 4) {
			return "city ";
		} else if (num == 5) {
			return "state_province ";
		} else if (num == 6) {
			return "country_id ";
		} else {
			return "";
		}
	}

	public String get_locations_value(LocationsDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getLocationId();
		} else if (num == 2) {
			str += dto.getStreetAddress();
		} else if (num == 3) {
			str += dto.getPostalCode();
		} else if (num == 4) {
			str += dto.getCity();
		} else if (num == 5) {
			str += dto.getStateProvince();
		} else if (num == 6) {
			str += dto.getCountryId();
		}
		return str;
	}

	public String returnField_histories(int num) {
		if (num == 1) {
			return "employee_id ";
		} else if (num == 2) {
			return "start_date ";
		} else if (num == 3) {
			return "end_date ";
		} else if (num == 4) {
			return "job_id ";
		} else if (num == 5) {
			return "department_id ";
		} else {
			return "";
		}
	}

	public String get_histories_value(JobHistoryDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getEmployee_id();
		} else if (num == 2) {
			str += dto.getStartDate();
		} else if (num == 3) {
			str += dto.getEndDate();
		} else if (num == 4) {
			str += dto.getJobId();
		} else if (num == 5) {
			str += dto.getDepartmentId();
		}
		return str;
	}

	public String returnField_jobs(int num) {
		if (num == 1) {
			return "job_id ";
		} else if (num == 2) {
			return "job_title ";
		} else if (num == 3) {
			return "min_salary ";
		} else if (num == 4) {
			return "max_salary ";
		} else {
			return "";
		}
	}

	public String get_jobs_value(JobsDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getJobId();
		} else if (num == 2) {
			str += dto.getJobTitle();
		} else if (num == 3) {
			str += dto.getMinSalary();
		} else if (num == 4) {
			str += dto.getMaxSalary();
		}
		return str;
	}

	public String returnField_countries(int num) {
		if (num == 1) {
			return "country_id ";
		} else if (num == 2) {
			return "country_name ";
		} else if (num == 3) {
			return "region_id ";
		} else {
			return "";
		}
	}

	public String get_countries_value(CountriesDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getCountry_id();
		} else if (num == 2) {
			str += dto.getCountry_name();
		} else if (num == 3) {
			str += dto.getRegion_id();
		}
		return str;
	}

	public String returnField_regions(int num) {
		if (num == 1) {
			return "region_id ";
		} else if (num == 2) {
			return "region_name ";
		} else {
			return "";
		}
	}

	public String get_regions_value(RegionsDto dto, int num) {
		String str = "";
		if (num == 1) {
			str += dto.getRegionID();
		} else if (num == 2) {
			str += dto.getRegionDescription();
		}
		return str;
	}

	// from 전까지 필요한 내용을 String으로 만들어야함. field_count:찾을 필드 개수
	public String search_departments(int field_count, String subq) {
		ArrayList<DepartmentsDto> dtos = new ArrayList<DepartmentsDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 4) {
		// for (int i = 1; i <= 4; i++) {
//	    System.out.print(i + ". " + returnField_departments(i));
//	    if (i != 4) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 4) {
				// int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_departments.get(i);
				arrList.add(num);
				sql += returnField_departments(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_departments(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		sql += "from departments ";
		// if (subq == null) {
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		// }
		// sql명령문을 실행한 값을 받아오는 함수에 전달
		ResultSet rs = DBConn.StatementQuery("select * from departments");
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				DepartmentsDto dto = new DepartmentsDto();
				dto.setDepId(rs.getInt("Department_id"));
				dto.setDepName(rs.getString("Department_name"));
				dto.setDepManager(rs.getInt("Manager_id"));
				dto.setDepLocation(rs.getInt("Location_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_departments(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_departments_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_locations(int field_count, String subq) {
		ArrayList<LocationsDto> dtos = new ArrayList<LocationsDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 6) {
		// for (int i = 1; i <= 6; i++) {
//	    System.out.print(i + ". " + returnField_location(i));
//	    if (i != 6) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 6) {
//	    System.out.print(">> ");
//	    int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_locations.get(i);
				arrList.add(num);
				sql += returnField_location(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_location(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		sql += "from locations ";
		// if (subq == null) {
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		// }
		ResultSet rs;
		if (subq != null) {
			sql = make_where_com(sql, cut_str(subq), subq);
			// System.out.println(sql);
			// System.out.println("#############################");
			// System.out.println(sql);
			// System.out.println("#############################");

		}
		if (field_count != 6) {
			if (subq == null) {
				rs = DBConn.StatementQuery("select * from locations");
			} else {
				rs = DBConn.StatementQuery(sql);
			}
			try {
				while (rs.next()) {
					LocationsDto dto = new LocationsDto();
					String column = returnField_location(act.columnList_locations.get(0));
					String str = returnField_location(1);
					if (str.equals(column)) {
						dto.setLocationId(rs.getInt(str.substring(0, str.length() - 1)));
					}
					str = returnField_location(2);
					if (str.equals(column)) {
						dto.setStreetAddress(rs.getString(str.substring(0, str.length() - 1)));
					}
					str = returnField_location(3);
					if (str.equals(column)) {
						dto.setPostalCode(rs.getString(str.substring(0, str.length() - 1)));
					}
					str = returnField_location(4);
					if (str.equals(column)) {
						dto.setCity(rs.getString(str.substring(0, str.length() - 1)));
					}
					str = returnField_location(5);
					if (str.equals(column)) {
						dto.setStateProvince(rs.getString(str.substring(0, str.length() - 1)));
					}
					str = returnField_location(6);
					if (str.equals(column)) {
						dto.setCountryId(rs.getString(str.substring(0, str.length() - 1)));
					}
					dtos.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (subq == null) {
				rs = DBConn.StatementQuery("select * from locations");
			} else {
				rs = DBConn.StatementQuery(sql);
			}
			// 받아온 값을 저장한 후에
			try {
				while (rs.next()) {
					LocationsDto dto = new LocationsDto();
					String str = returnField_location(1);
					dto.setLocationId(rs.getInt(str.substring(0, str.length() - 1)));
					str = returnField_location(2);
					dto.setStreetAddress(rs.getString(str.substring(0, str.length() - 1)));
					str = returnField_location(3);
					dto.setPostalCode(rs.getString(str.substring(0, str.length() - 1)));
					str = returnField_location(4);
					dto.setCity(rs.getString(str.substring(0, str.length() - 1)));
					str = returnField_location(5);
					dto.setStateProvince(rs.getString(str.substring(0, str.length() - 1)));
					str = returnField_location(6);
					dto.setCountryId(rs.getString(str.substring(0, str.length() - 1)));
					dtos.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_location(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_locations_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_job_history(int field_count, String subq) {// 사원이력을 쭉 나열할 수 있어야함. 직원삭제시에도 출력
		ArrayList<JobHistoryDto> dtos = new ArrayList<JobHistoryDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 5) {
		// for (int i = 1; i <= 5; i++) {
//	    System.out.print(i + ". " + returnField_histories(i));
//	    if (i != 5) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 5) {
				// System.out.print(">> ");
				// int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_job_history.get(i);
				arrList.add(num);
				sql += returnField_histories(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_histories(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		ResultSet rs;
		if (field_count != 0) {
			sql += "from job_history ";
			// if (subq == null) {
//	    System.out.println("#############################");
//	    System.out.println(sql);
//	    System.out.println("#############################");
			// }
			// sql명령문을 실행한 값을 받아오는 함수에 전달
			rs = DBConn.StatementQuery("select * from job_history");
		} else {
			for (int i = 0; i < 5; i++) {
				arrList.add(i + 1);
			}
			// System.out.println("#############################");
			// System.out.println(subq);
			// System.out.println("#############################");
			rs = DBConn.StatementQuery(subq);
		}
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				JobHistoryDto dto = new JobHistoryDto();
				String str = returnField_histories(1);
				dto.setEmployee_id(rs.getInt(str.substring(0, str.length() - 1)));
				str = returnField_histories(2);
				dto.setStartDate(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_histories(3);
				dto.setEndDate(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_histories(4);
				dto.setJobId(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_histories(5);
				dto.setDepartmentId(rs.getInt(str.substring(0, str.length() - 1)));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_histories(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_histories_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_jobs(int field_count, String subq) {
		ArrayList<JobsDto> dtos = new ArrayList<JobsDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 4) {
		// for (int i = 1; i <= 4; i++) {
//	    System.out.print(i + ". " + returnField_jobs(i));
//	    if (i != 4) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 4) {
				// int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_jobs.get(i);
				arrList.add(num);
				sql += returnField_jobs(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_jobs(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		sql += "from jobs ";
		// if (subq == null) {
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		// }
		// sql명령문을 실행한 값을 받아오는 함수에 전달
		ResultSet rs = DBConn.StatementQuery("select * from jobs");
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				JobsDto dto = new JobsDto();
				String str = returnField_jobs(1);
				dto.setJobId(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_jobs(2);
				dto.setJobTitle(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_jobs(3);
				dto.setMinSalary(rs.getInt(str.substring(0, str.length() - 1)));
				str = returnField_jobs(4);
				dto.setMaxSalary(rs.getInt(str.substring(0, str.length() - 1)));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_jobs(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_jobs_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_countries(int field_count, String subq) {// 국가 코드 입력하면 모든 지점을 출력해주는 쿼리
		ArrayList<CountriesDto> dtos = new ArrayList<CountriesDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 3) {
		// for (int i = 1; i <= 3; i++) {
//	    System.out.print(i + ". " + returnField_departments(i));
//	    if (i != 3) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 3) {
				// int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_countries.get(i);
				arrList.add(num);
				sql += returnField_countries(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_countries(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		sql += "from countries ";
		// if (subq == null) {
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		// }
		// sql명령문을 실행한 값을 받아오는 함수에 전달
		ResultSet rs = DBConn.StatementQuery("select * from countries");
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				CountriesDto dto = new CountriesDto();
				String str = returnField_countries(1);
				dto.setCountry_id(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_countries(2);
				dto.setCountry_name(rs.getString(str.substring(0, str.length() - 1)));
				str = returnField_countries(3);
				dto.setRegion_id(rs.getInt(str.substring(0, str.length() - 1)));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";//최대 20칸 할당, 좌측 정렬
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_countries(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_countries_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_regions(int field_count, String subq) {
		ArrayList<RegionsDto> dtos = new ArrayList<RegionsDto>();
		DBConn.getInstance();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		// 여기서 sql만들고,
		String sql = "select ";
		// 필드가 어떤 것들이 있는지 정보 제공
		// if (field_count != 2) {
		// for (int i = 1; i <= 2; i++) {
//	    System.out.print(i + ". " + returnField_regions(i));
//	    if (i != 2) {
//	     System.out.print(", ");
//	    }
		// }
		// System.out.println("");
		// }
		// 필드 번호들을 arraylist로 만든 뒤
		for (int i = 0; i < field_count; i++) {
			if (field_count != 2) {
				// int num = Integer.parseInt((sc.nextLine()));
				int num = act.columnList_regions.get(i);
				arrList.add(num);
				sql += returnField_regions(num);
			} else {
				arrList.add(i + 1);
				sql += returnField_regions(i + 1);
			}
			if (i != field_count - 1) {
				sql += ", ";
			}
		}
		sql += "from regions ";
		// if (subq == null) {
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		// }
		// sql명령문을 실행한 값을 받아오는 함수에 전달
		ResultSet rs = DBConn.StatementQuery("select * from regions");
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				RegionsDto dto = new RegionsDto();
				String str = returnField_regions(1);
				dto.setRegionID(rs.getInt(str.substring(0, str.length() - 1)));
				str = returnField_regions(2);
				dto.setRegionDescription(rs.getString(str.substring(0, str.length() - 1)));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		if (act.print_result) {
			for (int j = 0; j < arrList.size(); j++) {
				String printStr = "";
				printStr += "[ ";
				printStr += returnField_regions(arrList.get(j));
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (j != arrList.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, get_regions_value(dtos.get(i), arrList.get(j)));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		return sql;
	}

	public String search_employees(ActDB ad, int math, boolean need_subquery, String subq) throws SQLException {// math
		// 0:none
		// 1:sum
		// 2:avg//
		// 3:max
		// 4:min
		// 리턴받은 서브쿼리을 str(원래는 널임)에 넣고 다시 실행해주면
		act = ad;
		sub_query = subq;

		ArrayList<EmployeesDto> dtos = new ArrayList<EmployeesDto>();
		DBConn.getInstance();
		// select sql문을 생성함과 동시에 필드 시퀀스를 가져온다.
		ArrayList<Integer> arrList = getFieldSeq(math);
		if (act.total_salary) {// 연봉들의 총합이 아니고 연봉과 성과급을 합한 값임
			ask_new_field(arrList);
		}

		if (!act.between && !act.strComp && !act.numComp && !act.contain) {
			select_sql += "from employees ";
		}

		if (act.between) {
			ask_between(arrList);
		}
		if (act.strComp) {
			ask_str_compare(arrList);
		}
		if (act.numComp) {
			ask_num_compare(arrList);
		}
		if (act.contain) {
			ask_contain(arrList);
		}

		if (act.group) {
			ask_group(arrList);
		}

		if (act.order) {// 항상 모든 함수 중에 가장 마지막으로 실행해야한다.
			ask_order(arrList, act.total_salary);
		}

		// if (act.getFieldSeq1.equals("part")) {
		// System.out.println("#############################");
		// System.out.print(select_sql);
		//
		// if (need_subquery) {
//	    System.out.print("<==== this is sub query");
		// }
		// System.out.println("\n#############################");
		// }
		// 서브쿼리가 필요한 요청일땐 여기서 리턴찍어주면 될듯(플래그사용)
		if (need_subquery) {
			return select_sql;
		}

		// if (arrList != null) {
		// if (act.getFieldSeq1.equals("all")) {
		// System.out.println("#############################");
		// System.out.print(select_sql);
		// System.out.println("\n#############################");
		// }
		ResultSet rs = DBConn.StatementQuery(select_sql);

		if (math == 0) {
			try {
				while (rs.next()) {
					dtos.add(setEmployeesDto(rs, arrList));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String column2Format = "%-20.20s";
			// if (act.print_result) {

			for (int i = 0; i < arrList.size(); i++) {
				String printStr = "";
				printStr += "[ ";
				printStr += return_employees_value(arrList, i, dtos);
				printStr += "]";
				System.out.format(column2Format, printStr);
				if (i != arrList.size() - 1) {
					System.out.print(" ");
				}
			}

			System.out.println();
			for (int i = 0; i < dtos.size(); i++) {

				for (int j = 0; j < arrList.size(); j++) {

					System.out.format(column2Format, returnField_employees(arrList, j, dtos, i));
					if (j != arrList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			// }
			// for (int i = 0; i < dtos.size(); i++) {
//	    String result = "Employees[";
//	    for (int j = 0; j < arrList.size(); j++) {
//	     result += returnString(arrList, j, dtos, i);
//	     if (j != arrList.size() - 1) {
//	      result += ", ";
//	     }
//	    }
//	    result += " ]";
//	    System.out.println(result);
			// }
		} else {
			if (rs != null) {
				rs.next();
				System.out.println(math_string(math) + " : " + rs.getDouble(1));
			}
		}
		// }
		return null;
	}

	public ArrayList<Integer> getFieldSeq(int math) {
		// Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numArr = new ArrayList<Integer>();
		select_sql = "select ";// select_sql을 초기화(select실행할때마다 무조건필요)

		// System.out.print("필요하신 정보를 선택하세요.? (all->전체 정보/part->부분 정보)");
		// String str = sc.nextLine();// #######################String1
		String str = act.getFieldSeq1;
		if (str.equals("all")) {
			select_sql += "* ";
			for (int i = 1; i < 12; i++) {
				numArr.add(i);
			}
		} else if (str.equals("part")) {
			// System.out.print("몇가지 정보를 출력할까요? >> ");
			// int count = Integer.parseInt(sc.nextLine());// #######################int1
			int count = Integer.parseInt(act.getFieldSeq2);

			// math 적용 필드를 묻는다.
			int checked_math_field = 0;
			if (math != 0) {
				// System.out.println(
				// "1.employee_id | 2.first_name | 3.last_name | 4.email | \n5.phone_number |
				// 6.hire_date | 7.job_id | 8.salary \n| 9.commision | 10.manager_id |
				// 11.department_id");
				// System.out.print("몇 번 값에 " + math_string(math) + "을 적용지 미리 선택해주세요. >> ");
				// checked_math_field = Integer.parseInt(sc.nextLine());
				checked_math_field = Integer.parseInt(act.getFieldSeq3);
			}

			for (int i = 0; i < count; i++) {
				// System.out.println("필드를 선택해주세요. 앞으로 선택할 수 있는 필드의 수는 " + (count - i) + "개
				// 입니다.");
				// System.out.println(
				// "1.employee_id | 2.first_name | 3.last_name | 4.email | \n5.phone_number |
				// 6.hire_date | 7.job_id | 8.salary \n| 9.commision | 10.manager_id |
				// 11.department_id");
				// System.out.print("번호를 입력하세요. >> ");

				// int num = Integer.parseInt(sc.nextLine());// #######################int2
				int num = Integer.parseInt(act.getFieldSeq4.get(i));
				if (!numArr.contains(num)) {
					numArr.add(num);
					if (math == 0) {
						setField(num);
					} else {
						if (num == checked_math_field) {
							setField_math(num, math);
						}
					}
					if (i != count - 1) {
						select_sql += ", ";
					}
				} else {
					// System.out.println("이미 선택하신 번호입니다.");
					i--;
				}
			}
		}

		return numArr;
	}

	public String returnField(int num) {
		if (num == 1) {
			return "employee_id ";
		} else if (num == 2) {
			return "first_name ";
		} else if (num == 3) {
			return "last_name ";
		} else if (num == 4) {
			return "email ";
		} else if (num == 5) {
			return "phone_number ";
		} else if (num == 6) {
			return "hire_date ";
		} else if (num == 7) {
			return "job_id ";
		} else if (num == 8) {
			return "salary ";
		} else if (num == 9) {
			return "commission_pct ";
		} else if (num == 10) {
			return "manager_id ";
		} else if (num == 11) {
			return "department_id ";
		} else if (num == 12) {
			return "total_salary ";
		} else {
			return "";
		}
	}

	public void setField(int num) {
		if (num == 1) {
			select_sql += "employee_id ";
		} else if (num == 2) {
			select_sql += "first_name ";
		} else if (num == 3) {
			select_sql += "last_name ";
		} else if (num == 4) {
			select_sql += "email ";
		} else if (num == 5) {
			select_sql += "phone_number ";
		} else if (num == 6) {
			select_sql += "hire_date ";
		} else if (num == 7) {
			select_sql += "job_id ";
		} else if (num == 8) {
			select_sql += "salary ";
		} else if (num == 9) {
			select_sql += "commission_pct ";
		} else if (num == 10) {
			select_sql += "manager_id ";
		} else if (num == 11) {
			select_sql += "department_id ";
		}
	}

	public void setField_math(int num, int math) {
		if (math == 1) {
			select_sql += "sum( ";
		} else if (math == 2) {
			select_sql += "avg( ";
		} else if (math == 3) {
			select_sql += "max( ";
		} else if (math == 4) {
			select_sql += "min( ";
		}

		if (num == 1) {
			select_sql += "employee_id ";
		} else if (num == 2) {
			select_sql += "first_name ";
		} else if (num == 3) {
			select_sql += "last_name ";
		} else if (num == 4) {
			select_sql += "email ";
		} else if (num == 5) {
			select_sql += "phone_number ";
		} else if (num == 6) {
			select_sql += "hire_date ";
		} else if (num == 7) {
			select_sql += "job_id ";
		} else if (num == 8) {
			select_sql += "salary ";
		} else if (num == 9) {
			select_sql += "commission_pct ";
		} else if (num == 10) {
			select_sql += "manager_id ";
		} else if (num == 11) {
			select_sql += "department_id ";
		}

		select_sql += ") ";
	}

	public EmployeesDto setEmployeesDto(ResultSet rs, ArrayList<Integer> arrList) throws SQLException {
		EmployeesDto dto = new EmployeesDto();
		for (int i = 0; i < arrList.size(); i++) {
			switch (arrList.get(i)) {
			case 1:
				dto.setEmployeeId(rs.getInt(i + 1));
				break;
			case 2:
				dto.setFirstName(rs.getString(i + 1));
				break;
			case 3:
				dto.setLastName(rs.getString(i + 1));
				break;
			case 4:
				dto.setEmail(rs.getString(i + 1));
				break;
			case 5:
				dto.setPhoneNumber(rs.getString(i + 1));
				break;
			case 6:
				dto.setHireDate(rs.getString(i + 1));
				break;
			case 7:
				dto.setJobId(rs.getString(i + 1));
				break;
			case 8:
				dto.setsalary(rs.getInt(i + 1));
				break;
			case 9:
				dto.setCommissionPct(rs.getDouble(i + 1));
				break;
			case 10:
				dto.setManagerId(rs.getInt(i + 1));
				break;
			case 11:
				dto.setDepartmentId(rs.getInt(i + 1));
				break;
			case 12:
				dto.setTotalSalary(rs.getInt(i + 1));
				break;
			default:
				break;
			}
		}

		return dto;
	}

	public String returnString(ArrayList<Integer> arrList, int arrIndex, ArrayList<EmployeesDto> dtos, int dtosIndex) {
		switch (arrList.get(arrIndex)) {
		case 1:
			return " employeeId=" + dtos.get(dtosIndex).getEmployeeId();
		case 2:
			return " firstName=" + dtos.get(dtosIndex).getFirstName();
		case 3:
			return " lastName=" + dtos.get(dtosIndex).getLastName();
		case 4:
			return " Email=" + dtos.get(dtosIndex).getEmail();
		case 5:
			return " phoneNumber=" + dtos.get(dtosIndex).getPhoneNumber();
		case 6:
			return " hireDate=" + dtos.get(dtosIndex).getHireDate();
		case 7:
			return " jobId=" + dtos.get(dtosIndex).getJobId();
		case 8:
			return " salary=" + dtos.get(dtosIndex).getsalary();
		case 9:
			return " commissionPct=" + dtos.get(dtosIndex).getCommissionPct();
		case 10:
			return " managerId=" + dtos.get(dtosIndex).getManagerId();
		case 11:
			return " departmentId=" + dtos.get(dtosIndex).getDepartmentId();
		case 12:
			return " total_salary=" + dtos.get(dtosIndex).getTotalSalary();
		default:
			return null;
		}
	}

	public ArrayList<EmployeesDto> search_employees2() {
		ArrayList<EmployeesDto> dtos = new ArrayList<EmployeesDto>();
		DBConn.getInstance();
		String sql = "select * from employees";
		ResultSet rs = DBConn.StatementQuery(sql);
		try {
			while (rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				dto.setEmployeeId(rs.getInt(1));

				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));

				dto.setHireDate(rs.getString(6));

				dto.setJobId(rs.getString(7));

				dto.setsalary(rs.getInt(8));

				dto.setCommissionPct(rs.getDouble(9));

				dto.setManagerId(rs.getInt(10));
				dto.setDepartmentId(rs.getInt(11));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("#############################");
		// System.out.println(sql);
		// System.out.println("#############################");
		for (EmployeesDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	public ArrayList<Integer> getFieldSeq_diy(ArrayList<Integer> numArr) {
		select_sql = "select ";// select_sql을 초기화(select실행할때마다 무조건필요)

		int count = numArr.size();

		for (int i = 0; i < count; i++) {
			int num = numArr.get(i);
			setField(num);
			if (i != count - 1) {
				select_sql += ", ";
			}
		}

		return numArr;
	}

	// public void search_employees_diy(String command) {
	// ArrayList<EmployeesDto> dtos = new ArrayList<EmployeesDto>();
	// DBConn.getInstance();
	// // select sql문을 생성함과 동시에 필드 시퀀스를 가져온다.
	// ArrayList<Integer> arrList = new ArrayList<Integer>();
	//
	// ask_contain(arrList);
	// ResultSet rs = DBConn.StatementQuery(select_sql);
	//
	// try {
	// while (rs.next()) {
//	    dtos.add(setEmployeesDto(rs, arrList));
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// for (int i = 0; i < dtos.size(); i++) {
	// String result = "Employees[";
	// for (int j = 0; j < arrList.size(); j++) {
//	    result += returnString(arrList, j, dtos, i);
//	    if (j != arrList.size() - 1) {
//	     result += ", ";
//	    }
	// }
	// result += " ]";
	// // System.out.println(result);
	// }
	//
	// }

	// public int needed_field_num(ArrayList<Integer> arrList, boolean totalSal) {
	// int maxN;
	// if (totalSal) {
	// maxN = 13;
	// } else {
	// maxN = 12;
	// }
	// // Scanner sc = new Scanner(System.in);// #######################
	// // System.out.print("어떤 필드에 대하여 추가기능을 수행할지 선택해주세요. (");
	// for (int i = 1; i < maxN; i++) {
	// // System.out.print(i + ". " + returnField(i));
	// if (i != maxN - 1) {
//	    // System.out.print(", ");
	// }
	// }
	// // System.out.print(") >> ");
	// return Integer.parseInt(act.needed_field_num1);//
	// Integer.parseInt(sc.nextLine());// #######################int3
	// }

	public void ask_new_field(ArrayList<Integer> arrList) {
		// 급여+커미션
		arrList.add(12);
		select_sql += ", salary*(1 + nvl(commission_pct,0)) as total_salary ";
	}

	// group by 필드
	public void ask_group(ArrayList<Integer> arrList) {
		// Scanner sc = new Scanner(System.in);

		// System.out.print(returnField(arrList.get(0)) + "에 대해 group을 지을까요?(Y/N) >> ");
		// String str = sc.nextLine();// #######################
		String str = act.ask_group1;
		if (str.equals("Y")) {
			select_sql += "group by ";
			select_sql += returnField(arrList.get(0));
		}
	}

	// order by 필드 asc or desc
	public void ask_order(ArrayList<Integer> arrList, boolean totalSal) {
		// Scanner sc = new Scanner(System.in);

		select_sql += "order by ";

		// System.out.print("정렬할 필드의 갯수를 골라주세요. >> ");
		// int num = Integer.parseInt(sc.nextLine());// #######################int4
		for (int i = 0; i < act.order_field_num_list.size(); i++) {
			int wantedField = act.order_field_num_list.get(i);
			select_sql += returnField(wantedField);

			// System.out.print("오른차순 : A / 내림차순 : D >> ");
			// String str = sc.nextLine();
			String str = act.order_option_list.get(i);
			if (str.equals("A")) {
				select_sql += "asc ";
			} else if (str.equals("D")) {
				select_sql += "desc ";
			}

			if (i != act.order_field_num_list.size() - 1) {
				select_sql += ", ";
			}
		}
	}

	// where 필드 = '단어'
	public void ask_str_compare(ArrayList<Integer> arrList) {
		// Scanner sc = new Scanner(System.in);

		int neededField = Integer.parseInt(act.needed_field_num1);

		select_sql += "from employees where ";
		select_sql += returnField(neededField);
		if (sub_query != null) {
			select_sql += "= ( ";
			select_sql += sub_query;
			select_sql += ") ";
		} else {
			select_sql += "='";

			// System.out.print("찾으실 " + returnField(neededField) + "은 무엇인지 입력해주세요 >> ");
			// String str = sc.nextLine();// #######################str2
			String str = act.ask_str_compare1;
			select_sql += str;
			select_sql += "' ";
		}
	}

	// 2,3,4,5,6,7 string data type
	// where 필드 like '%찾을문자%'
	public void ask_contain(ArrayList<Integer> arrList) {
		// Scanner sc = new Scanner(System.in);
		int neededField = Integer.parseInt(act.needed_field_num1);

		select_sql += "from employees where ";
		select_sql += returnField(neededField);
		select_sql += "like '%";

		// System.out.print(returnField(neededField) + "에서 포함되어야하는 문자를 입력해주세요. >> ");
		// String str = sc.nextLine();// #######################str3
		String str = act.ask_contain1;
		select_sql += str;
		select_sql += "%' ";
	}

	// 1,8,9,10,11 int double type
	// where 필드 >= 숫자값
	public void ask_num_compare(ArrayList<Integer> arrList) {
		// Scanner sc = new Scanner(System.in);

		int neededField = Integer.parseInt(act.needed_field_num1);
		select_sql += "from employees where ";
		select_sql += returnField(neededField);

		// System.out.print("찾으실 " + returnField(neededField) + "검색 범위를 입력해주세요.
		// (>,>=,<,<= 사용가능) [ex >= 300] >> ");
		// String str = sc.nextLine();// #######################str4
		if (sub_query != null) {
			select_sql += act.ask_num_compare_sub1;
			select_sql += "(";
			select_sql += sub_query;
			select_sql += ") ";
		} else {
			String str = act.ask_num_compare1;
			select_sql += str;
			select_sql += " ";
		}
	}

	// 1,8,9,10,11 int double type
	// where 필드 >= 숫자값
	// public void ask_num_compare_sub(ArrayList<Integer> arrList) {
	// // Scanner sc = new Scanner(System.in);
	//
	// int neededField = Integer.parseInt(act.needed_field_num1);
	// select_sql += "from employees where ";
	// select_sql += returnField(neededField);
	//
	// // System.out.print("사용하실 " + returnField(neededField) + "기능을 입력해주세요.
	// (>,>=,<,<=
	// // 사용가능) >> ");
	// // String str = sc.nextLine();// #######################str4
	// select_sql += act.ask_num_compare_sub1;
	// select_sql += "(";
	// select_sql += sub_query;
	// select_sql += ") ";
	// }

	// 1,8,9,10,11 int double type
	// where 필드 between 최소값 and 최대값
	public void ask_between(ArrayList<Integer> arrList) {
		// Scanner sc = new Scanner(System.in);

		int neededField = Integer.parseInt(act.needed_field_num1);
		select_sql += "from employees where ";
		select_sql += returnField(neededField);
		select_sql += "between ";

		// System.out.print("찾으실 " + returnField(neededField) + "검색 범위 최소값을 입력해주세요. >>
		// ");
		// String str = sc.nextLine();// #######################str5
		String str = act.ask_between1;
		select_sql += str;
		select_sql += " and ";
		// System.out.print("찾으실 " + returnField(neededField) + "검색 범위 최대값을 입력해주세요. >>
		// ");
		// str = sc.nextLine();// #######################str6
		str = act.ask_between2;
		select_sql += str;
		select_sql += " ";
	}

	public ArrayList<JobHistoryDto> search_jobhistory() {
		ArrayList<JobHistoryDto> dtos = new ArrayList<JobHistoryDto>();
		DBConn.getInstance();
		String sql = "select * from job_history";
		ResultSet rs = DBConn.StatementQuery(sql);

		try {
			while (rs.next()) {
				JobHistoryDto dto = new JobHistoryDto();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setStartDate(rs.getString("start_date"));
				dto.setEndDate(rs.getString("end_date"));
				dto.setJobId(rs.getString("job_id"));
				dto.setDepartmentId(rs.getInt("department_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (JobHistoryDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	public ArrayList<JobsDto> search_jobs() {
		ArrayList<JobsDto> dtos = new ArrayList<JobsDto>();
		DBConn.getInstance();
		String sql = "select * from jobs";
		ResultSet rs = DBConn.StatementQuery(sql);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (JobsDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	public ArrayList<LocationsDto> search_locations() {
		ArrayList<LocationsDto> dtos = new ArrayList<LocationsDto>();
		DBConn.getInstance();
		String sql = "select * from locations";
		ResultSet rs = DBConn.StatementQuery(sql);
		try {
			while (rs.next()) {
				LocationsDto dto = new LocationsDto();
				dto.setLocationId(rs.getInt("location_id"));
				dto.setStreetAddress(rs.getString("street_address"));
				dto.setPostalCode(rs.getString("postal_code"));
				dto.setCity(rs.getString("city"));
				dto.setStateProvince(rs.getString("state_province"));
				dto.setCountryId(rs.getString("country_id"));

				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (LocationsDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	// public String search_locations_addr(int loc_id) {
	// ArrayList<LocationsDto> dtos = new ArrayList<LocationsDto>();
	// DBConn.getInstance();
	//
	// String sql = "select street_address from locations where location_id = ";
	// sql += loc_id;
	//
	// ResultSet rs = DBConn.StatementQuery(sql);
	// try {
	// while (rs.next()) {
//	    LocationsDto dto = new LocationsDto();
////	    dto.setLocationId(rs.getInt("location_id"));
//	    dto.setStreetAddress(rs.getString("street_address"));
////	    dto.setPostalCode(rs.getString("postal_code"));
////	    dto.setCity(rs.getString("city"));
////	    dto.setStateProvince(rs.getString("state_province"));
////	    dto.setCountryId(rs.getString("country_id"));
	//
//	    dtos.add(dto);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return dtos.get(0).getStreetAddress();
	// }

	public ArrayList<RegionsDto> search_regions() {
		ArrayList<RegionsDto> dtos = new ArrayList<RegionsDto>();
		DBConn.getInstance();
		String sql = "select * from Regions";
		ResultSet rs = DBConn.StatementQuery(sql);
		try {
			while (rs.next()) {
				RegionsDto dto = new RegionsDto();
				dto.setRegionID(rs.getInt("Region_ID"));
				dto.setRegionDescription(rs.getString("Region_Name"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (RegionsDto dto : dtos) {
			System.out.println(dto);
		}

		return dtos;
	}

	// public void search_regions_all() {
	// for (RegionsDto dto : search_regions()) {
//	    System.out.println(dto);
	// }
	// }
	//
	// public void search_regions_regionid() {
	// for (RegionsDto dto : search_regions()) {
//	    System.out.println(dto.getRegionID());
	// }
	// }
	//
	// public void search_regions_name() {
	// for (RegionsDto dto : search_regions()) {
//	    System.out.println(dto.getRegionDescription());
	// }
	// }
	//
	public ArrayList<DepartmentsDto> search_department() {
		ArrayList<DepartmentsDto> dtos = new ArrayList<DepartmentsDto>();
		DBConn.getInstance();
		String sql = "select * from departments";
		ResultSet rs = DBConn.StatementQuery(sql);
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
			System.out.println(dto);
		}

		return dtos;
	}
	//
	// public int search_department_locid() {
	// ArrayList<DepartmentsDto> dtos = new ArrayList<DepartmentsDto>();
	// DBConn.getInstance();
	// Scanner sc = new Scanner(System.in);
	//
	// String sql = "select location_id from departments where department_id=";
	// System.out.print("주소를 찾을 부서ID를 입력하세요 >> ");
	// sql += sc.nextLine();
	// ResultSet rs = DBConn.StatementQuery(sql);
	// try {
	// while (rs.next()) {
//	    DepartmentsDto dto = new DepartmentsDto();
////	    dto.setDepId(rs.getInt("department_id"));
////	    dto.setDepName(rs.getString("department_name"));
////	    dto.setDepManager(rs.getInt("manager_id"));
//	    dto.setDepLocation(rs.getInt("location_id"));
//	    dtos.add(dto);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return dtos.get(0).getDepLocation();
	// }

	public String make_where_user(String q, String column) {
		Scanner sc = new Scanner(System.in);
		String find = q;
		find += "where ";
		find += column;
		find += "= ";

		System.out.print("찾으실 " + column + "의 번호를 입력해주세요. >> ");
		find += sc.nextLine();

		return find;
	}

	public String make_where_com(String q, String column, String sq) {
		String find = q;
		find += "where ";
		find += column;
		find += " = (";

		find += sq;
		find += ") ";

		return find;
	}

	public String cut_str(String input) {
		StringTokenizer st = new StringTokenizer(input);
		String str = "";
		while (st.hasMoreTokens()) {
			if (str.equals("select")) {
				str = st.nextToken();
				break;
			}
			str = st.nextToken();
		}
		return str;
	}

	public void search_employees_departments_join() {
		ArrayList<EmployeesDto> eDtos = new ArrayList<EmployeesDto>();
		ArrayList<DepartmentsDto> dDtos = new ArrayList<DepartmentsDto>();
		DBConn.getInstance();
		Scanner sc = new Scanner(System.in);
		String sql = "select employee_id, email, job_id, departments.department_id, department_name from employees, departments where employees.department_id = departments.department_id and departments.department_id = ";
		System.out.print("검색하실 부서 아이디를 입력해주세요 >> ");
		sql += sc.nextLine();
		ResultSet rs = DBConn.StatementQuery(sql);
		// 받아온 값을 저장한 후에
		try {
			while (rs.next()) {
				EmployeesDto eDto = new EmployeesDto();
				DepartmentsDto dDto = new DepartmentsDto();
				eDto.setEmployeeId(rs.getInt(1));
				eDto.setEmail(rs.getString(2));
				eDto.setJobId(rs.getString(3));
				eDtos.add(eDto);
				dDto.setDepId(rs.getInt(4));
				dDto.setDepName(rs.getString(5));
				dDtos.add(dDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 각각의 dto에 접근해서 값을 리턴,또는 출력
		String column2Format = "%-20.20s";
		System.out.format(column2Format, "[ " + returnField_employees(1) + "]");
		System.out.print(" ");
		System.out.format(column2Format, "[ " + returnField_employees(4) + "]");
		System.out.print(" ");
		System.out.format(column2Format, "[ " + returnField_employees(7) + "]");
		System.out.print(" ");
		System.out.format(column2Format, "[ " + returnField_departments(1) + "]");
		System.out.print(" ");
		System.out.format(column2Format, "[ " + returnField_departments(2) + "]");
		System.out.println();
		for (int i = 0; i < eDtos.size(); i++) {
			System.out.format(column2Format, return_employees_value(eDtos.get(i), 1));
			System.out.print(" ");
			System.out.format(column2Format, return_employees_value(eDtos.get(i), 4));
			System.out.print(" ");
			System.out.format(column2Format, return_employees_value(eDtos.get(i), 7));
			System.out.print(" ");
			System.out.format(column2Format, get_departments_value(dDtos.get(i), 1));
			System.out.print(" ");
			System.out.format(column2Format, get_departments_value(dDtos.get(i), 2));
			System.out.println();
		}
	}
}
