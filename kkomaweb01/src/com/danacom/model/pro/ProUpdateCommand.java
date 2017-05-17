package com.danacom.model.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.ProDao;
import com.danacom.mybatis.pro.Pro_detVo;
import com.danacom.mybatis.pro.Pro_imgVo;
import com.danacom.mybatis.pro.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProUpdateCommand implements BaseCommand {

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
			
			int proMaxNo= Integer.parseInt(mr.getParameter("pro_no"));
			
			proCommand.setPro_no(proMaxNo);
			proCommand.setPro_name(mr.getParameter("pro_name"));
			proCommand.setPro_disprice(Integer.parseInt(mr.getParameter("pro_disprice")));
			proCommand.setPro_stockcount(Integer.parseInt(mr.getParameter("pro_stockcount")));
			proCommand.setPro_pcl_no(mr.getParameter("pro_pcl_no"));
			proCommand.setPro_mkr_no(Integer.parseInt(mr.getParameter("pro_mkr_no")));
			proCommand.setPsm_conent(mr.getParameter("psm_conent"));
			proCommand.setStep(mr.getParameterValues("step"));
			
			String[] setp = proCommand.getStep();
			
			String pdt_name = ""; 
			String pdt_conent = "";
			
			ProDao.proUpdate(proCommand);
			ProDao.psmUpdate(proCommand);
			
			Pro_imgVo pmgCommand = new Pro_imgVo(); 
			pmgCommand.setPmg_pro_no(proMaxNo);
			
			if(mr.getFile("pmg_file_s1") != null){
				pmgCommand.setPmg_file(mr.getFilesystemName("pmg_file_s1"));
				pmgCommand.setPmg_idt_no(1);
				ProDao.pmgUpdate(pmgCommand);
			}
			
			if(mr.getFile("pmg_file_s2") != null){
				pmgCommand.setPmg_file(mr.getFilesystemName("pmg_file_s2"));
				pmgCommand.setPmg_idt_no(2);
				ProDao.pmgUpdate(pmgCommand);
			}
			
			ProDao.pdtDelete(proMaxNo);
			
			Pro_detVo pdtCommand = new Pro_detVo();
			for(int i = 0; i < setp.length; i++){
				String[] temp = setp[i].split(",");
				pdt_name = mr.getParameter("pdt_step4_" + temp[0] + "_" + temp[1]);
				pdt_conent = mr.getParameter("pdt_step51_" + temp[0] + "_" + temp[1]);
				pdtCommand.setPdt_name(pdt_name);
				pdtCommand.setPdt_conent(pdt_conent);
				pdtCommand.setPdt_pro_no(proMaxNo);
				if(!pdt_conent.equals("NULL")){
					ProDao.pdtInsert(pdtCommand);
				}
			}
			ProDao.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ProAdminController?dana=pro_admin_list&pro_pcl_no="+proCommand.getPro_pcl_no();
	}

}
