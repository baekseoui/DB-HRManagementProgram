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

	//�Է�
	public void inputView(Request request, Response response) {
		System.out.println("ȸ�� ������ �Է��ϼ���.");
		
		System.out.println("employeeId �Է�");
		System.out.println("(100~200���̸� �Է��ϼ���.)");
		int employeeId=DBConn.inputInt();
		
		System.out.println("startDate �Է�");
		System.out.println("(�ݵ�� �ߺ��� ���� ����� �ϸ�");
		System.out.println("endDate ���� ��¥�� �۾ƾ� �մϴ�.)");
		String startDate=DBConn.inputString();
		
		System.out.println("endDate �Է�");
		System.out.println("(startDate ���� ��¥�� Ŀ�� �մϴ�.)");
		String endDate=DBConn.inputString();
		
		System.out.println("jobId �Է�");
		System.out.println("(�ݵ�� �빮�ڿ��� �ϸ� �����ϴ� jobId���� �մϴ�.)");
		String jobId=DBConn.inputString();	
		
		System.out.println("departmentId �Է�");
		int departmentId=DBConn.inputInt();
		
		JobHistoryDto dto=new JobHistoryDto();		
		dto.setEmployeeId(employeeId);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setJobId(jobId);
		dto.setDepartmentId(departmentId);
		
		request.setJobHistoryDto(dto);
	}
	
	//ó��
	public void logic(Request request, Response response) {
		JobHistoryDto dto=request.getJobHistoryDto();		
		JobHistoryDao dao=new JobHistoryDao();
		
		int i=dao.insert(dto);
		response.setResultValue(i);
	}
	
	//���
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());
	}


}
