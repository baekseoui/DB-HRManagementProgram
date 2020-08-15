package com.human.test;

import com.human.controller.RegionInsert;
import com.human.controller.RegionSelect;
import com.human.controller.RegionUpdate;
import com.human.controller.RegionsDelete;
import com.human.controller.RegionsExecute;

public class RegionControllerTest {

	public static void main(String[] args) {
		int select=1;
		RegionsExecute re=null;
		
		switch(select) {
		case 1:
			re=new RegionInsert();
			break;
		case 2:
			re=new RegionUpdate();
			break;
		case 3:
			re=new RegionsDelete();
			break;
		case 4:
			re=new RegionSelect();
			break;
		default:
			break;
		}
		re.execute();
	}

}
