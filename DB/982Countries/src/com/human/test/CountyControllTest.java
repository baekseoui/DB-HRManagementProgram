package com.human.test;

import com.human.controll.CountryDelete;
import com.human.controll.CountryExecute;
import com.human.controll.CountryInsert;
import com.human.controll.CountrySelect;
import com.human.controll.CountryUpdate;
import com.human.util.Request;
import com.human.util.Response;

public class CountyControllTest {

	public static void main(String[] args) {
		int select=3;
		CountryExecute ce=null;
		Response response=new Response();
		Request request=new Request();
		
		switch(select) {
		case 0:
			ce=new CountryInsert();
			break;
		case 1:
			ce=new CountryUpdate();
			break;
		case 2:
			ce=new CountryDelete();
			break;
		case 3:
			ce=new CountrySelect();
			break;
		default:
			break;
		}
		ce.execute(request, response);
		System.out.println("Á¾·á");
	}

}
