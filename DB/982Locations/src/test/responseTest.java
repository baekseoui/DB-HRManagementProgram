package test;

import hr.controller.LocationsDelete;
import hr.controller.LocationsExecute;
import hr.controller.LocationsInsert;
import hr.controller.LocationsSelect;
import hr.controller.LocationsUpdate;
import hr.util.Request;
import hr.util.Response;

public class responseTest {

	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int select;
		LocationsExecute pe=null;
		Response response=new Response();
		Request request=new Request();
		System.out.println("���ϴ� �۾��� �����ϼ���");
		System.out.println("1.Insert 2.Update 3.Delete  4.Select ");
		select=sc.nextInt();
		if(select<5) {

		switch(select) {
		
		case 1:
			pe=new LocationsInsert();
			break;
		case 2:

			pe=new LocationsUpdate();
			break;
		case 3:
			pe=new LocationsDelete();
			break;
		case 4:
			pe=new LocationsSelect();
			break;
		default:
			System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			break;
		}
		pe.execute(request, response);
		sc.close();
		} else {
			System.out.println("���� �޴� �Դϴ�.");
		}
	
		
//		pe.execute();

	}

}
