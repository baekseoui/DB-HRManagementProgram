package com.human.test;

import java.util.Scanner;
import com.human.controller.JobHistoryDelete;
import com.human.controller.JobHistoryExecute;
import com.human.controller.JobHistoryInsert;
import com.human.controller.JobHistorySelect;
import com.human.controller.JobHistoryUpdate;
import com.human.util.Request;
import com.human.util.Response;

public class Test {

	public static void main(String[] args) {
		
		
		JobHistoryExecute pe=null;
		Response response=new Response();
		Request request=new Request();

		System.out.println("0:입력 1:수정 2:삭제 3:출력");
		Scanner sc=new Scanner(System.in);
		String select=sc.nextLine();
		
		switch(select) {
			case "0":
				pe=new JobHistoryInsert();
				break;
			case "1":
				pe=new JobHistoryUpdate();
				break;	
			case "2":
				pe=new JobHistoryDelete();
				break;
			case "3":
				pe=new JobHistorySelect();
			default:
				break;
		}
		pe.execute(request, response);			
	}

}
