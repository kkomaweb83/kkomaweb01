package com.danacom.model.vbl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pcl.PclDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.vbl.VblDao;
import com.danacom.mybatis.vbl.VirBillVo;

public class VblViewCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VirBillVo vblCommand = new VirBillVo();
		vblCommand.setVbl_no(Integer.parseInt(request.getParameter("vbl_no")));
		
		VirBillVo vblVo = VblDao.getVblVo(vblCommand.getVbl_no());
		int totPrice = 0;
		 
		List<ProClassVo> pptPclList = PclDao.getPclList("NULL");
		for(int i=0; i < pptPclList.size(); i++){
			if(i > 1) break;
			ProClassVo pclVO = (ProClassVo)pptPclList.get(i);
			pclVO.setPcl_list(PclDao.getPclList(pclVO.getPcl_no()));
			for(int j=0; j<pclVO.getPcl_list().size(); j++){
				ProClassVo pclVO2 = (ProClassVo)pclVO.getPcl_list().get(j);
				pclVO2.setPpt_no(vblCommand.getVbl_no());
				pclVO2.setProVO(VblDao.getvVblProVo(pclVO2));
				if(pclVO2.getProVO() != null){
					totPrice += (pclVO2.getProVO().getPro_disprice()*pclVO2.getProVO().getPst_quantity());
				}
			}
		}
		
		request.setAttribute("vblVo", vblVo);
		request.setAttribute("pptPclList", pptPclList);
		request.setAttribute("totPrice", totPrice);
		
		return "vbl/vbl_view.jsp";
	}

}
