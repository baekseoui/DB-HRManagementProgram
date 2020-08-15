package hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hr.dto.LocationsDto;
import hr.util.DBConn;

public class LocationsDao {
	public int insert(LocationsDto dto) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="insert into locations "
				+ "values (%d,'%s','%s','%s','%s','%s')";
		sql=String.format(sql,dto.getLocationId(),dto.getStreetAddress()
				,dto.getPostalCode(),dto.getCity(),dto.getStateProvince(),
				dto.getCountryId());
			
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();		
		return returnValue;
	}
	
	public int update(String col,int locationId) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="update locations "
				+ "set street_address='%s' "
				+ "where location_id=%d";
		
		sql=String.format(sql,col,locationId);
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();		
		return returnValue;
	}
	
	public int delete(int locationId) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="delete locations "
				+ "where location_id=%d";
		sql=String.format(sql,locationId);
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();		
		return returnValue;
	}
	
	public ArrayList<LocationsDto> select() {
		ArrayList<LocationsDto> dtos=new ArrayList<LocationsDto>();
		DBConn.getInstance();
		String sql="select * from locations";
			ResultSet rs=DBConn.statementQuery(sql);
			try {
				while(rs.next()) {
					LocationsDto dto = new LocationsDto();
					dto.setLocationId(rs.getInt("location_id"));
					dto.setStreetAddress(rs.getString("street_address"));
					dto.setPostalCode(rs.getString("postal_code"));
					dto.setCity(rs.getString("city"));
					dto.setStateProvince(rs.getString("state_province"));
					dto.setCountryId(rs.getString("country_id"));
					
					dtos.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return dtos;
	}
}
