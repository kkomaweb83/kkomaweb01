package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.VbbVo;
import com.danacom.mybatis.vbl.VblDao;

public class VbbReplyUpdateCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VbbVo vbb_Command = new VbbVo();
		vbb_Command.setVbr_no(request.getParameter("vbr_no"));
		vbb_Command.setVbb_no(request.getParameter("vbb_no"));
		vbb_Command.setVbr_content(request.getParameter("vbr_content"));
		
		VblDao.replyUpdate(vbb_Command);
		
		return "VblController?dana=vbb_view";
	}

}
