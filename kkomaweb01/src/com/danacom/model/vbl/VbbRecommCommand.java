package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MemComVo;
import com.danacom.mybatis.vbl.VbbVo;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VbsVo;

public class VbbRecommCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VbbVo vbb_Command = new VbbVo();
		vbb_Command.setVbb_no(request.getParameter("vbb_no"));
		
		VblDao.recommVbbContent(vbb_Command);
		VbbVo vbbContent = VblDao.getVbbContent(vbb_Command);
		List<VbsVo> vbbProList = VblDao.getVbbContentPro(vbb_Command);
		List<VbbVo> vbrList = VblDao.getVbrList(vbb_Command);
		request.setAttribute("vbbContent", vbbContent);
		request.setAttribute("vbbProList", vbbProList);
		for (VbbVo vbr_command : vbrList) {
			MemComVo loginCommand= (MemComVo)request.getSession().getAttribute("login");
			if(vbr_command.getVbr_content() != null){
				if(loginCommand == null || !loginCommand.getMem_id().equals(vbr_command.getMem_id())){
					vbr_command.setVbr_content(vbr_command.getVbr_content().replace("\r\n", "<br />"));
				}
			}
		}
		request.setAttribute("vbrList", vbrList);
		
		return "vbl/vbb_view.jsp";
	}

}
