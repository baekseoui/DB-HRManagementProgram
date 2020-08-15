package hr.controller;

import java.util.ArrayList;

import hr.dao.LocationsDao;
import hr.dto.LocationsDto;
import hr.util.DBConn;
import hr.util.Request;
import hr.util.Response;

public class LocationsDelete implements LocationsExecute {

	@Override
	public void execute() {
		LocationsDto request=new LocationsDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
		
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
			System.out.println("삭제할 location_id를 입력하세요");
			int locationId=DBConn.inputInt();
			LocationsDto dto=new LocationsDto();
			dto.setLocationId(locationId);
			request.setLocationsDto(dto);
			

	}

	@Override
	public void logic(Request request,Response response) {
		LocationsDto dto=request.getLocationsDto();
		LocationsDao dao=new LocationsDao();
		int i=dao.delete(dto.getLocationId());
//		((ArrayList<Integer>)response).add(new Integer(i));
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request,Response response) {
		LocationsDto dto=request.getLocationsDto();
		System.out.println("locations_id"+dto.getLocationId()+" 를"
				+response.getResultValue()+"개 삭제하였습니다.");

	}

}
