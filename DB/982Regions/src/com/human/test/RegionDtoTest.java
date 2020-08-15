package com.human.test;

import com.human.dao.RegionsDao;
import com.human.dto.RegionsDto;

public class RegionDtoTest {

	public static void main(String[] args) {
		RegionsDao dao=new RegionsDao();
		RegionsDto dto=new RegionsDto();
		dto.setRegionID(1);
		dto.setRegionDescription("LA");
		int result=dao.insert(dto);
		System.out.println(result);
	}
}