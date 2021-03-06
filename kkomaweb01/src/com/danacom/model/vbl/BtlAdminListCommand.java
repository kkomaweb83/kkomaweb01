package com.danacom.model.vbl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.vbl.BtlVo;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.util.CommonUtilsController;

public class BtlAdminListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<BtlVo> btlList = VblDao.getBtlList(requestMap);
		
		if(btlList != null && btlList.size() > 0){
			total_cnt = ((BtlVo)btlList.get(0)).getTot_cont();
			if(total_cnt == -999){
				total_cnt = BaseDao.get_found_rows();
			}
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("btlList", btlList);
		request.setAttribute("total_cnt", total_cnt);
		
		String returnUrl = "vbl/btl_admin_list.jsp";
		if(reurl != null && reurl.equals("main")) returnUrl = "vbl/btl_main_list.jsp";
		
		return returnUrl;
	}

}
