package com.danacom.model.mkr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;

public class MkrInsertCommand implements BaseCommand {

	/**
     * 관리자 제조사 등록
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		MakerVo mkrCom = new MakerVo();
		mkrCom.setMkr_name(request.getParameter("mkr_name"));
		mkrCom.setMkr_pcl_no(request.getParameter("mkr_pcl_no"));
		
		MkrDao.mkrInsert(mkrCom);
		
		String movUrl = "MkrController?dana=mkr_list&mkr_insert=y&mkr_pcl_no=" 
				+ mkrCom.getMkr_pcl_no();
		
		return movUrl;
	}

}
