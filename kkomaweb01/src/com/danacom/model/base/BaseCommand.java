package com.danacom.model.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseCommand {
	public String exec(HttpServletRequest request, HttpServletResponse response);
}
