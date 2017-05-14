package com.danacom.model.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProductVo;

public class ProAdminListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		int totSize = 0;
		Map<String, String> proMap = new HashMap<>();
		proMap.put("pro_pcl_no", request.getParameter("pro_pcl_no"));
		List<ProductVo> pro_list = ProDao.getProAdminList(proMap);
		
		if(pro_list != null && pro_list.size() > 0){
			totSize = ((ProductVo)pro_list.get(0)).getTot_cont();
		}
		
		request.setAttribute("pro_list", pro_list);
		request.setAttribute("listTotCount", totSize);
		
		return "pro/pro_admin_list.jsp";
	}

}
