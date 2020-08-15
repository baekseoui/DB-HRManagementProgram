package hr.controller;

import java.util.ArrayList;

import hr.dao.LocationsDao;
import hr.dto.LocationsDto;
import hr.util.DBConn;
import hr.util.Request;
import hr.util.Response;

public interface LocationsExecute {
	public void execute();
	public void execute(Request request,Response response);
	public void inputView(Request request,Response response);
	public void logic(Request request,Response response);
	public void outputView(Request request,Response response);
	
	
}
 