package com.human.controller;

import java.util.ArrayList;

import com.human.dao.JobsDao;
import com.human.dto.JobsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobsSelect implements JobsExecute{

	@Override
	public void execute() {
		JobsDto request = new JobsDto();
		ArrayList<Integer> response = new ArrayList<Integer>();
		
	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
		
	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("��� ���������� ����� �����Դϴ�.");
		
	}

	@Override
	public void logic(Request request, Response response) {
		JobsDao dao = new JobsDao();
		response.setArrJobsDto(dao.select());
		
	}

	@Override
	public void outputView(Request request, Response response) {
		
		if(response!=null) {
			ArrayList<JobsDto> dtos = response.getArrJobsDto();
			System.out.println("���������� ������ �����ϴ�.");
			for(JobsDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("������ �����ϴ�.");
		}
		
	}

	
}
