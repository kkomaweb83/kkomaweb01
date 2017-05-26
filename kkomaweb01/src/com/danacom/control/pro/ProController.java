package com.danacom.control.pro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.pcl.PclTopListCommand;
import com.danacom.model.pro.OdrDocCommand;
import com.danacom.model.pro.ProAjaxListCommand;
import com.danacom.model.pro.ProAjaxViewCommand;
import com.danacom.model.pro.ProTopSearchCommand;
import com.danacom.model.pro.SctAjaxAllDeleteCommand;
import com.danacom.model.pro.SctAjaxDeleteCommand;
import com.danacom.model.pro.SctAjaxInsertCommand;
import com.danacom.model.pro.SctAjaxListCommand;
import com.danacom.model.pro.SctAjaxMutiInsertCommand;
import com.danacom.model.pro.SctAjaxUpdateCommand;
import com.danacom.model.pro.SctOdrDocCommand;

@WebServlet("/ProController")
public class ProController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String dana = "";
		String path = "";
		Boolean forward = true;
		Boolean exec_go = true;
		
		RequestDispatcher rd = null;
		BaseCommand baseComm = null;
		
		dana = request.getParameter("dana");
		
		if("pro_main_prelist".equals(dana)){
			baseComm = new PclTopListCommand();  // 메인 상단 상품분류 조회
		}else if("ajax_pro_topSearch".equals(dana)){
			baseComm = new ProTopSearchCommand();
		}else if("ajax_pro_list".equals(dana)){
			baseComm = new ProAjaxListCommand();
		}else if("ajax_pro_pclSearch".equals(dana)){
			baseComm = new ProAjaxListCommand();
		}else if("ajax_pro_mainView".equals(dana)){
			baseComm = new ProAjaxViewCommand();
		}else if("sct_main_prelist".equals(dana)){
			exec_go = false;
			path = "sct/sct_main_list.jsp";
		}else if("ajax_sct_list".equals(dana)){
			baseComm = new SctAjaxListCommand();
		}else if("ajax_sct_insert".equals(dana)){
			baseComm = new SctAjaxInsertCommand();
		}else if("ajax_sct_update".equals(dana)){
			baseComm = new SctAjaxUpdateCommand();
		}else if("ajax_sct_delete".equals(dana)){
			baseComm = new SctAjaxDeleteCommand();
		}else if("ajax_sct_alldelete".equals(dana)){
			baseComm = new SctAjaxAllDeleteCommand();
		}else if("ajax_sct_multi_insert".equals(dana)){
			baseComm = new SctAjaxMutiInsertCommand();
			forward = false;
		}else if("sct_odr_doc".equals(dana)){
			baseComm = new SctOdrDocCommand();
		}else if("odr_doc".equals(dana)){
			baseComm = new OdrDocCommand();
		}
		
		if(exec_go){
			path = baseComm.exec(request, response);
		}
		
		if(forward){
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else{
			response.sendRedirect(path);
		}
		
	}

}
