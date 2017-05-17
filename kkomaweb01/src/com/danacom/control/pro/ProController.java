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
import com.danacom.model.pro.ProAjaxListCommand;
import com.danacom.model.pro.ProTopSearchCommand;

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
		}
		
		path = baseComm.exec(request, response);
		
		if(forward){
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else{
			response.sendRedirect(path);
		}
		
	}

}
