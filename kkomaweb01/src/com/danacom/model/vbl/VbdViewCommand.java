package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class VbdViewCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setVbj_no(request.getParameter("vbj_no"));
		
		BtlVo btlJoinContent = VblDao.getBtlJoinContent(btl_Command);
		List<BtlVo> btlJoinDetList = VblDao.getBtlJoinDetList(btl_Command);
		request.setAttribute("btlJoinContent", btlJoinContent);
		request.setAttribute("btlJoinDetList", btlJoinDetList);
		
		String returnUrl = "vbl/ajaxBtlJoinDetList.jsp";
		if(reurl != null && reurl.equals("main")) returnUrl = "vbl/ajaxBtlJoinDetList_main.jsp";
		
		return returnUrl;
	}

}
