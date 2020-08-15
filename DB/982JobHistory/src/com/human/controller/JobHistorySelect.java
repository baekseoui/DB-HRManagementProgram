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
		System.out.println("모든 회원을 출력할 예정입니다.");

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
			System.out.println("모든 정보는 이렇습니다.");
			
			for(JobHistoryDto dto:dtos) {
				System.out.println(dtos);
			}
			
		}else {
			System.out.println("회원이 없습니다.");
		}
	}

}
