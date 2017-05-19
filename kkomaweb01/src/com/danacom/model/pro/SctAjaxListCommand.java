package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.SctTotPriceVO;
import com.danacom.mybatis.pro.Shop_cart;

public class SctAjaxListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		Shop_cart sctCommand = new Shop_cart();
		sctCommand.setSct_mem_no(Integer.parseInt(request.getParameter("sct_mem_no")));
		
		String sct_part = request.getParameter("sct_part");
		List<Shop_cart> sctList = SctDao.getSctList(sctCommand.getSct_mem_no());
		
		SctTotPriceVO sctTotPrivceVo = new SctTotPriceVO();
		int tempPrice = 0;
		for(int i = 0; i<sctList.size(); i++){
			Shop_cart temp = (Shop_cart) sctList.get(i);
			if(temp.getSct_pro_part() == 1){
				temp.setSct_proVO(SctDao.getSctProVo(temp));
				tempPrice = sctTotPrivceVo.getSct_tot_milege() +  temp.getSct_proVO().getPro_tot_milege();
				sctTotPrivceVo.setSct_tot_milege(tempPrice);
				tempPrice = 0;
				tempPrice = sctTotPrivceVo.getSct_tot_disprice() + temp.getSct_proVO().getPro_tot_price();
				sctTotPrivceVo.setSct_tot_disprice(tempPrice);
				tempPrice = 0;
			}
			else if(temp.getSct_pro_part() == 2){
				temp.setSct_proVO(SctDao.getSctPptVo(temp));
				tempPrice = sctTotPrivceVo.getSct_tot_milege() +  temp.getSct_proVO().getPro_tot_milege();
				sctTotPrivceVo.setSct_tot_milege(tempPrice);
				tempPrice = 0;
				tempPrice = sctTotPrivceVo.getSct_tot_disprice() + temp.getSct_proVO().getPro_tot_price();
				sctTotPrivceVo.setSct_tot_disprice(tempPrice);
				tempPrice = 0;
			}
		}
		sctTotPrivceVo = SctDao.getSctTotPrice(sctTotPrivceVo);
		
		String returnUrl = "sct/sct_main_list.jsp";
		if(sct_part != null && sct_part.equals("1")) returnUrl = "sct/mini_sct_list.jsp";
		
		return returnUrl;
	}

}
