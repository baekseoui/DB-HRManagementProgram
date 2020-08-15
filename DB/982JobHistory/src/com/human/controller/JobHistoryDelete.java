package com.human.controller;

import java.util.ArrayList;
import com.human.dao.JobHistoryDao;
import com.human.dto.JobHistoryDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobHistoryDelete implements JobHistoryExecute{

	@Override
	public void execute() {
		JobHistoryDto request=new JobHistoryDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);		
	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("������ �������� startDate�� �Է��ϼ���.");	
		
		System.out.println("startDate �Է� : ");				
		String startDate=DBConn.inputString();
		
		JobHistoryDto dto=new JobHistoryDto();		
		
		dto.setStartDate(startDate);
		request.setJobHistoryDto(dto);

	}

	@Override
	public void logic(Request request, Response response) {
		JobHistoryDto dto=request.getJobHistoryDto();		
		JobHistoryDao dao=new JobHistoryDao();
		
		int i=dao.delete(dto.getStartDate());
		response.setResultValue(i);
		
	}

	@Override
	public void outputView(Request request, Response response) {
		JobHistoryDto dto=request.getJobHistoryDto();		
		System.out.println("startDate "+dto.getStartDate()+
				"�� "+response.getResultValue()+"�� �����Ͽ����ϴ�.");
		
	}

}
