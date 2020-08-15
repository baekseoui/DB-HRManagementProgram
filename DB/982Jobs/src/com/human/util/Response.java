package com.human.util;

import java.util.ArrayList;

import com.human.dto.JobsDto;

public class Response {
	private ArrayList<JobsDto> arrJobsDto = new ArrayList<JobsDto>();
	private int resultValue = 0;
	public ArrayList<JobsDto> getArrJobsDto() {
		return arrJobsDto;
	}
	public void setArrJobsDto(ArrayList<JobsDto> arrJobsDto) {
		this.arrJobsDto = arrJobsDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	
	
	
}
