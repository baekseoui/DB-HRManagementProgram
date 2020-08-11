package com.human.dto;

public class JobHistoryDto {

////////**** 서의
	private int employee_id;

//////// **** 서의
	public int getEmployee_id() {
		return employee_id;
	}

//////// **** 서의
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	private String startDate;
	private String endDate;
	private String jobId;
	private int departmentId;

	public JobHistoryDto() {
	}

	public JobHistoryDto(int employeeId, String startDate, String endDate, String jobId, int departmentId) {
		this.employee_id = employee_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "JobHistoryDto [employeeId=" + employee_id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", jobId=" + jobId + ", departmentId=" + departmentId + "]";
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
