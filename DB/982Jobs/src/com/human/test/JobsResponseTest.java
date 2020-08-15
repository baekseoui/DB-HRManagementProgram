package com.human.test;

import java.util.Scanner;

import com.human.controller.JobsDelete;
import com.human.controller.JobsExecute;
import com.human.controller.JobsInsert;
import com.human.controller.JobsSelect;
import com.human.controller.JobsUpdate;
import com.human.util.Request;
import com.human.util.Response;

public class JobsResponseTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("실행할 작업을 선택하세요.");
		System.out.println("1.Insert 2.Update 3.Delete 4.Select");
		int select = sc.nextInt();
		sc.nextLine();
		
		JobsExecute pe = null;
		
		Response response = new Response();
		Request request = new Request();
		
		switch(select) {
		case 1:
			pe = new JobsInsert();
			break;
		case 2:
			pe = new JobsUpdate();
			break;
		case 3:
			pe = new JobsDelete();
			break;
		case 4:
			pe = new JobsSelect();
			break;
		default:
			break;
		}
		pe.execute(request, response);
		
		sc.close();

	}

}
