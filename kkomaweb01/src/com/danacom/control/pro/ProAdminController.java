package com.danacom.control.pro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.pro.ProAdminListCommand;
import com.danacom.model.pro.ProAdminViewCommand;
import com.danacom.model.pro.ProInsertCommand;
import com.danacom.model.pro.PropdtpreselCommand;

@WebServlet("/ProAdminController")
public class ProAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProAdminController() {
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
		
		if("pro_admin_list".equals(dana)){
			baseComm = new ProAdminListCommand();
		}else if("pro_preInsert".equals(dana)){
			exec_go = false;
			path = "pro/pro_preInsert.jsp";
		}else if("propdtpresel".equals(dana)){
			baseComm = new PropdtpreselCommand();
		}else if("pro_insert".equals(dana)){
			baseComm = new ProInsertCommand();
			forward = false;
		}else if("pro_admin_view".equals(dana)){
			baseComm = new ProAdminViewCommand();
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
