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
		
		System.out.println("모든 회원을 출력할 예정입니다.");
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
