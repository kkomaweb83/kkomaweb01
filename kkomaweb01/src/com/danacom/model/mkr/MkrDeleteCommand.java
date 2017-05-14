package com.danacom.model.mkr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MkrDao;

public class MkrDeleteCommand implements BaseCommand {

	/**
     * 관리자 제조사 삭제
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		MkrDao.mkrDelete(request.getParameter("mkr_no"));
		
		String movUrl = "MkrController?dana=mkr_list&mkr_insert=y&mkr_pcl_no=" 
				+ request.getParameter("mkr_pcl_no");
		
		return movUrl;
	}

}
