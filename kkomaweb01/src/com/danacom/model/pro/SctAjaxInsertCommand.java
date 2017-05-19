package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.Shop_cart;

public class SctAjaxInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		Shop_cart sctCommand = new Shop_cart();
		sctCommand.setSct_count(1);
		sctCommand.setSct_pro_no(Integer.parseInt(request.getParameter("sct_pro_no")));
		sctCommand.setSct_mem_no(Integer.parseInt(request.getParameter("sct_mem_no")));
		sctCommand.setSct_pro_part(Integer.parseInt(request.getParameter("sct_pro_part")));
		
		int chk = SctDao.sctInsertChk(sctCommand);
		if(chk == 0) SctDao.sctInsert(sctCommand);
		else SctDao.sctCountUpdate(sctCommand);
		
		return "ProController?dana=sct_main_prelist";
	}

}
