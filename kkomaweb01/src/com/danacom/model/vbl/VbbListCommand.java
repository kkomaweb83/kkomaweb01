package com.danacom.model.vbl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.vbl.VbbVo;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.util.CommonUtilsController;

public class VbbListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reurl = request.getParameter("reurl");
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("vbb_mem_no", request.getParameter("vbb_mem_no"));
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<VbbVo> vbb_list = VblDao.getVbbList(requestMap);
		
		if(vbb_list != null && vbb_list.size() > 0){
			total_cnt = ((VbbVo)vbb_list.get(0)).getTot_cont();
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("pro_list", vbb_list);
		request.setAttribute("total_cnt", total_cnt);
		
		String returnUrl = "vbl/ajax_vbb_list.jsp";
		if(reurl != null && reurl.equals("admin")) returnUrl = "vbl/ajaxVbbList.jsp";
		
		return returnUrl;
	}

}
