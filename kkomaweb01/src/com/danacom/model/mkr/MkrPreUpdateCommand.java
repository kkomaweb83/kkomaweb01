package com.danacom.model.mkr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;

public class MkrPreUpdateCommand implements BaseCommand {

	/**
     * 관리자 상품분류 상세보기
     * 
     * @author		유종훈
     * @date		2017. 05. 13
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String mkr_no = request.getParameter("mkr_no");
		String mkr_pcl_no = request.getParameter("mkr_pcl_no");
		
		MakerVo mkrVO = MkrDao.getMkrVO(mkr_no);
		
		request.setAttribute("mkrVO", mkrVO);
		request.setAttribute("mkr_insert", "y");
		request.setAttribute("mkr_pcl_no", mkr_pcl_no);
		
		return "MkrController?dana=mkr_list";
	}

}
