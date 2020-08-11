package com.human.dto;

public class DepartmentsDto {
	private int depId;
	private String depName;
	private int depManager;
	private int depLocation;
	public boolean flag = false;
	//생성자
	public DepartmentsDto() {}
	public DepartmentsDto(int depId, String depName, int depManager, int depLocation) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depManager = depManager;
		this.depLocation = depLocation;
	}
	//toString
	@Override
	public String toString() {
		if(this.flag) {
			return "DepDto [depId=" + depId + "]";
		}
		return "DepDto [depId=" + depId + ", depName=" + depName + ", depManager=" + depManager + ", depLocation="
				+ depLocation + "]";
	}
	
	//getter and setter
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public int getDepManager() {
		return depManager;
	}
	public void setDepManager(int depManager) {
		this.depManager = depManager;
	}
	public int getDepLocation() {
		return depLocation;
	}
	public void setDepLocation(int depLocation) {
		this.depLocation = depLocation;
	}
	
}
