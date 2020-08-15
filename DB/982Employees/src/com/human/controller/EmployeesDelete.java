package com.human.controller;

import java.util.ArrayList;

import com.human.dao.EmployeesDao;
import com.human.dto.EmployeesDto;
import com.human.util.DBConn;

public class EmployeesDelete implements EmployeesExecute {

	
	public void execute(Object request, Object response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	
	public void inputView(Object request, Object response) {
		System.out.println("지울 employeeId 를 입력하시오");
		int employeeId = DBConn.inputInt();
		
		EmployeesDto dto = (EmployeesDto)request;
		dto.setEmployeeId(employeeId);

	}


	public void logic(Object request, Object response) {
		EmployeesDto dto =(EmployeesDto)request;
		EmployeesDao dao = new EmployeesDao();
		int i = dao.delete(dto.getEmployeeId());
		((ArrayList<Integer>) response).add(new Integer(i));

	}


	public void outputView(Object request, Object response) {
		System.out.println(((ArrayList<Integer>)response).get(0));

	}

}
