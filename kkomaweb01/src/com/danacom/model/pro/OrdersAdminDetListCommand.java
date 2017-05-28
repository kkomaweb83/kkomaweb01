package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MpVo;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.SctTotPriceVO;
import com.danacom.mybatis.pro.Shop_cart;

public class OrdersAdminDetListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String odr_no = request.getParameter("odr_no");
		MpVo mpCommand = SctDao.getOrdersDetList(odr_no);
		
		List<Shop_cart> odtList = SctDao.getOdcOdtList(odr_no);
		
		SctTotPriceVO sctTotPrivceVo = new SctTotPriceVO();
		int tempPrice = 0;
		for(int i = 0; i<odtList.size(); i++){
			Shop_cart temp = (Shop_cart) odtList.get(i);
			
			temp.setSct_proVO(SctDao.getSctProVo(temp));
			tempPrice = sctTotPrivceVo.getSct_tot_milege() +  temp.getSct_proVO().getPro_tot_milege();
			sctTotPrivceVo.setSct_tot_milege(tempPrice);
			tempPrice = 0;
			tempPrice = sctTotPrivceVo.getSct_tot_disprice() + temp.getSct_proVO().getPro_tot_price();
			sctTotPrivceVo.setSct_tot_disprice(tempPrice);
			tempPrice = 0;
		}
		sctTotPrivceVo = SctDao.getSctTotPrice(sctTotPrivceVo);
		
		String returnUrl = "sct/orders_admin_det_list.jsp";
		
		request.setAttribute("odtList", odtList);
		request.setAttribute("sctTotPrivceVo", sctTotPrivceVo);
		request.setAttribute("mpCommand", mpCommand);
		
		return returnUrl;
	}

}
