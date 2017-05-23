package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MemComVo;
import com.danacom.mybatis.vbl.VbbVo;
import com.danacom.mybatis.vbl.VblDao;

public class VbbReplyInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VbbVo vbb_Command = new VbbVo();
		vbb_Command.setVbb_no(request.getParameter("vbb_no"));
		vbb_Command.setVbr_content(request.getParameter("vbr_content"));
		MemComVo loginCommand= (MemComVo)request.getSession().getAttribute("login");
		vbb_Command.setMem_no(loginCommand.getMem_no()+"");
		
		VblDao.replyInsert(vbb_Command);
		
		return "VblController?dana=vbb_view";
	}

}
