package com.human.controller;

import java.util.ArrayList;

import com.human.dao.RegionsDao;
import com.human.dto.RegionsDto;
import com.human.utill.DBConn;
import com.human.utill.Request;
import com.human.utill.Response;

public class RegionInsert implements RegionsExecute {
	@Override
	public void execute() {
		RegionsDto request=new RegionsDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
		
//		inputView(request,response);
//		logic(request,response);
//		outputView(request,response);
	}
	@Override
	public void execute(Request request,Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
		//		System.out.println("RegionID 입력");
//		int RegionID=DBConn.inputInt();
//		System.out.println("RegionDescription 입력");
//		String RegionDescription=DBConn.inputString();
//		RegionsDto dto=new RegionsDto();
//		dto.setRegionID(RegionID);
//		dto.setRegionDescription(RegionDescription);
//		request.setRegionsDto(dto);
	}
	@Override
	public void inputView(Request request,Response response) {
		System.out.println("id입력");
		int RegionID=DBConn.inputInt();
		System.out.println("RegionDescription 입력");
		String RegionDescription=DBConn.inputString();
		RegionsDto dto=new RegionsDto();
		dto.setRegionID(RegionID);
		dto.setRegionDescription(RegionDescription);
		request.setRegionsDto(dto);
	}
	@Override
	public void logic(Request request,Response response) {
		RegionsDto dto=request.getRegionsDto();
		RegionsDao dao=new RegionsDao();
		int i=dao.insert(dto);
		response.setResultValue(i);
	}
	@Override
	public void outputView(Request request,Response response) {
		System.out.println(response.getResultValue());
	}
	
	///////////////////////////////////////////
//	public void execute(Object request,Object response) {
//		inputView(request,response);
//		logic(request,response);
//		outputView(request,response);
//	}
//	public void inputView(Object request,Object response) {
//		System.out.println("id입력");
//		int RegionID=DBConn.inputInt();
//		System.out.println("RegionDescription 입력");
//		String RegionDescription=DBConn.inputString();
//		RegionsDto dto=new RegionsDto();
//		dto.setRegionID(RegionID);
//		dto.setRegionDescription(RegionDescription);
//	}
//	public void logic(Object request,Object response) {
//		RegionsDto dto=(RegionsDto)request;
//		RegionsDao dao=new RegionsDao();
//		int i=dao.insert(dto);
//		((ArrayList<Integer>)response).add(new Integer(i));
//	}
//		public void outputView(Object request,Object response) {
//			System.out.println(((ArrayList<Integer>)response).get(0));
//		
//	}
	
	
}
