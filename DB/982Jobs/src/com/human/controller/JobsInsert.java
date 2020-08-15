package com.human.controller;

import java.util.ArrayList;

import com.human.dao.JobsDao;
import com.human.dto.JobsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobsInsert implements JobsExecute{

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
		System.out.println("직무 정보를 입력하세요.");
		System.out.println("job_id 입력");
		String jobId = DBConn.inputString();
		System.out.println("job_title 입력");
		String jobTitle = DBConn.inputString();
		System.out.println("min_salary 입력");
		int minSalary = DBConn.inputInt();
		System.out.println("max_salary 입력");
		int maxSalary = DBConn.inputInt();

		JobsDto dto = new JobsDto();
		dto.setJobId(jobId);
		dto.setJobTitle(jobTitle);
		dto.setMinSalary(minSalary);
		dto.setMaxSalary(maxSalary);
		
		request.setJobsDto(dto);
		
	}

	@Override
	public void logic(Request request, Response response) {
		JobsDto dto = request.getJobsDto();
		JobsDao dao = new JobsDao();
		int i = dao.insert(dto);
		
		response.setResultValue(i);
		
	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());
		
	}

	
}
