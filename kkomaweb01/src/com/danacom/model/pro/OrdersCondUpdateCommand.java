package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.OdrDocVo;
import com.danacom.mybatis.pro.SctDao;

public class OrdersCondUpdateCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		OdrDocVo doc = new OdrDocVo();
		doc.setOdr_no(request.getParameter("odr_no"));
		doc.setOdr_condition(Integer.parseInt(request.getParameter("odr_condition")));
		
		SctDao.conditionUpdate(doc);
		
		SctDao.commit();
		
		return "ProController?dana=orders_admin_det_list&reurl=admin&odr_no="+request.getParameter("odr_no");
	}

}
