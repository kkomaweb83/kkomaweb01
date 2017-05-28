package com.danacom.model.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.MpVo;
import com.danacom.mybatis.pro.SctDao;
import com.danacom.util.CommonUtilsController;

public class OrdersAjaxListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		if(reurl == null || !reurl.equals("admin")){
			requestMap.put("ord_mem_no", request.getParameter("ord_mem_no"));
		}
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<MpVo> orders_list = SctDao.getOrdersList(requestMap);
		
		if(orders_list != null && orders_list.size() > 0){
			total_cnt = ((MpVo)orders_list.get(0)).getTot_cont();
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("orders_list", orders_list);
		request.setAttribute("total_cnt", total_cnt);
		
		String returnUrl = "sct/ajax_orders_list.jsp";
		if(reurl != null && reurl.equals("admin")) returnUrl = "sct/ajax_orders_admin_list.jsp";
		
		return returnUrl;
	}

}
