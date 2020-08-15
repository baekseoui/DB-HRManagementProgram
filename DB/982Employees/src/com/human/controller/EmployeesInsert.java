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
		System.out.println("회원정보를 입력하세요");
		
		System.out.println("employeeId 입력");
		int employeeId = DBConn.inputInt();
		
		System.out.println("firstName 입력");
		String firstName = DBConn.inputString();
		
		System.out.println("lastName 입력");
		String lastName = DBConn.inputString();
		
		System.out.println("email 입력");
		String email = DBConn.inputString();
		
		System.out.println("phoneNumber 입력");
		String phoneNumber = DBConn.inputString();
		
		System.out.println("hireDate 입력");
		Date hireDate =DBConn.inputDate();
		
		System.out.println("jobId 입력");
		String jobId = DBConn.inputString();
		
		System.out.println("salaty 입력");
		int salaty = DBConn.inputInt();
		
		System.out.println("commissionPct 입력");
		double commissionPct = DBConn.inputDouble();
		
		System.out.println("managerId 입력");
		int managerId = DBConn.inputInt();
		
		System.out.println("departmentId 입력");
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
