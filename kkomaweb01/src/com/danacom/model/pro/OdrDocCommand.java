package com.danacom.model.pro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.OdrDet;
import com.danacom.mybatis.pro.OdrDocVo;
import com.danacom.mybatis.pro.SctDao;

public class OdrDocCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		OdrDocVo doc = new OdrDocVo();
		doc.setOdr_condition(1);
		doc.setDlv_sendaddr(request.getParameter("dlv_sendaddr"));
		doc.setMem_no(Integer.parseInt(request.getParameter("mem_no")));
		doc.setUseMileage(Integer.parseInt(request.getParameter("useMileage")));
		doc.setS_totPrice(Integer.parseInt(request.getParameter("s_totPrice")));
		doc.setOdr_way(request.getParameter("odr_way"));
		doc.setDlv_sender(request.getParameter("dlv_sender"));
		doc.setDlv_tel(request.getParameter("dlv_tel"));
		doc.setDlv_sphone(request.getParameter("dlv_sphone"));
		doc.setDlv_msg(request.getParameter("dlv_msg"));

		String[] s_pro_no = request.getParameterValues("s_pro_no");
		int[] s_pro_no_i = new int[s_pro_no.length];
		for(int i = 0; i<s_pro_no.length; i++){
			s_pro_no_i[i] = Integer.parseInt(s_pro_no[i]);
		}
		doc.setS_pro_no(s_pro_no_i);
		
		String[] s_odt_count = request.getParameterValues("s_odt_count");
		int[] s_odt_count_i = new int[s_pro_no.length];
		for(int i = 0; i<s_odt_count.length; i++){
			s_odt_count_i[i] = Integer.parseInt(s_odt_count[i]);
		}
		doc.setS_odt_count(s_odt_count_i);
		
		String[] s_pro_disprice = request.getParameterValues("s_pro_disprice");
		int[] s_pro_disprice_i = new int[s_pro_no.length];
		for(int i = 0; i<s_pro_disprice.length; i++){
			s_pro_disprice_i[i] = Integer.parseInt(s_pro_disprice[i]);
		}
		doc.setS_pro_disprice(s_pro_disprice_i);
		
		String[] s_pro_milege = request.getParameterValues("s_pro_milege");
		int[] s_pro_milege_i = new int[s_pro_no.length];
		for(int i = 0; i<s_pro_milege.length; i++){
			s_pro_milege_i[i] = Integer.parseInt(s_pro_milege[i]);
		}
		doc.setS_pro_milege(s_pro_milege_i);
		
		String[] s_odt_pro_part = request.getParameterValues("s_odt_pro_part");
		int[] s_odt_pro_part_i = new int[s_pro_no.length];
		for(int i = 0; i<s_odt_pro_part.length; i++){
			s_odt_pro_part_i[i] = Integer.parseInt(s_odt_pro_part[i]);
		}
		doc.setS_odt_pro_part(s_odt_pro_part_i);
		
		String odr_no_max = SctDao.getOdrMaxNo();
		doc.setOdr_no_max(odr_no_max);
		
		SctDao.odrInsert(doc);
		
		String del_no_max = SctDao.getDlvMaxNo();
		doc.setDel_no_max(del_no_max);
		
		SctDao.dlvInsert(doc);
		
		for(int i=0; i < doc.getS_pro_no().length; i++){
			OdrDet  odtVo = new OdrDet(); 
			odtVo.setS_pro_no(doc.getS_pro_no()[i]);
			odtVo.setS_odt_count(doc.getS_odt_count()[i]);
			odtVo.setS_pro_disprice(doc.getS_pro_disprice()[i]);
			odtVo.setS_pro_milege(doc.getS_pro_milege()[i]);
			odtVo.setS_odt_pro_part(doc.getS_odt_pro_part()[i]);
			odtVo.setOdr_no_max(odr_no_max);
			odtVo.setDel_no_max(del_no_max);
			SctDao.odtInsert(odtVo);
			
			Map<String, Object> stockcount_map = new HashMap<>();
			stockcount_map.put("s_pro_no", doc.getS_pro_no()[i]);
			stockcount_map.put("s_count", doc.getS_odt_count()[i]);
			SctDao.proCountUpdate(stockcount_map);
		}
		
		SctDao.editMileage(doc);
		
		SctDao.memMilAdd(doc);
		
		SctDao.commit();
		
		request.setAttribute("odr_no_max", odr_no_max);
		request.setAttribute("dlv_sender", request.getParameter("dlv_sender"));
		request.setAttribute("odr_way", "무통장입금");
		
		String returnUrl = "sct/odr_result.jsp";
		
		return returnUrl;
	}

}
