package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.EmployeesDto;
import com.human.util.DBConn;

public class EmployeesDao {
	public int insert(EmployeesDto dto){
		int returnvalue = 0;
		DBConn.getInstance();
		String sql = "insert into employees values (%d,'%s','%s','%s','%s',"
				+ "to_date('%s','yyyy-mm-dd hh24:mi:ss'),'%s',%d, %f, %d, %d )";
		sql = String.format(sql,dto.getEmployeeId(),dto.getFirstName(),dto.getLastName(),
				dto.getEmail(),dto.getPhoneNumber(),DBConn.dateToString(dto.getHireDate()),
				dto.getJobId(),dto.getSalaty(),dto.getCommissionPct(),dto.getManagerId(),
				dto.getDepartmentId());
		
		DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		
		return returnvalue;
	}
	public int update(String firstname, int employeeId){
		int returnvalue = 0;
		DBConn.getInstance();
		String sql = "update Employees set First_Name = '%s' where employee_Id = %d";
		
		sql = String.format(sql,firstname,employeeId);

		
		DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		return returnvalue;
		
	}
	public int delete(int employeeId){
		int returnvalue = 0;
		DBConn.getInstance();
		String sql = "delete from Employees where employee_Id = %d";
		
		sql = String.format(sql,employeeId);

		
		DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		return returnvalue;
	}
	
	public ArrayList<EmployeesDto> select(){
		ArrayList<EmployeesDto> dtos = new ArrayList<EmployeesDto>();
		DBConn.getInstance();
		String sql = "select * from Employees";
		ResultSet rs = DBConn.statementQuery(sql);
		
		try {
			while(rs.next()) {
				EmployeesDto dto = new EmployeesDto();
		
				dto.setEmployeeId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhoneNumber(rs.getString(5));
				dto.setHireDate(rs.getDate(6));
				dto.setJobId(rs.getString(7));
				dto.setSalaty(rs.getInt(8));
				dto.setCommissionPct(rs.getDouble(9));
				dto.setManagerId(rs.getInt(10));
				dto.setDepartmentId(rs.getInt(11));

				dtos.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	
	
	
}
