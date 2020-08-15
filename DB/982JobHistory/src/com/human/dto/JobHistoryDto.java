package com.human.dto;

public class JobHistoryDto {
	private int employeeId;
	private String startDate;
	private String endDate;
	private String jobId;
	private int departmentId;
	
	public JobHistoryDto() {}

	public JobHistoryDto(int employeeId, String startDate, 
			String endDate, String jobId, int departmentId) {
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "JobHistoryDto [employeeId=" + employeeId + 
				", startDate=" + startDate + ", endDate=" + endDate
				+ ", jobId=" + jobId + ", departmentId=" + departmentId + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	};
	
	
}
