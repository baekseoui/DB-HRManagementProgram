package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.human.dto.JobHistoryDto;
import com.human.util.DBConn;

public class JobHistoryDao {	
	//insert
	public int insert(JobHistoryDto dto) {
		int returnValue=0;
		
		//employeedID : 제약조건 있음, 100~200
		//jobId : 제약조건 있음, 있는 직업 아이디로 입력
		
		String sql="insert into job_history "
				+ "values (%d, to_date('%s','yy-mm-dd'),to_date('%s','yy-mm-dd'),'%s',%d)";
		
		sql=String.format(sql,dto.getEmployeeId(),
				dto.getStartDate(),dto.getEndDate(),
				dto.getJobId(),dto.getDepartmentId());
		
		returnValue=DBConn.statementUpdate(sql);		
		DBConn.dbClose();		
		return returnValue;
	}
	
	public int update(String startDate,int employeeId) {
				
		int returnValue=0;
		
		DBConn.getInstance();
		String sql="update job_history set employee_id=%d where "
				+ "start_date=to_date('%s','yy-MM-dd')";
		
		sql=String.format(sql,employeeId,startDate);
		
		returnValue=DBConn.statementUpdate(sql);	
		System.out.println(sql);
		DBConn.dbClose();		
		return returnValue;
	}

	public int delete(String startDate) {
		int returnValue=0;
		
		DBConn.getInstance();
		
		String sql="delete from job_history where "
				+ "start_date=to_date('%s','yy/mm/dd')";		
		
		sql=String.format(sql,startDate);
		
		returnValue=DBConn.statementUpdate(sql);
		
		DBConn.dbClose();
		
		return returnValue;
	}

	public ArrayList<JobHistoryDto> select(){
		
		ArrayList<JobHistoryDto> dtos=new ArrayList<JobHistoryDto>();
			
		DBConn.getInstance();
			
		String sql="select * from job_history";
			
		ResultSet rs=DBConn.statementQuerry(sql);
			
		try {
			while(rs.next()) {
				JobHistoryDto dto=new JobHistoryDto();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setStartDate(rs.getString("start_date"));
				dto.setEndDate(rs.getString("end_date"));
				dto.setJobId(rs.getString("job_id"));
				dto.setDepartmentId(rs.getInt("department_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dtos;
	}	
}
