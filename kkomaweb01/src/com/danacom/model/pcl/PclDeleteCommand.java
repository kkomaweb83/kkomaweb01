package com.danacom.model.pcl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;

public class PclDeleteCommand implements BaseCommand {

	/**
     * 관리자 상품분류 삭제
     * 
     * @author		유종훈
     * @date		2017. 05. 13
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		PclDao.pclDelete(request.getParameter("pcl_no"));

		String movUrl = "PclController?dana=ajax_pcl_list&pcl_upperno=" 
				+ request.getParameter("pcl_upperno")+"&insert=y&step="
				+ request.getParameter("pcl_step")+"&pcl_old_upperno="
				+ request.getParameter("pcl_upperno");
		
		return movUrl;
	}

}
