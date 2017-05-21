package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.pro.ProductVo;

public class VblAjaxMkrPclCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String pcl_no = request.getParameter("pcl_no");
		ProductVo proCommand = new ProductVo();
		proCommand.setPro_pcl_no(pcl_no);
		
		String mainPclName = PclDao.getMainPclName(pcl_no);
		
		List<MakerVo> mkrList = MkrDao.getMkrList(pcl_no);
		
		ProClassVo pclVO = null;
		List<ProClassVo> tempList = null;
		List<ProClassVo> pclList = PclDao.getPclList(pcl_no);
		if(pclList != null){
			for(int i=0; i < pclList.size(); i++){
				pclVO = (ProClassVo)pclList.get(i);
				pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
				tempList = pclVO.getPcl_list();
				if(tempList != null){
					for(int j=0; j < tempList.size(); j++){
						pclVO = (ProClassVo)tempList.get(j);
						pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
					}
				}
			}
		}
		
		request.setAttribute("pclList", pclList);
		request.setAttribute("mkrList", mkrList);
		request.setAttribute("mainPclName", mainPclName);
		request.setAttribute("mainPclNo", pcl_no);
		
		return "vbl/ajax_vbl_inMkrPcl.jsp";
	}

}
