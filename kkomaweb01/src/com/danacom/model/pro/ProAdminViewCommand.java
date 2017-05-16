package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.mkr.MakerVo;
import com.danacom.mybatis.mkr.MkrDao;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProTempVo;
import com.danacom.mybatis.pro.ProductVo;

public class ProAdminViewCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		ProductVo proCom = new ProductVo();
		proCom.setPro_no(Integer.parseInt(request.getParameter("pro_no")));
		proCom.setPro_pcl_no(request.getParameter("pro_pcl_no"));
		
		ProductVo proVo = ProDao.getProVo(proCom.getPro_no());
		MakerVo mkrVo = new MakerVo();
		mkrVo.setList(MkrDao.getMkrList(proCom.getPro_pcl_no()));
		mkrVo.setMkr_no(proVo.getPro_mkr_no());
		 
		String pmg_file_s = ProDao.getPmgFile(proCom.getPro_no(), 1);
		String pmg_file_b = ProDao.getPmgFile(proCom.getPro_no(), 2);
		
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
						}else{
							pclVO.setPcl_next_no("NULL");
						}
					}
				}
			}
		}
		
		request.setAttribute("proVo", proVo);
		request.setAttribute("pclList", pclList);
		request.setAttribute("mkrVo", mkrVo);
		request.setAttribute("pmg_file_s", pmg_file_s);
		request.setAttribute("pmg_file_b", pmg_file_b);
		
		return "pro/pro_admin_view.jsp";
	}

}
