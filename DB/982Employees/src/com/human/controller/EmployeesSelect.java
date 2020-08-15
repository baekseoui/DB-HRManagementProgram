package com.human.controller;

import java.util.ArrayList;

import com.human.dao.EmployeesDao;
import com.human.dto.EmployeesDto;
import com.human.util.DBConn;

public class EmployeesSelect implements EmployeesExecute {
		 

	public void execute(Object request,Object response) {
		 inputView(request, response);
		 logic(request, response);
		 outputView(request, response);
	}

	public void inputView(Object request,Object response) {
		
		System.out.println("��� ȸ���� ����� �����Դϴ�.");
	}

	public void logic(Object request,Object response) {
		
		
	
	}

	public void outputView(Object request,Object response) {
		EmployeesDao dao = new EmployeesDao();
		

		ArrayList<EmployeesDto> dtos = dao.select();
		
		
		for(EmployeesDto a : dtos) {
			System.out.println(a);
		}
		
	}


}
