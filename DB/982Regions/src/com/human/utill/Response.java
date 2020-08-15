package com.human.utill;

import java.util.ArrayList;

import com.human.dto.RegionsDto;

public class Response {
	private ArrayList<RegionsDto> arrRegionsDto=new ArrayList<RegionsDto>();
	private int resultValue=0;
	public ArrayList<RegionsDto> getArrRegionsDto(){
		return arrRegionsDto;
	}
	public void setArrRegionsDto(ArrayList<RegionsDto> arrRegionsDto) {
		this.arrRegionsDto=arrRegionsDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue=resultValue;
	}
	
}
