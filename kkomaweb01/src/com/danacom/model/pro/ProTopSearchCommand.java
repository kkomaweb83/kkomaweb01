package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;

public class ProTopSearchCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pro_pcl_no = request.getParameter("pro_pcl_no");
		
		String mainPclName = PclDao.getMainPclName(pro_pcl_no);
		
		List<MakerVo> mkrList = MkrDao.getMkrList(pro_pcl_no);
		
		ProClassVo pclVO = null;
		List<ProClassVo> tempList = null;
		List<ProClassVo> pclList = PclDao.getPclList(pro_pcl_no);
		if(pclList != null){
			for(int i=0; i < pclList.size(); i++){
				pclVO = pclList.get(i);
				pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
				tempList = pclVO.getPcl_list();
				if(tempList != null){
					for(int j=0; j < tempList.size(); j++){
						pclVO = tempList.get(j);
						pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
					}
				}
			}
		}
		request.setAttribute("pclList", pclList);
		request.setAttribute("mkrList", mkrList);
		request.setAttribute("mainPclName", mainPclName);
		
		return "pro/ajax_pro_main_topSearch.jsp";
	}

}
