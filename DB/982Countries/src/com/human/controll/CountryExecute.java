package com.human.controll;

import com.human.util.Request;
import com.human.util.Response;

public interface CountryExecute {
	public void execute(Request request,Response response);
	public void inputView(Request request,Response response);
	public void logic(Request request,Response response);
	public void outputView(Request request,Response response);
}
