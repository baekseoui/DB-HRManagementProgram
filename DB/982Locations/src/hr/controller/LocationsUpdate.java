package hr.controller;

import java.util.ArrayList;

import hr.dao.LocationsDao;
import hr.dto.LocationsDto;
import hr.util.DBConn;
import hr.util.Request;
import hr.util.Response;

public class LocationsUpdate implements LocationsExecute {
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
		System.out.println("수정할 내용을 입력합니다.");
		System.out.println("LOCATION_ID을 입력하세요");
		int locationId = DBConn.inputInt();
		System.out.println("변경을 원하는STREET_ADDRESS 의 내용을 입력하세요");
		String col = DBConn.inputString();
	
		
		LocationsDto dto=new LocationsDto();
		dto.setStreetAddress(col);
		dto.setLocationId(locationId);
		request.setLocationsDto(dto);
				

	}

	@Override
	public void logic(Request request,Response response) {
		LocationsDto dto=request.getLocationsDto();
		//update
		LocationsDao dao=new LocationsDao();
		int i=dao.update(dto.getStreetAddress(),dto.getLocationId());
		response.setResultValue(i);
//		request=i;
		

	}

	@Override
	public void outputView(Request request,Response response) {
		System.out.println(request.getLocationsDto().getLocationId()
				+"번 데이터의 내용을 ' "+request.getLocationsDto().getStreetAddress()
				+"' 로 "+response.getResultValue()
				+"개 변경되었습니다.");

	}

}
