package com.danacom.model.vbl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VblDetVo;
import com.danacom.mybatis.vbl.VirBillVo;

public class VbbInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VirBillVo vblCommand = new VirBillVo();
		vblCommand.setVbl_no(Integer.parseInt(request.getParameter("vbl_no")));
		vblCommand.setPst_pro_no(request.getParameterValues("pst_pro_no"));
		vblCommand.setVbl_mem_no(Integer.parseInt(request.getParameter("vbl_mem_no")));
		vblCommand.setVbl_bor_answer(request.getParameter("vbl_bor_answer"));
		vblCommand.setVbl_title(request.getParameter("vbl_title"));
		
		int vblMaxNo= vblCommand.getVbl_no();
		int vbbMaxNo = VblDao.getVbbMaxNo();
		vblCommand.setVbb_no(vbbMaxNo);
		
		vblCommand.setVbl_bor_answer("Y");
		
		VblDao.vblUpdate(vblCommand);
		VblDao.vbbInsert(vblCommand);
		
		VblDao.vdtDelete(vblMaxNo);
		
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
			vdtCommand.setVds_vbb_no(vbbMaxNo);
			int res = VblDao.vdtInsert(vdtCommand);
			int res2 =VblDao.vdsInsert(vdtCommand);
			System.out.println(">>>>>>>>>>>>> res : " + res);
			System.out.println(">>>>>>>>>>>>> res2 : " + res2);
		} 
		
		VblDao.commit();
		
		return "VblController?dana=vbb_prelist";
	}

}
