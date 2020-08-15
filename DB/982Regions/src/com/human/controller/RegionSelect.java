package com.human.controller;

import java.util.ArrayList;

import com.human.dao.RegionsDao;
import com.human.dto.RegionsDto;
import com.human.utill.Request;
import com.human.utill.Response;

public class RegionSelect implements RegionsExecute {
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
	public void inputView(Request request,Response response) {
		System.out.println("��� ������ ����� �����Դϴ�.");
	}
	@Override
	public void logic(Request request,Response response) {
		RegionsDao dao=new RegionsDao();
		response.setArrRegionsDto(dao.select());
	}
	@Override
	public void outputView(Request request,Response response) {
		if(response!=null) {
			ArrayList<RegionsDto> dtos
				=response.getArrRegionsDto();
			System.out.println("������ ������ �����ϴ�.");
			for(RegionsDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("������ �����ϴ�.");
		}
	}
	
}
