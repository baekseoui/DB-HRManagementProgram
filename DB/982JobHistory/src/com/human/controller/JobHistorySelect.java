package com.human.controller;

import java.util.ArrayList;
import com.human.dao.JobHistoryDao;
import com.human.dto.JobHistoryDto;
import com.human.util.Request;
import com.human.util.Response;


public class JobHistorySelect implements JobHistoryExecute {

	@Override
	public void execute() {
		JobHistoryDto request=new JobHistoryDto();
		ArrayList<JobHistoryDto> response=new ArrayList<JobHistoryDto>();
	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("��� ȸ���� ����� �����Դϴ�.");

	}

	@Override
	public void logic(Request request, Response response) {
		JobHistoryDao dao=new JobHistoryDao();		
		response.setArrJobHistoryDto(dao.select());

	}

	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<JobHistoryDto> dtos
			= response.getArrJobHistoryDto();;
			System.out.println("��� ������ �̷����ϴ�.");
			
			for(JobHistoryDto dto:dtos) {
				System.out.println(dtos);
			}
			
		}else {
			System.out.println("ȸ���� �����ϴ�.");
		}
	}

}
