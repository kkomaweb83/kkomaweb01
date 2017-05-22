package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VblDetVo;
import com.danacom.mybatis.vbl.VirBillVo;

public class VblDeleteCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VirBillVo vblCommand = new VirBillVo();
		vblCommand.setVbl_no(Integer.parseInt(request.getParameter("vbl_no")));
		
		int vblMaxNo= vblCommand.getVbl_no();
			
		VblDao.vdtDelete(vblMaxNo);
		
		VblDao.vblDelete(vblMaxNo);
		
		VblDao.commit();
		
		return "VblController?dana=vbl_main_prelist";
	}

}
