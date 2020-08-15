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
		System.out.println("������ ������ �Է��մϴ�.");
		System.out.println("LOCATION_ID�� �Է��ϼ���");
		int locationId = DBConn.inputInt();
		System.out.println("������ ���ϴ�STREET_ADDRESS �� ������ �Է��ϼ���");
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
				+"�� �������� ������ ' "+request.getLocationsDto().getStreetAddress()
				+"' �� "+response.getResultValue()
				+"�� ����Ǿ����ϴ�.");

	}

}
