package com.danacom.model.pro;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MemComVo;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.mybatis.pro.SctTotPriceVO;
import com.danacom.mybatis.pro.Shop_cart;

public class SctOdrDocCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		Shop_cart sctCommand = new Shop_cart();
		sctCommand.setPst_pro_no(request.getParameterValues("pst_pro_no"));
		
		sctCommand.setSct_pro_no(Integer.parseInt((request.getParameter("sct_pro_no") != null && !"".equals(request.getParameter("sct_pro_no")))?request.getParameter("sct_pro_no"):"0"));
		sctCommand.setSct_pro_part(Integer.parseInt((request.getParameter("sct_pro_part") != null && !"".equals(request.getParameter("sct_pro_part")))?request.getParameter("sct_pro_part"):"0"));
		sctCommand.setSct_pro_muti(Integer.parseInt(request.getParameter("sct_pro_muti")));
		sctCommand.setSct_mem_no(Integer.parseInt((request.getParameter("sct_mem_no") != null && !"".equals(request.getParameter("sct_mem_no")))?request.getParameter("sct_mem_no"):"0"));
		
		int sctProMuti = sctCommand.getSct_pro_muti();
		List<Shop_cart> sctList = null;
		
		if(sctProMuti == 1){
			sctList = SctDao.getSctList(sctCommand.getSct_mem_no());
		}else if(sctProMuti == 2){
			sctList = new ArrayList<>();
			Shop_cart temp2 = new Shop_cart();
			temp2.setSct_pro_no(sctCommand.getSct_pro_no());
			temp2.setSct_count(1);
			temp2.setSct_pro_part(sctCommand.getSct_pro_part());
			temp2.setSct_pro_muti(sctProMuti);
			temp2.setSct_mem_no(sctCommand.getSct_mem_no());
			sctList.add(temp2);
		}else if(sctProMuti == 3){
			sctList = new ArrayList<>();
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
				temp3.setSct_pro_muti(sctProMuti);
				temp3.setSct_mem_no(sctCommand.getSct_mem_no());
				sctList.add(temp3);
			}
		}
		
		SctTotPriceVO sctTotPrivceVo = new SctTotPriceVO();
		int tempPrice = 0;
		for(int i = 0; i<sctList.size(); i++){
			Shop_cart temp = (Shop_cart) sctList.get(i);
			
			temp.setSct_proVO(SctDao.getSctProVo(temp));
			tempPrice = sctTotPrivceVo.getSct_tot_milege() +  temp.getSct_proVO().getPro_tot_milege();
			sctTotPrivceVo.setSct_tot_milege(tempPrice);
			tempPrice = 0;
			tempPrice = sctTotPrivceVo.getSct_tot_disprice() + temp.getSct_proVO().getPro_tot_price();
			sctTotPrivceVo.setSct_tot_disprice(tempPrice);
			tempPrice = 0;
		}
		sctTotPrivceVo = SctDao.getSctTotPrice(sctTotPrivceVo);
		
		MemComVo loginCommand = (MemComVo) request.getSession().getAttribute("login");
		String mem_no = loginCommand.getMem_no()+"";
		//List list2 = ProDao.getCpIssue(mem_no);
		
		SctTotPriceVO userMil = SctDao.getMemMilege(mem_no);
		
		String returnUrl = "sct/odr_doc.jsp";
		
		request.setAttribute("sctList", sctList);
		request.setAttribute("sctTotPrivceVo", sctTotPrivceVo);
		request.setAttribute("myCoupon", null);		
		request.setAttribute("userMil", userMil);		
		
		return returnUrl;
	}

}
