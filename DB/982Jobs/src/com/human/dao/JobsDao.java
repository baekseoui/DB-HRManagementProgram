package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.JobsDto;
import com.human.util.DBConn;

public class JobsDao {
	public int insert(JobsDto dto) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "insert into jobs "
				+"values ('%s', '%s', %d, %d)";
		sql = String.format(sql, dto.getJobId(), 
				dto.getJobTitle(), dto.getMinSalary(), dto.getMaxSalary());
		
		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	
	public int update(String item, int salary, String jobId ) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "update jobs set %s = %d "
				+ "where job_id like '%s'";
		sql = String.format(sql, item, salary, jobId);
		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
				
		return returnValue;
	}
	
	public int delete(String jobId) {
		int returnValue = 0;
		DBConn.getInstance();
		String sql = "delete jobs where job_id like '%s'";
		
		sql = String.format(sql, jobId);
		returnValue = DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
		
	}
	public ArrayList<JobsDto> select(){
		
		ArrayList<JobsDto> dtos = new ArrayList<JobsDto>();
		DBConn.getInstance();
		String sql = "select * from jobs";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				JobsDto dto = new JobsDto();
				dto.setJobId(rs.getString("job_id"));
				dto.setJobTitle(rs.getString("job_title"));
				dto.setMinSalary(rs.getInt("min_salary"));
				dto.setMaxSalary(rs.getInt("max_salary"));
				
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dtos;
	}
}
