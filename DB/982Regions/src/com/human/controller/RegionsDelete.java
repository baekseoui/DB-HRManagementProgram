package com.human.controller;

import java.util.ArrayList;

import com.human.dao.RegionsDao;
import com.human.dto.RegionsDto;
import com.human.utill.DBConn;
import com.human.utill.Request;
import com.human.utill.Response;

public class RegionsDelete implements RegionsExecute{
	@Override
	public void execute() {
		RegionsDto request=new RegionsDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
	}
	@Override
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("삭제할 id 번호를 입력하세요.");
		int RegionID=DBConn.inputInt();
		RegionsDto dto=new RegionsDto();
		dto.setRegionID(RegionID);
		request.setRegionsDto(dto);
	}
	@Override
	public void logic(Request request, Response response) {
		RegionsDto dto=request.getRegionsDto();
		RegionsDao dao=new RegionsDao();
		int i=dao.delete(dto.getRegionID());
		response.setResultValue(i);
	}
	@Override
	public void outputView(Request request,Response response) {
		RegionsDto req=request.getRegionsDto();
		
		System.out.println("id "+req.getRegionID()+"를"
				+response.getResultValue()+"개를 삭제하였습니다.");
	}
	
}

