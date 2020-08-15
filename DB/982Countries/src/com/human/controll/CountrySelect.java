package com.human.controll;

import java.util.ArrayList;

import com.human.dao.CountriesDao;
import com.human.dto.CountriesDto;
import com.human.util.Request;
import com.human.util.Response;

public class CountrySelect implements CountryExecute {
	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("모든 국가 목록을 출력할 예정입니다.");
	}
	@Override
	public void logic(Request request, Response response) {
		CountriesDao dao=new CountriesDao();
		response.setArrPersonDto(dao.select());
	}
	@Override
	public void outputView(Request request, Response response) {
		if(response!=null) {
			ArrayList<CountriesDto> dtos=response.getArrCountriesDto();
			System.out.println("국가정보는 다음과 같습니다.");
			for(CountriesDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("등록된 국가가 없습니다.");
		}
	}
}
