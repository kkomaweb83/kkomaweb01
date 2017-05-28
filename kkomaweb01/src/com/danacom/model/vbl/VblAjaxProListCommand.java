package com.danacom.model.vbl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProductVo;
import com.danacom.util.CommonUtilsController;

public class VblAjaxProListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pcl_no = request.getParameter("pcl_no");
		String maker = request.getParameter("maker");
		String searchValue = request.getParameter("searchValue");
		String[] mkr_no_sy = null;
		String[] pdt_step51_sy = null;
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("pro_pcl_no", request.getParameter("pcl_no"));
		requestMap.put("proOrderCode", request.getParameter("proOrderCode"));
		
		if(maker != null && !"0".equals(maker)){
			mkr_no_sy = new String[1];
			mkr_no_sy[0] = maker;
		}
		
		List<String> tempSetp = new ArrayList<>();
		String[] temp2 = request.getParameterValues("search_pcl_no");
		if(temp2 != null){
			for(int i=0; i<temp2.length; i++){
				if(!temp2[i].equals("0")) tempSetp.add(temp2[i]);
			}
			if(tempSetp.size() > 0){
				String[] temp3 = new String[tempSetp.size()]; 
				for(int j=0; j<tempSetp.size(); j++){
					temp3[j] = (String) tempSetp.get(j);
				}
				pdt_step51_sy = temp3;
			}
		}
		requestMap.put("mkr_no_sy", mkr_no_sy);
		requestMap.put("pdt_step51_sy", pdt_step51_sy);
		requestMap.put("searchValue", searchValue);
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<ProductVo> pro_list = ProDao.getProMainList(requestMap);
		
		if(pro_list != null && pro_list.size() > 0){
			total_cnt = ((ProductVo)pro_list.get(0)).getTot_cont();
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("proMainList", pro_list);
		request.setAttribute("mainPclNo", pcl_no);
		request.setAttribute("total_cnt", total_cnt);
		request.setAttribute("orderCode", request.getParameter("proOrderCode"));
		
		return "vbl/ajax_vbl_inProList.jsp";
	}

}
