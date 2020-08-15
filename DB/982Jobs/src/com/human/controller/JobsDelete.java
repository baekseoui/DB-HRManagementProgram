package com.human.controller;

import java.util.ArrayList;

import com.human.dao.JobsDao;
import com.human.dto.JobsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobsDelete implements JobsExecute{

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
		System.out.println("삭제할 직무 정보를 입력하세요.");
		System.out.println("job_id 입력");
		String jobId = DBConn.inputString();
		

		JobsDto dto = new JobsDto();
		dto.setJobId(jobId);
		
		request.setJobsDto(dto);
		
	}

	@Override
	public void logic(Request request, Response response) {
		JobsDto dto = request.getJobsDto();
		JobsDao dao = new JobsDao();
		int i = dao.delete(dto.getJobId());
		
		response.setResultValue(i);
		
	}

	@Override
	public void outputView(Request request, Response response) {
		JobsDto req = request.getJobsDto();
		
		System.out.println(req.getJobId()+"직무를 삭제하였습니다.");
		
	}

	
}
