package com.danacom.model.pcl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;

public class PclAjaxAdminListCommand implements BaseCommand {

	/**
     * 관리자 상품분류 ajax 리스트 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 12
     */
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pcl_upperno = request.getParameter("pcl_upperno");
		String pcl_old_upperno = request.getParameter("pcl_old_upperno");
		String insert = request.getParameter("insert");
		int step = Integer.parseInt(request.getParameter("step"));
		String objsetp = request.getParameter("objsetp");
		
		String pcl_session = request.getParameter("pcl_session");
		
		List<ProClassVo> list = PclDao.getPclList(pcl_upperno);
		
		HttpSession session = request.getSession();
		List<ProClassVo> old_list = new ArrayList<>();
		if(session.getAttribute("old_list") != null){
			old_list = (List<ProClassVo>)session.getAttribute("old_list");
			if(objsetp != null){
				for(int i = old_list.size(); i> (step-2); i--){
					old_list.remove(i-1);
				}
			}
		}
		
		ProClassVo oldPclVO = new ProClassVo();
		oldPclVO.setPcl_no(pcl_upperno);
		oldPclVO.setPcl_upperno(pcl_old_upperno);
		oldPclVO.setPcl_step(step);
		if(pcl_old_upperno != null && !pcl_old_upperno.equals("NO")){
			oldPclVO.setPcl_list(PclDao.getPclList(pcl_old_upperno));
			if(pcl_session != null && pcl_session.equals("y")){ 
				old_list.add(oldPclVO);
			}
		}
		session.setAttribute("old_list", old_list);
		
				
		ProClassVo pclVO = new ProClassVo();
		if(pcl_upperno.equalsIgnoreCase("null") || pcl_upperno == null){
			pclVO.setPcl_upperno(pcl_upperno);			
			pclVO.setPa_pcl_name(pcl_upperno);			
			pclVO.setPcl_step(step);
		}else{
			pclVO = PclDao.getPclVO(pcl_upperno);
			pclVO.setPcl_upperno(pclVO.getPcl_no());
			pclVO.setPa_pcl_name(pclVO.getPcl_name());
			pclVO.setPcl_name("");
			pclVO.setPcl_step(step);
		}
		
		request.setAttribute("pcllist",list);
		request.setAttribute("insert", insert);
		request.setAttribute("pclVO", pclVO);
		request.setAttribute("oldstep", step);
		request.setAttribute("pcl_session", "n");
		
		return "pcl/ajax_pcl_list.jsp";
	}

}
