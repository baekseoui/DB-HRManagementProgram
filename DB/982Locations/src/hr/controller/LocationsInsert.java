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
		System.out.println("추가 하실 정보를 입력하세요.");
		//사용자 입력을 받아서 데이터를 추가해보자
				System.out.println("LOCATION_ID를 입력(숫자)");
				int locationId=DBConn.inputInt();
				System.out.println("STREET_ADDRESS를 입력(문자)");
				String streetAddress=DBConn.inputString();
				System.out.println("POSTAL_CODE를 입력(문자)");
				String postalCode=DBConn.inputString();
				System.out.println("CITY를 입력(문자)");
				String city=DBConn.inputString();
				System.out.println("STATE_PROVINCE를 입력(문자)");
				String stateProvince=DBConn.inputString();
				System.out.println("COUNTRY_ID를 입력 (대문자 입력)( IT,UK,CA,JP,US,CN,IN ");
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
		System.out.println(response.getResultValue()+"개 추가 완료");
		
		
	}
	
	
}
