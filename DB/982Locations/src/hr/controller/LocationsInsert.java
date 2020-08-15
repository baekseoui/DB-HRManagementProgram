package hr.controller;

import java.util.ArrayList;

import hr.dao.LocationsDao;
import hr.dto.LocationsDto;
import hr.util.DBConn;
import hr.util.Request;
import hr.util.Response;

public class LocationsInsert implements LocationsExecute{
	@Override
	public void execute() {
		LocationsDto request=new LocationsDto();
		ArrayList<LocationsDto> response=new ArrayList<LocationsDto>();
		
//		inputView(request,response);
//		logic(request,response);
//		outputView(request,response);

	}
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}
	public void inputView(Request request,Response response) {
		System.out.println("�߰� �Ͻ� ������ �Է��ϼ���.");
		//����� �Է��� �޾Ƽ� �����͸� �߰��غ���
				System.out.println("LOCATION_ID�� �Է�(����)");
				int locationId=DBConn.inputInt();
				System.out.println("STREET_ADDRESS�� �Է�(����)");
				String streetAddress=DBConn.inputString();
				System.out.println("POSTAL_CODE�� �Է�(����)");
				String postalCode=DBConn.inputString();
				System.out.println("CITY�� �Է�(����)");
				String city=DBConn.inputString();
				System.out.println("STATE_PROVINCE�� �Է�(����)");
				String stateProvince=DBConn.inputString();
				System.out.println("COUNTRY_ID�� �Է� (�빮�� �Է�)( IT,UK,CA,JP,US,CN,IN ");
				System.out.println("                          AU,SG,DE,BR,CH,NL,MX");
				
				String countryId=DBConn.inputString();
				
				LocationsDto dto=new LocationsDto();
				dto.setLocationId(locationId);		
				dto.setStreetAddress(streetAddress);		
				dto.setPostalCode(postalCode);		
				dto.setCity(city);	
				dto.setStateProvince(stateProvince);	
				dto.setCountryId(countryId);	
				request.setLocationsDto(dto);
	}
	
	public void logic(Request request,Response response) {
		
		LocationsDto dto=request.getLocationsDto();
		//insert
		LocationsDao dao=new LocationsDao();
		int i=dao.insert(dto);
		response.setResultValue(i);
		
		
	}
	
	public void outputView(Request request,Response response) {
		System.out.println(response.getResultValue()+"�� �߰� �Ϸ�");
		
		
	}
	
	
}
