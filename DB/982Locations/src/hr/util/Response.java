package hr.util;

import java.util.ArrayList;

import hr.dto.LocationsDto;

public class Response {
	private ArrayList<LocationsDto> arrLocationsDto=null;
	private int resultValue=0;
	public ArrayList<LocationsDto> getArrLocationsDto() {
		return arrLocationsDto;
	}
	public void setArrLocationsDto(ArrayList<LocationsDto> arrLocationsDto) {
		this.arrLocationsDto = arrLocationsDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	
}
