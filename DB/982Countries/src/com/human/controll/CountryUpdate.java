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
		System.out.println("변경할 국가코드를 입력하세요.");
		System.out.println("Country_id 입력>>>");
		String country_id=DBConn.inputString();
		System.out.println("변경하고싶은 이름 입력>>>");
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
		System.out.println(request.getCountriesDto().getCountry_id()+"의 내용을 변경하였습니다.");
	}

}
