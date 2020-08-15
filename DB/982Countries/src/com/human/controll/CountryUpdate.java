package com.human.controll;

import com.human.dao.CountriesDao;
import com.human.dto.CountriesDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class CountryUpdate implements CountryExecute {

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("������ �����ڵ带 �Է��ϼ���.");
		System.out.println("Country_id �Է�>>>");
		String country_id=DBConn.inputString();
		System.out.println("�����ϰ���� �̸� �Է�>>>");
		String country_name=DBConn.inputString();
		
		CountriesDto dto=new CountriesDto();
		dto.setCountry_id(country_id);
		dto.setCountry_name(country_name);
		request.setCountriesDto(dto);
	}

	@Override
	public void logic(Request request, Response response) {
		CountriesDto dto=request.getCountriesDto();
		CountriesDao dao=new CountriesDao();
		int s=dao.update(dto.getCountry_name(),dto.getCountry_id());
		response.setResultValue(s);
	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(request.getCountriesDto().getCountry_id()+"�� ������ �����Ͽ����ϴ�.");
	}

}
