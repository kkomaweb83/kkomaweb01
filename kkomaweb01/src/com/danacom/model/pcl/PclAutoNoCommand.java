package com.danacom.model.pcl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;

public class PclAutoNoCommand implements BaseCommand {

	/**
     * 관리자 상품분류 코드생성
     * 
     * @author		유종훈
     * @date		2017. 05. 13
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pcl_uppercode = request.getParameter("pcl_upperno");
		String pcl_ord_no = "";
		String new_pcl_no = "";
		
		if(pcl_uppercode.equalsIgnoreCase("null") || pcl_uppercode == null) pcl_ord_no = "";
		else pcl_ord_no = pcl_uppercode;
		
		String maxNo = PclDao.getMaxPclNo(pcl_uppercode);
		
		if(maxNo != null){
			if(maxNo.length()%2 != 0) maxNo = "0" + maxNo;
			maxNo = maxNo.replace(pcl_ord_no, "");
			new_pcl_no = pcl_ord_no + maxNo;
		}else new_pcl_no = pcl_ord_no + "01";
		
		if(pcl_ord_no.length() >= new_pcl_no.length()) new_pcl_no = pcl_ord_no + new_pcl_no; 
		
		request.setAttribute("pcl_atuo_no", new_pcl_no);
		
		return "PclController?dana=ajax_pcl_list";
	}

}
