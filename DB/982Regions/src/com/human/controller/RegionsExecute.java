package com.human.controller;

import com.human.utill.Request;
import com.human.utill.Response;

public interface RegionsExecute {
	public void execute();
	public void execute(Request request,Response response);
	public void inputView(Request request,Response response);
	public void logic(Request request,Response respoinse);
	public void outputView(Request request,Response response);
}
