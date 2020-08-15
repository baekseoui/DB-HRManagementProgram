package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.RegionsDto;
import com.human.utill.DBConn;

public class RegionsDao {
	public int insert(RegionsDto dto) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="insert into Region "
				+"values (%d,'%s')";
		sql=String.format(sql,dto.getRegionID(),dto.getRegionDescription());
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	public int update(int RegionID,String RegionDescription) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="update Region set RegionDescription='%s'"
				+"where RegionID=%d";
		sql=String.format(sql,RegionDescription,RegionID);
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	public int delete(int RegionID) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="delete Region where RegionID=%d ";
				sql=String.format(sql,RegionID);
				returnValue=DBConn.statementUpdate(sql);
				DBConn.dbClose();
				return returnValue;
	}
	public ArrayList<RegionsDto> select(){
		ArrayList<RegionsDto> dtos=new ArrayList<RegionsDto>();
		DBConn.getInstance();
		String sql="select * from Region";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				RegionsDto dto=new RegionsDto();
				dto.setRegionID(rs.getInt("RegionID"));
				dto.setRegionDescription(rs.getString("RegionDescription"));
				dtos.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
	
	

