package com.human.dto;

public class JobsDto {
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	private String updateItem;
	
	public JobsDto() {};
	public JobsDto(String jobId, String jobTitle, int minSalary, int maxSalary, String updateItem) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.updateItem = updateItem;
	}
	
	@Override
	public String toString() {
		return "JobsDto [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getUpdateItem() {
		return updateItem;
	}
	public void setUpdateItem(String updateItem) {
		this.updateItem = updateItem;
	}
	
	
	
}
