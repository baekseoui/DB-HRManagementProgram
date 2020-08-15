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
		System.out.println("������ ȸ����ȣ�� �̸��� �Է��Ͻÿ�");
		System.out.println("employeeId �Է�");
		int employeeId = DBConn.inputInt();
		System.out.println("firstname �Է�");
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
		System.out.println(((EmployeesDto)request).getEmployeeId()+ "�� �������� �̸��� "+
				((EmployeesDto)request).getFirstName()+
				"�� ���� �Ǿ����ϴ�.");
	}

}
