package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProDeleteCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/product_img");
		MultipartRequest mr;
		ProductVo proCommand = new ProductVo();
		
		try{
			mr = new MultipartRequest(
					request,
					path,
					1024*150,
					"utf-8",
					new DefaultFileRenamePolicy());
			
			int proMaxNo= Integer.parseInt(request.getParameter("pro_no"));
			
			proCommand.setPro_no(proMaxNo);
			proCommand.setPro_pcl_no(mr.getParameter("pro_pcl_no"));
	
			ProDao.pdtDelete(proMaxNo);
			ProDao.pmgDelete(proMaxNo);
			ProDao.psmDelete(proMaxNo);
			ProDao.proDelete(proMaxNo);
			
			ProDao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ProAdminController?dana=pro_admin_list&pro_pcl_no="+proCommand.getPro_pcl_no();
	}

}
