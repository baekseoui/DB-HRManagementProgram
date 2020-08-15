package com.human.controller;

import java.util.ArrayList;
import java.util.Date;
import com.human.dao.JobHistoryDao;
import com.human.dto.JobHistoryDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class JobHistoryInsert implements JobHistoryExecute{

	@Override
	public void execute() {
		JobHistoryDto request=new JobHistoryDto();
		ArrayList<Integer> response=new ArrayList<Integer>();	
	}
	
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);		
	}

	//입력
	public void inputView(Request request, Response response) {
		System.out.println("회원 정보를 입력하세요.");
		
		System.out.println("employeeId 입력");
		System.out.println("(100~200사이를 입력하세요.)");
		int employeeId=DBConn.inputInt();
		
		System.out.println("startDate 입력");
		System.out.println("(반드시 중복된 값이 없어야 하며");
		System.out.println("endDate 보다 날짜가 작아야 합니다.)");
		String startDate=DBConn.inputString();
		
		System.out.println("endDate 입력");
		System.out.println("(startDate 보다 날짜가 커야 합니다.)");
		String endDate=DBConn.inputString();
		
		System.out.println("jobId 입력");
		System.out.println("(반드시 대문자여야 하며 존재하는 jobId여야 합니다.)");
		String jobId=DBConn.inputString();	
		
		System.out.println("departmentId 입력");
		int departmentId=DBConn.inputInt();
		
		JobHistoryDto dto=new JobHistoryDto();		
		dto.setEmployeeId(employeeId);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setJobId(jobId);
		dto.setDepartmentId(departmentId);
		
		request.setJobHistoryDto(dto);
	}
	
	//처리
	public void logic(Request request, Response response) {
		JobHistoryDto dto=request.getJobHistoryDto();		
		JobHistoryDao dao=new JobHistoryDao();
		
		int i=dao.insert(dto);
		response.setResultValue(i);
	}
	
	//결과
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());
	}


}
