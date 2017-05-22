package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VblDetVo;
import com.danacom.mybatis.vbl.VirBillVo;

public class VblInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VirBillVo vblCommand = new VirBillVo();
		vblCommand.setPst_pro_no(request.getParameterValues("pst_pro_no"));
		vblCommand.setVbl_mem_no(Integer.parseInt(request.getParameter("vbl_mem_no")));
		vblCommand.setVbl_bor_answer(request.getParameter("vbl_bor_answer"));
		vblCommand.setVbl_title(request.getParameter("vbl_title"));
		
		int vblMaxNo= VblDao.getVblMaxNo();
		vblCommand.setVbl_no(vblMaxNo);
		
		VblDao.vblInsert(vblCommand);
		
		VblDetVo vdtCommand = new VblDetVo();
		String[] temp = vblCommand.getPst_pro_no();
		String pst_pro_no = "";
		String pst_quantity = "";
		for(int i=0; i<temp.length ; i++){
			pst_pro_no = temp[i];
			pst_quantity = request.getParameter("cnt_" + pst_pro_no);
			vdtCommand.setVdt_pro_no(Integer.parseInt(pst_pro_no));
			vdtCommand.setVdt_quantity(Integer.parseInt(pst_quantity));
			vdtCommand.setVdt_vbl_no(vblMaxNo);
			VblDao.vdtInsert(vdtCommand);
		}
		
		VblDao.commit();
		
		return "VblController?dana=vbl_main_prelist";
	}

}
