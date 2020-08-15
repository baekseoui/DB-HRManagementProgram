package com.human.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.human.controller.EmployeesDelete;
import com.human.controller.EmployeesExecute;
import com.human.controller.EmployeesInsert;
import com.human.controller.EmployeesSelect;
import com.human.controller.EmployeesUpdate;
import com.human.dto.EmployeesDto;

public class EmployeesControllerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String select = "";
		EmployeesExecute pe = null;

		
		//(60,'aaa','aaa','aa','aaa',sysdate,'SH_CLERK',1,0.1,103,60);
		System.out.println("0.입력 1.수정 2.삭제 3.출력");
		select = sc.nextLine();
		switch(select) {
		case "0":
			pe = new EmployeesInsert();
			break;
		case "1":
			pe = new EmployeesUpdate();
			break;
		case "2":
			pe = new EmployeesDelete();
			break;
		case "3":
			pe = new EmployeesSelect();
		default :
			break;
		}
		
		pe.execute();
		
		
	}

}
