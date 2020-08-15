package com.human.controll;

import com.human.dao.CountriesDao;
import com.human.dto.CountriesDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class CountryInsert implements CountryExecute {
	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("국가 정보를 입력");
		System.out.println("국가 아이디 입력");
		String country_id=DBConn.inputString();
		System.out.println("국가명 입력");
		String country_name=DBConn.inputString();
		System.out.println("지역 아이디 입력");
		int region_id=DBConn.inputInt();
		
		CountriesDto dto=new CountriesDto();
		dto.setCountry_id(country_id);
		dto.setCountry_name(country_name);
		dto.setRegion_id(region_id);
		request.setCountriesDto(dto);
	}
	@Override
	public void logic(Request request, Response response) {
		CountriesDto dto=request.getCountriesDto();
		CountriesDao dao=new CountriesDao();
		int i=dao.insert(dto);
		response.setResultValue(i);
	}
	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());
	}
}
