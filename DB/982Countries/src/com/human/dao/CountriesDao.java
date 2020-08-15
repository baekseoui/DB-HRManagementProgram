package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.CountriesDto;
import com.human.util.DBConn;

public class CountriesDao {
	public int insert(CountriesDto dto) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="insert into countries "+"values ('%s','%s',%d)";
		sql=String.format(sql,dto.getCountry_id(),dto.getCountry_name(),dto.getRegion_id());
		returnValue=DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	
	public int update(String country_name,String country_id) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="update countries "
				+ "set country_name='%s' "
				+ "where country_id='%s'";
		sql=String.format(sql,country_name,country_id);
		returnValue=DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	
	public int delete(String country_id) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="delete countries "
				+ "where country_id='%s'";
		sql=String.format(sql,country_id);
		returnValue=DBConn.StatementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	public ArrayList<CountriesDto> select(){
		ArrayList<CountriesDto> dtos=new ArrayList<CountriesDto>();
		DBConn.getInstance();
		String sql="select * from countries";
		ResultSet rs=DBConn.StatementQuery(sql);
		try {
			while(rs.next()) {
				CountriesDto dto=new CountriesDto();
				dto.setCountry_id(rs.getString("country_id"));
				dto.setCountry_name(rs.getString("country_name"));
				dto.setRegion_id(rs.getInt("region_id"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
}
