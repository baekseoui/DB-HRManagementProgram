package com.human.test;

import java.util.ArrayList;

import com.human.dao.JobsDao;
import com.human.dto.JobsDto;

public class JobsDtotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobsDao dao = new JobsDao();
		ArrayList<JobsDto> dtos = dao.select();
		for(JobsDto dto:dtos) {
			System.out.println(dto);
		}
	}

}
