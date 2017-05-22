package com.danacom.control.vbl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.pro.ProAdminListCommand;
import com.danacom.model.vbl.VblAjaxMkrPclCommand;
import com.danacom.model.vbl.VblAjaxProListCommand;
import com.danacom.model.vbl.VblInsertCommand;
import com.danacom.model.vbl.VblListCommand;
import com.danacom.model.vbl.VblViewCommand;

@WebServlet("/VblController")
public class VblController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VblController() {
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
		
		if("vbl_main_prelist".equals(dana)){
			exec_go = false;
			path = "vbl/vbl_list.jsp";
		}else if("ajax_vbl_list".equals(dana)){
			baseComm = new VblListCommand();
		}else if("ajax_vbl_preInsert".equals(dana)){
			exec_go = false;
			path = "vbl/vbl_insert.jsp";
		}else if("ajax_vbl_inMkrPcl".equals(dana)){
			baseComm = new VblAjaxMkrPclCommand();
		}else if("ajax_vbl_inProList".equals(dana)){
			baseComm = new VblAjaxProListCommand();
		}else if("ajax_vbl_insert".equals(dana)){
			baseComm = new VblInsertCommand();
			forward = false;
		}else if("vbl_view".equals(dana)){
			baseComm = new VblViewCommand();
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
