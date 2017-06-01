package com.danacom.control.pcl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.pcl.PclAdminListCommand;
import com.danacom.model.pcl.PclAjaxAdminListCommand;
import com.danacom.model.pcl.PclAutoNoCommand;
import com.danacom.model.pcl.PclDeleteCommand;
import com.danacom.model.pcl.PclInsertCommand;
import com.danacom.model.pcl.PclPreUpdateCommand;
import com.danacom.model.pcl.PclUpdateCommand;

@WebServlet("/PclController")
public class PclController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PclController() {
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
		
		if("pcl_list".equals(dana)){
			baseComm = new PclAdminListCommand();
		}else if("ajax_pcl_list".equals(dana)){
			baseComm = new PclAjaxAdminListCommand();
		}else if("pcl_auto_no".equals(dana)){
			baseComm = new PclAutoNoCommand();
		}else if("pcl_preUpdate".equals(dana)){
			baseComm = new PclPreUpdateCommand();
		}else if("pcl_insert".equals(dana)){
			baseComm = new PclInsertCommand();
			forward = false;
		}else if("pcl_update".equals(dana)){
			baseComm = new PclUpdateCommand();
			forward = false;
		}else if("pcl_delete".equals(dana)){
			baseComm = new PclDeleteCommand();
			forward = false;
		}else if("member_prejoin".equals(dana)){
			exec_go = false;
			path = "pcl/member_prejoin.jsp";
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
