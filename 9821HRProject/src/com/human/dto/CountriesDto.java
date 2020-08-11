package com.human.dto;

public class CountriesDto {
	private String country_id;
	private String country_name;
	private int region_id;
	//////// **** 서의
	private int employee_id;
	
	public CountriesDto() {}
	public CountriesDto(String country_id, String country_name, int region_id, int employee_id) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.region_id = region_id;
		this.employee_id=employee_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	
	@Override
	public String toString() {
		return "CountriesDto [country_id=" + country_id + ", country_name=" + country_name + ", region_id=" + region_id
				+ "]";
	}	
}