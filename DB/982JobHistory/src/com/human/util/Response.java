package com.human.util;

import java.util.ArrayList;
import com.human.dto.JobHistoryDto;

public class Response {
	private ArrayList<JobHistoryDto> arrJobHistoryDto=null;
	private int resultValue=0;
	
	public ArrayList<JobHistoryDto> getArrJobHistoryDto() {
		return arrJobHistoryDto;
	}
	public void setArrJobHistoryDto(ArrayList<JobHistoryDto> arrJobHistoryDto) {
		this.arrJobHistoryDto = arrJobHistoryDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
}
