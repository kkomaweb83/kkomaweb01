package com.danacom.model.pcl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;

public class PclTopListCommand implements BaseCommand {

	/**
     * 메인 상단 상품분류 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 08
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		List<ProClassVo> class_list = PclDao.getPclList("NULL");
		for(int i=0; i < class_list.size(); i++){
			if(i > 1) break;
			ProClassVo pclVO = class_list.get(i);
			pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
		}
		HttpSession session = request.getSession();
		session.setAttribute("class_list", class_list);
		
		return "pro/pro_main_list.jsp";
	}

}
