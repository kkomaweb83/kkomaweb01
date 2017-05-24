package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class BtlDetListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setBtl_no(request.getParameter("btl_no"));
		
		BtlVo btl = VblDao.getBtlView(btl_Command);
		List<BtlVo> btlDetList = VblDao.getBtlDetList(btl_Command);
		
		request.setAttribute("btl", btl);
		request.setAttribute("btlDetList", btlDetList);
		
		return "vbl/btl_det_list.jsp";
	}

}
