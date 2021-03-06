package com.danacom.model.mkr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;

public class MkrAdminListCommand implements BaseCommand {

	/**
     * 관리자 제조사 리스트 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String mkr_insert = request.getParameter("mkr_insert");
		String mkr_pcl_no = request.getParameter("mkr_pcl_no");
		
		List<MakerVo> list = MkrDao.getMkrList(mkr_pcl_no);
		MakerVo mkrCom = new MakerVo();
		mkrCom.setList(list);
		mkrCom.setMkr_insert(mkr_insert);
		
		request.setAttribute("mkr_pcl_no", mkr_pcl_no);
		request.setAttribute("mkrCom", mkrCom);
		
		return "mkr/mkr_list.jsp";
	}

}
