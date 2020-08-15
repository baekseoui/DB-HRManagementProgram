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
		System.out.println("������ ���� ������ �Է��ϼ���.");
		System.out.println("job_id �Է�");
		String jobId = DBConn.inputString();
		System.out.println("���� �Է� (min_salary �Ǵ� max_salary)");
		item = DBConn.inputString();
		System.out.println("�ݾ� �Է�");
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
			System.out.println(request.getJobsDto().getJobId()+"������ ���� �޿��� �����Ͽ����ϴ�.");
		}else if(item.equals("max_salary")) {
			System.out.println(request.getJobsDto().getJobId()+"������ �ְ� �޿��� �����Ͽ����ϴ�.");
		}
		
	}

	
}
