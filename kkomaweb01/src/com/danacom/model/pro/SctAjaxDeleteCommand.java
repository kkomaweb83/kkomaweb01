package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.Shop_cart;

public class SctAjaxDeleteCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		Shop_cart sctCommand = new Shop_cart();
		sctCommand.setSct_no(Integer.parseInt(request.getParameter("sct_no")));
		sctCommand.setSct_mem_no(Integer.parseInt(request.getParameter("sct_mem_no")));
		
		SctDao.sctDelete(sctCommand.getSct_no());
		
		SctDao.commit();
		
		return "ProController?dana=ajax_sct_list";
	}

}
