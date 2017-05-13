package com.danacom.model.pcl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;

public class PclUpdateCommand implements BaseCommand {

	/**
     * 관리자 상품분류 수정
     * 
     * @author		유종훈
     * @date		2017. 05. 13
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		ProClassVo pclVO = new ProClassVo();
		pclVO.setPcl_no(request.getParameter("pcl_no"));
		pclVO.setPcl_name(request.getParameter("pcl_name"));
		pclVO.setPcl_basis(request.getParameter("pcl_basis"));
		
		PclDao.pclUpdate(pclVO);

		String movUrl = "PclController?dana=ajax_pcl_list&pcl_upperno=" 
				+ request.getParameter("pcl_upperno")+"&insert=y&step="
				+ request.getParameter("pcl_step")+"&pcl_old_upperno="
				+ request.getParameter("pcl_upperno");
		
		return movUrl;
	}

}
