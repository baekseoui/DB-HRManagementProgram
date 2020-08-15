package com.human.util;

import java.util.ArrayList;

import com.human.dto.CountriesDto;

	public class Response {
	private ArrayList<CountriesDto> arrCountriesDto=null;
	private int resultValue=0;
	public ArrayList<CountriesDto> getArrCountriesDto() {
		return arrCountriesDto;
	}
	public void setArrPersonDto(ArrayList<CountriesDto> arrCountriesDto) {
		this.arrCountriesDto = arrCountriesDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
}
