package com.human.util;

import java.util.ArrayList;

import com.human.dto.CountriesDto;
import com.human.dto.EmployeesDto;
import com.human.dto.JobHistoryDto;
import com.human.dto.JobsDto;
import com.human.dto.RegionsDto;
import com.human.dto.LocationsDto;

public class Response {
	private int resultValue = 0;

	public int getResultValue() {
		return resultValue;
	}

	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}

	// countries
	private ArrayList<CountriesDto> arrCountriesDto = null;

	public ArrayList<CountriesDto> getArrCountriesDto() {
		return arrCountriesDto;
	}

	public void setArrPersonDto(ArrayList<CountriesDto> arrCountriesDto) {
		this.arrCountriesDto = arrCountriesDto;
	}

	// employees
	private ArrayList<EmployeesDto> arrEmployeesDto = null;

	public ArrayList<EmployeesDto> getArrEmployeesDto() {
		return arrEmployeesDto;
	}

	public void setArrEmployeesDto(ArrayList<EmployeesDto> arrEmployeesDto) {
		this.arrEmployeesDto = arrEmployeesDto;
	}

	// job_histories
	private ArrayList<JobHistoryDto> arrJobHistoryDto = null;

	public ArrayList<JobHistoryDto> getArrJobHistoryDto() {
		return arrJobHistoryDto;
	}

	public void setArrJobHistoryDto(ArrayList<JobHistoryDto> arrJobHistoryDto) {
		this.arrJobHistoryDto = arrJobHistoryDto;
	}

	// jobs
	private ArrayList<JobsDto> arrJobsDto = new ArrayList<JobsDto>();

	public ArrayList<JobsDto> getArrJobsDto() {
		return arrJobsDto;
	}

	public void setArrJobsDto(ArrayList<JobsDto> arrJobsDto) {
		this.arrJobsDto = arrJobsDto;
	}

	// locations
	private ArrayList<LocationsDto> arrLocationsDto = null;

	public ArrayList<LocationsDto> getArrLocationsDto() {
		return arrLocationsDto;
	}

	public void setArrLocationsDto(ArrayList<LocationsDto> arrLocationsDto) {
		this.arrLocationsDto = arrLocationsDto;
	}

	// regions
	private ArrayList<RegionsDto> arrRegionsDto = new ArrayList<RegionsDto>();

	public ArrayList<RegionsDto> getArrRegionsDto() {
		return arrRegionsDto;
	}

	public void setArrRegionsDto(ArrayList<RegionsDto> arrRegionsDto) {
		this.arrRegionsDto = arrRegionsDto;
	}
}
