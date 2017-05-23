package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.Shop_cart;

public class SctAjaxMutiInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		Shop_cart sctCommand = new Shop_cart();
		sctCommand.setPst_pro_no(request.getParameterValues("pst_pro_no"));
		
		sctCommand.setVbl_mem_no(Integer.parseInt(request.getParameter("vbl_mem_no")));
		sctCommand.setSct_pro_part(Integer.parseInt(request.getParameter("sct_pro_part")));
		sctCommand.setSct_pro_muti(Integer.parseInt(request.getParameter("sct_pro_muti")));
		
		String[] temp = sctCommand.getPst_pro_no();
		String pst_pro_no = "";
		String pst_quantity = "";
		for(int i=0; i<temp.length ; i++){
			Shop_cart temp3 = new Shop_cart();
			pst_pro_no = temp[i];
			pst_quantity = request.getParameter("cnt_" + pst_pro_no);
			temp3.setSct_pro_no(Integer.parseInt(pst_pro_no));
			temp3.setSct_count(Integer.parseInt(pst_quantity));
			temp3.setSct_pro_part(sctCommand.getSct_pro_part());
			temp3.setSct_pro_muti(sctCommand.getSct_pro_muti());
			temp3.setSct_mem_no(sctCommand.getVbl_mem_no());
			
			int chk = SctDao.sctInsertChk(temp3);
			if(chk == 0) SctDao.sctInsert(temp3);
			else SctDao.sctCountUpdate(temp3);
		}
		
		SctDao.commit();
		
		String returnUrl = "ProController?dana=sct_main_prelist";
		
		return returnUrl;
	}

}
