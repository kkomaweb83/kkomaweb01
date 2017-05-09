package com.danacom.model.pcl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;

public class PclAdminListCommand implements BaseCommand {

	/**
     * 관리자 상품분류 리스트 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 09
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
			
		
		return "pcl/pcl_list.jsp";
	}

}
