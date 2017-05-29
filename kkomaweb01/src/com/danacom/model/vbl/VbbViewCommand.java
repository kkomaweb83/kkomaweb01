package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MemComVo;
import com.danacom.mybatis.vbl.VbbVo;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VbsVo;

public class VbbViewCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		VbbVo vbb_Command = new VbbVo();
		vbb_Command.setVbb_no(request.getParameter("vbb_no"));
		
		if(reurl == null || "".equals(reurl)){
			VblDao.countUpVbbContent(vbb_Command);
		}
		VbbVo vbbContent = VblDao.getVbbContent(vbb_Command);
		List<VbsVo> vbbProList = VblDao.getVbbContentPro(vbb_Command);
		request.setAttribute("vbbContent", vbbContent);
		request.setAttribute("vbbProList", vbbProList);
		
		if("".equals(reurl)){
			List<VbbVo> vbrList = VblDao.getVbrList(vbb_Command);
			for (VbbVo vbr_command : vbrList) {
				MemComVo loginCommand= (MemComVo)request.getSession().getAttribute("login");
				if(vbr_command.getVbr_content() != null){
					if(loginCommand == null || !loginCommand.getMem_id().equals(vbr_command.getMem_id())){
						vbr_command.setVbr_content(vbr_command.getVbr_content().replace("\r\n", "<br />"));
					}
				}
			}
			request.setAttribute("vbrList", vbrList);
		}
		
		String returnUrl = "vbl/vbb_view.jsp";
		if(reurl != null && reurl.equals("btl")) returnUrl = "vbl/ajaxVbbRead.jsp";
		
		return returnUrl;
	}

}
