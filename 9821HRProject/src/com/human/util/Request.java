package com.human.util;

import com.human.dto.CountriesDto;
import com.human.dto.DepartmentsDto;
import com.human.dto.EmployeesDto;
import com.human.dto.JobHistoryDto;
import com.human.dto.JobsDto;
import com.human.dto.LocationsDto;
import com.human.dto.RegionsDto;

public class Request {
	// Countries
	private CountriesDto countriesDto = null;

	public CountriesDto getCountriesDto() {
		return countriesDto;
	}

	public void setCountriesDto(CountriesDto countriesDto) {
		this.countriesDto = countriesDto;
	}

	// employees
	private EmployeesDto employeesDto = null;

	public EmployeesDto getEmployeesDto() {
		return employeesDto;
	}

	public void setEmployeesDto(EmployeesDto employeesDto) {
		this.employeesDto = employeesDto;
	}
	
	// job_histories
	private JobHistoryDto jobHistoryDto = null;

	public JobHistoryDto getJobHistoryDto() {
		return jobHistoryDto;
	}

	public void setJobHistoryDto(JobHistoryDto jobHistoryDto) {
		this.jobHistoryDto = jobHistoryDto;
	}

	// jobs
	private JobsDto jobsDto = null;

	public JobsDto getJobsDto() {
		return jobsDto;
	}

	public void setJobsDto(JobsDto jobsDto) {
		this.jobsDto = jobsDto;
	}

	// locations
	private LocationsDto LocationsDto = null;

	public LocationsDto getLocationsDto() {
		return LocationsDto;
	}

	public void setLocationsDto(LocationsDto locationsDto) {
		LocationsDto = locationsDto;
	}

	// regions
	private RegionsDto regionsDto = null;

	public RegionsDto getRegionsDto() {
		return regionsDto;
	}

	public void setRegionsDto(RegionsDto regionsDto) {
		this.regionsDto = regionsDto;
	}
	//departments
	private DepartmentsDto departmentsDto = null;
	public DepartmentsDto getDepartmentsDto() {
		return departmentsDto;
	}
	public void setDepartmentsDto(DepartmentsDto departmentsDto) {
		this.departmentsDto=departmentsDto;
		// TODO Auto-generated method stub
		
	}
}
