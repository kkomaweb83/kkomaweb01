package com.danacom.model.vbl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VirBillVo;
import com.danacom.util.CommonUtilsController;

public class VblListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("vbl_mem_no", request.getParameter("vbl_mem_no"));
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<VirBillVo> vbl_list = VblDao.getVblList(requestMap);
		
		if(vbl_list != null && vbl_list.size() > 0){
			total_cnt = ((VirBillVo)vbl_list.get(0)).getTot_cont();
			if(total_cnt == -999){
				total_cnt = BaseDao.get_found_rows();
			}
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("pro_list", vbl_list);
		request.setAttribute("total_cnt", total_cnt);
		
		return "vbl/ajax_vbl_list.jsp";
	}

}
