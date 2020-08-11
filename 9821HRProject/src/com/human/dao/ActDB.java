package com.human.dao;

import java.util.ArrayList;

public class ActDB {
	public String getFieldSeq1;// all;part
	public String getFieldSeq2;// 필요한 필드수
	public String getFieldSeq3;// math적용할 필드 번호
	public ArrayList<String> getFieldSeq4;// 필요한 필드 번호; 사이즈는 getFieldSeq2임

	public String needed_field_num1;
	// public String order_field_num_main = "0";

	public String ask_group1;// Y;N

//	public String ask_order1;// 1~11
//	public String ask_order2;// A;D

	public String ask_str_compare1;

	public String ask_contain1;

	public String ask_num_compare1;

	public String ask_num_compare_sub1;

	public String ask_between1;
	public String ask_between2;

	public boolean total_salary = false;
	public boolean between = false;
	public boolean strComp = false;
	public boolean numComp = false;
	public boolean contain = false;
	public boolean order = false;
	public boolean group = false;

	public ArrayList<Integer> columnList_departments;
	public ArrayList<Integer> columnList_locations;
	public ArrayList<Integer> columnList_job_history;
	public ArrayList<Integer> columnList_jobs;
	public ArrayList<Integer> columnList_countries;
	public ArrayList<Integer> columnList_regions;

	public ArrayList<Integer> order_field_num_list;
	public ArrayList<String> order_option_list;

	public boolean print_result = true;

	public ActDB() {
		getFieldSeq4 = new ArrayList<String>();
		order_field_num_list = new ArrayList<Integer>();
		order_option_list = new ArrayList<String>();
		columnList_departments = new ArrayList<Integer>();
		columnList_locations = new ArrayList<Integer>();
		columnList_job_history = new ArrayList<Integer>();
		columnList_jobs = new ArrayList<Integer>();
		columnList_countries = new ArrayList<Integer>();
		columnList_regions = new ArrayList<Integer>();
	}

	public void columnlist_init() {
		print_result = true;
		columnList_departments = new ArrayList<Integer>();
		columnList_locations = new ArrayList<Integer>();
		columnList_job_history = new ArrayList<Integer>();
		columnList_jobs = new ArrayList<Integer>();
		columnList_countries = new ArrayList<Integer>();
		columnList_regions = new ArrayList<Integer>();
	}
}
