package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class VbjGradeUpdateCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setVbj_no(request.getParameter("vbj_no"));
		btl_Command.setBtl_no(request.getParameter("btl_no"));
		btl_Command.setVbj_title(request.getParameter("vbj_title"));
		
		VblDao.gradeVbjUpdate(btl_Command);
		
		VblDao.commit();
		
		String returnUrl = "VblController?dana=ajaxBtlDetList&reurl=main&btl_no="+request.getParameter("btl_no");
		if(reurl != null && reurl.equals("admin")) returnUrl = "VblController?dana=ajaxBtlDetList&reurl=admin&btl_no="+request.getParameter("btl_no");
		
		return returnUrl;
	}

}
