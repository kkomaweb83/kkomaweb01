package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;

public class VbjInsertCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		BtlVo btl_Command = new BtlVo();
		btl_Command.setVbb_no(request.getParameter("vbb_no"));
		btl_Command.setBtl_no(request.getParameter("btl_no"));
		
		int vbjMaxNo = VblDao.getVbjMaxNo();
		btl_Command.setVbj_no(vbjMaxNo+"");
		
		VblDao.answerVbbUpdate(btl_Command);
		VblDao.vbjInsert(btl_Command);

		List<BtlVo> vds_no_list = VblDao.getVdsNoList(btl_Command);
		for (BtlVo vo : vds_no_list) {
			btl_Command.setVbd_no(vo.getVds_no());
			btl_Command.setVbd_quantity(vo.getVds_quantity());
			btl_Command.setVbd_pro_no(vo.getVbd_pro_no());
			VblDao.vbdInsert(btl_Command);
		}
		
		VblDao.commit();
		
		String returnUrl = "VblController?dana=ajaxBtlDetList&reurl=main&btl_no="+request.getParameter("btl_no");
		if(reurl != null && reurl.equals("admin")) returnUrl = "VblController?dana=ajaxBtlDetList&reurl=admin&btl_no="+request.getParameter("btl_no");
		
		return returnUrl;
	}

}
