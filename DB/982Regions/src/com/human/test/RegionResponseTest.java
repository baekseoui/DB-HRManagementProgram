package com.human.test;

import java.util.Scanner;

import com.human.controller.RegionInsert;
import com.human.controller.RegionSelect;
import com.human.controller.RegionUpdate;
import com.human.controller.RegionsDelete;
import com.human.controller.RegionsExecute;
import com.human.utill.Request;
import com.human.utill.Response;

public class RegionResponseTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("실행할 작업을 선택하세요.");
		System.out.println("1.Insert 2.Update 3.Delete 4.Select");
		int select=sc.nextInt();
		RegionsExecute re=null;
		Response response=new Response();
		Request request=new Request();

		switch(select) {
		case 1:
			re=new RegionInsert();
			break;
		case 2:
			re=new RegionUpdate();
			break;
		case 3:
			re=new RegionsDelete();
			break;
		case 4:
			re=new RegionSelect();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		re.execute(request,response);
		sc.close();
		System.out.println("종료");
	}

}
