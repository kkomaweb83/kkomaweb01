package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class BtlDetPreJoinCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setBtl_no(request.getParameter("btl_no"));
		
		BtlVo btl = VblDao.getBtlView(btl_Command);
		
		request.setAttribute("btl", btl);
		
		String returnUrl = "vbl/btlDetPrejoin.jsp";
		if(reurl != null && reurl.equals("main")) returnUrl = "vbl/btlDetPrejoin_main.jsp";
		
		return returnUrl;
	}

}
