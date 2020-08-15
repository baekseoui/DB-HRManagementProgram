package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.EmployeesDao;
import com.human.dto.EmployeesDto;
import com.human.util.DBConn;









public class EmployeesInsert implements EmployeesExecute{

	

	public void execute(Object request, Object response) {
		
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	
	public void inputView(Object request, Object response) {
		System.out.println("ȸ�������� �Է��ϼ���");
		
		System.out.println("employeeId �Է�");
		int employeeId = DBConn.inputInt();
		
		System.out.println("firstName �Է�");
		String firstName = DBConn.inputString();
		
		System.out.println("lastName �Է�");
		String lastName = DBConn.inputString();
		
		System.out.println("email �Է�");
		String email = DBConn.inputString();
		
		System.out.println("phoneNumber �Է�");
		String phoneNumber = DBConn.inputString();
		
		System.out.println("hireDate �Է�");
		Date hireDate =DBConn.inputDate();
		
		System.out.println("jobId �Է�");
		String jobId = DBConn.inputString();
		
		System.out.println("salaty �Է�");
		int salaty = DBConn.inputInt();
		
		System.out.println("commissionPct �Է�");
		double commissionPct = DBConn.inputDouble();
		
		System.out.println("managerId �Է�");
		int managerId = DBConn.inputInt();
		
		System.out.println("departmentId �Է�");
		int departmentId = DBConn.inputInt();
		
		
		
		EmployeesDto dto =(EmployeesDto)request;
		dto.setEmployeeId(employeeId);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		dto.setHireDate(hireDate);
		dto.setJobId(jobId);
		dto.setSalaty(salaty);
		dto.setCommissionPct(commissionPct);
		dto.setManagerId(managerId);
		dto.setDepartmentId(departmentId);
	}
	
	
	public void logic(Object request, Object response) {
		EmployeesDto dto =(EmployeesDto)request;
		EmployeesDao dao = new EmployeesDao();
		int i = dao.insert(dto);
		((ArrayList<Integer>) response).add(new Integer(i));
//		ArrayList<Integer> r = (ArrayList<Integer>) response;
//		r.add(new Integer(i));
	}
	
	
	public void outputView(Object request, Object response) {
		System.out.println(((ArrayList<Integer>)response).get(0));
	}

}
