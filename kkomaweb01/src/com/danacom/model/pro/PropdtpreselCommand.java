package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.pro.ProductVo;

public class PropdtpreselCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String mkr_pcl_no2 = request.getParameter("pcl_no");
		
		List<MakerVo> mkrList = MkrDao.getMkrList(mkr_pcl_no2);
		
		ProClassVo pclVO = null;
		List<ProClassVo> tempList = null;
		List<ProClassVo> pclList = PclDao.getPclList(mkr_pcl_no2);
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
		
		ProductVo proCom = new ProductVo(); 
		proCom.setPro_pcl_no(mkr_pcl_no2);
		
		request.setAttribute("mkrList", mkrList);
		request.setAttribute("pclList", pclList);
		request.setAttribute("proCom", proCom);
		
		return "pro/pro_preInsert.jsp";
	}

}
