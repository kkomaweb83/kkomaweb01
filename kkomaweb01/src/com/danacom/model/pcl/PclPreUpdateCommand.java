package com.danacom.model.pcl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;

public class PclPreUpdateCommand implements BaseCommand {

	/**
     * 관리자 상품분류 상세보기
     * 
     * @author		유종훈
     * @date		2017. 05. 13
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pcl_upperno = request.getParameter("pcl_upperno");
		String pcl_no = request.getParameter("pcl_no");
		String insert = request.getParameter("insert");
		
		ProClassVo pclVO = PclDao.getPclVO(pcl_no);
		List<ProClassVo> list = PclDao.getPclList(pcl_upperno);
		
		request.setAttribute("insert",insert);
		request.setAttribute("pclVO",pclVO);
		request.setAttribute("pcllist",list);
		
		return "pcl/ajax_pcl_list.jsp";
	}

}
