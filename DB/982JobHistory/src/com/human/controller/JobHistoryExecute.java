package com.human.controller;

import com.human.util.Request;
import com.human.util.Response;

public interface JobHistoryExecute {
	public void execute();
	public void execute(Request request, Response response); 	
	//입력
	public void inputView(Request request,Response response);	
	//처리
	public void logic(Request request,Response response); 
	//결과
	public void outputView(Request request,Response response) ;
}
