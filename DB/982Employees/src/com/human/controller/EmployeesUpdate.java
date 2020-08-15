package com.human.controller;

import java.util.ArrayList;

import com.human.dao.EmployeesDao;
import com.human.dto.EmployeesDto;
import com.human.util.DBConn;

public class EmployeesUpdate implements EmployeesExecute {



	public void execute(Object request, Object response) {
		
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}


	public void inputView(Object request, Object response) {
		System.out.println("변경할 회원번호와 이름을 입력하시오");
		System.out.println("employeeId 입력");
		int employeeId = DBConn.inputInt();
		System.out.println("firstname 입력");
		String firstName = DBConn.inputString();
		EmployeesDto dto =(EmployeesDto)request;
		
		dto.setEmployeeId(employeeId);
		dto.setFirstName(firstName);
	}


	public void logic(Object request, Object response) {
		EmployeesDto dto =(EmployeesDto)request;
		EmployeesDao dao = new EmployeesDao();
		int i = dao.update(dto.getFirstName(),dto.getEmployeeId());
		((ArrayList<Integer>) response).add(new Integer(i));
	}


	public void outputView(Object request, Object response) {
		System.out.println(((EmployeesDto)request).getEmployeeId()+ "번 데이터의 이름을 "+
				((EmployeesDto)request).getFirstName()+
				"로 변경 되었습니다.");
	}

}
