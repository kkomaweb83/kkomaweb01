package com.danacom.model.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.pro.MemComVo;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProductVo;
import com.danacom.util.CommonUtilsController;

public class MemAdminListCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		int total_cnt = 0;
		Map<String, Object> requestMap = new HashMap<>();
		
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징1
		List<MemComVo> mem_list = ProDao.getMemAdminList(requestMap);
		
		if(mem_list != null && mem_list.size() > 0){
			total_cnt = ((MemComVo)mem_list.get(0)).getTot_cont();
			if(total_cnt == -999){
				total_cnt = BaseDao.get_found_rows();
			}
			requestMap.put("total_cnt", total_cnt);
		}
		CommonUtilsController.setPageSetting(requestMap, request); // 페이징2
		
		request.setAttribute("mem_list", mem_list);
		request.setAttribute("total_cnt", total_cnt);
		
		return "pro/mem_admin_list.jsp";
	}

}
