package com.human.controller;

import java.util.ArrayList;

import com.human.dao.JobsDao;
import com.human.dto.JobsDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobsUpdate implements JobsExecute{
	static String item;
	static int salary;
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
		System.out.println("변경할 직무 정보를 입력하세요.");
		System.out.println("job_id 입력");
		String jobId = DBConn.inputString();
		System.out.println("유형 입력 (min_salary 또는 max_salary)");
		item = DBConn.inputString();
		System.out.println("금액 입력");
		salary = DBConn.inputInt();
		
		

		JobsDto dto = new JobsDto();
		dto.setUpdateItem(item);
		if(item.equals("min_salary")) {
			dto.setMinSalary(salary);
		}else if(item.equals("max_salary")) {
			dto.setMaxSalary(salary);
		}
		dto.setJobId(jobId);
		
		request.setJobsDto(dto);
		
	}

	@Override
	public void logic(Request request, Response response) {
		int i=0;
		JobsDto dto = request.getJobsDto();
		JobsDao dao = new JobsDao();
		if(item.equals("min_salary")) {
			i = dao.update(dto.getUpdateItem(), dto.getMinSalary(), dto.getJobId());
		}else if(item.equals("max_salary")) {
			i = dao.update(dto.getUpdateItem(), dto.getMaxSalary(), dto.getJobId());
		}
		
		response.setResultValue(i);
		
	}

	@Override
	public void outputView(Request request, Response response) {
		if(item.equals("min_salary")) {
			System.out.println(request.getJobsDto().getJobId()+"직군의 최저 급여를 변경하였습니다.");
		}else if(item.equals("max_salary")) {
			System.out.println(request.getJobsDto().getJobId()+"직군의 최고 급여를 변경하였습니다.");
		}
		
	}

	
}
