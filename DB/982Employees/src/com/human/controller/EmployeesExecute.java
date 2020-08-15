package com.human.controller;

import java.util.ArrayList;

import com.human.dto.EmployeesDto;

public interface EmployeesExecute {

	public void execute(Object request,Object response);
	
	public void inputView(Object request, Object response);
	
	public void logic(Object request, Object response);
	
	public void outputView(Object request, Object response);
	
	default void execute() {
		EmployeesDto request = new EmployeesDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}
}
