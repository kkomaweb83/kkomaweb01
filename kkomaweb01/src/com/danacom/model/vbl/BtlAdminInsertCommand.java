package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class BtlAdminInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setBtl_title(request.getParameter("btl_title"));
		btl_Command.setBtl_sdate(request.getParameter("btl_sdate"));
		btl_Command.setBtl_cdate(request.getParameter("btl_cdate"));
		btl_Command.setBtl_content(request.getParameter("btl_content"));
		
		VblDao.btlInsert(btl_Command);
		VblDao.commit();
		
		return "VblController?dana=btl_admin_list";
	}

}
