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
		System.out.println("���� ������ �Է��ϼ���.");
		System.out.println("job_id �Է�");
		String jobId = DBConn.inputString();
		System.out.println("job_title �Է�");
		String jobTitle = DBConn.inputString();
		System.out.println("min_salary �Է�");
		int minSalary = DBConn.inputInt();
		System.out.println("max_salary �Է�");
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
