package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProTempVo;
import com.danacom.mybatis.pro.ProductVo;

public class ProAjaxViewCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		ProductVo proCom = new ProductVo();
		proCom.setPro_no(Integer.parseInt(request.getParameter("pro_no")));
		proCom.setPro_pcl_no(request.getParameter("pro_pcl_no"));
		
		ProductVo proVo = ProDao.getProVo(proCom.getPro_no());
		
		ProClassVo pclVO = null;
		List<ProClassVo> tempList = null;
		List<ProClassVo> pclList = PclDao.getPclList(proCom.getPro_pcl_no());
		if(pclList != null){
			for(int i=0; i < pclList.size(); i++){
				pclVO = (ProClassVo)pclList.get(i);
				pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
				tempList = pclVO.getPcl_list();
				if(tempList != null){
					for(int j=0; j < tempList.size(); j++){
						ProTempVo proTempVO = new ProTempVo();
						pclVO = (ProClassVo)tempList.get(j);
						pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
						proTempVO.setPdt_name(pclVO.getPcl_no());
						
						proTempVO.setPdt_pro_no(proCom.getPro_no());
						proTempVO = PclDao.getNextPclVo(proTempVO);
						if(proTempVO != null){
							pclVO.setPcl_next_no(proTempVO.getPcl_next_no());
							pclVO.setPcl_next_name(proTempVO.getPcl_next_name());
						}
					}
				}
			}
		}
		
		String returnUrl = "pro/ajax_pro_main_view.jsp";
		String view_area = request.getParameter("view_area");
		if(view_area != null && view_area.equals("2")){
			returnUrl = "sct/ajax_pro_dlg_view.jsp";
		}
		
		request.setAttribute("proVo", proVo);
		request.setAttribute("pclList", pclList);
		
		return returnUrl;
	}

}
