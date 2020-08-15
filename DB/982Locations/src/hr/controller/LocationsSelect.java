package hr.controller;

import java.util.ArrayList;

import hr.dao.LocationsDao;
import hr.dto.LocationsDto;
import hr.util.Request;
import hr.util.Response;

public class LocationsSelect implements LocationsExecute {

	@Override
	public void execute() {
		LocationsDto request=new LocationsDto();
		ArrayList<LocationsDto> response=new ArrayList<LocationsDto>();
		
//		inputView(request,response);
//		logic(request,response);
//		outputView(request,response);

	}

	@Override
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request,Response response) {
		System.out.println("모든 정보를 출력합니다");
	}

	@Override
	public void logic(Request request,Response response) {
		LocationsDao dao=new LocationsDao();
		response.setArrLocationsDto(dao.select());

	}

	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<LocationsDto> dtos=
					response.getArrLocationsDto();
			for(LocationsDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("데이터가 없습니다");
		}

	}

}
