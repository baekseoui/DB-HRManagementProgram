package com.human.dto;

public class RegionsDto {
	private int RegionID;
	private String RegionDescription;
	
	public void RegionDto() {};
	public void RegionDto(int RegionID,String RegionDescription) {
		
		this.RegionID=RegionID;
		this.RegionDescription=RegionDescription;
	}
	//toString 
	@Override
	public String toString() {
		return "RegionDto [RegionID=" + RegionID 
				+ ", RegionDescription=" + RegionDescription + "]";
	}
	// getter,setter
	public int getRegionID() {
		return RegionID;
	}
	public void setRegionID(int RegionID) {
		this.RegionID=RegionID;
	}
	public String getRegionDescription() {
		return RegionDescription;
	}
	public void setRegionDescription(String RegionDescription) {
		this.RegionDescription=RegionDescription;
	}
	
}
	
