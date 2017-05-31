package com.danacom.model.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProductVo;
import com.danacom.util.CommonUtilsController;

public class ProAjaxListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("pro_pcl_no", request.getParameter("pro_pcl_no"));
		requestMap.put("proOrderCode", request.getParameter("proOrderCode"));
		requestMap.put("mkr_no_sy", request.getParameterValues("mkr_no_sy"));
		requestMap.put("pdt_step51_sy", request.getParameterValues("pdt_step51_sy"));
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<ProductVo> pro_list = ProDao.getProMainList(requestMap);
		
		if(pro_list != null && pro_list.size() > 0){
			total_cnt = ((ProductVo)pro_list.get(0)).getTot_cont();
			if(total_cnt == -999){
				total_cnt = BaseDao.get_found_rows();
				BaseDao.commit();
			}
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("proMainList", pro_list);
		request.setAttribute("total_cnt", total_cnt);
		request.setAttribute("orderCode", request.getParameter("proOrderCode"));
		
		return "pro/ajax_pro_main_list.jsp";
	}

}
