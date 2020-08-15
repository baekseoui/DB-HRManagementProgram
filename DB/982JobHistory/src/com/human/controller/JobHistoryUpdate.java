package com.human.controller;

import java.util.ArrayList;
import com.human.dao.JobHistoryDao;
import com.human.dto.JobHistoryDto;
import com.human.util.DBConn;
import com.human.util.Response;
import com.human.util.Request;

public class JobHistoryUpdate implements JobHistoryExecute{
	
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
		System.out.println("startDate�� ������ employeeId�� �Է��ϼ���.");
		
		System.out.println("startDate �Է�");
		String startDate=DBConn.inputString();
		
		System.out.println("employeeId �Է�");
		int employeeId=DBConn.inputInt();				
		
		JobHistoryDto dto=new JobHistoryDto();	
		
		dto.setStartDate(startDate);		
		dto.setEmployeeId(employeeId);	
		request.setJobHistoryDto(dto);
	}

	@Override
	public void logic(Request request, Response response) {
		JobHistoryDto dto=request.getJobHistoryDto();		
		JobHistoryDao dao=new JobHistoryDao();
		
		int i=dao.update(dto.getStartDate(),dto.getEmployeeId());
		
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
		
		System.out.println(request.getJobHistoryDto().getStartDate()+"�����͸�"
				+(request.getJobHistoryDto().getEmployeeId()
				+" ������ �� "+(response.getResultValue()
				+"�� ����Ǿ����ϴ�.")));	
	}

} 
