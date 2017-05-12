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
		
		RequestDispatcher rd = null;
		BaseCommand baseComm = null;
		
		dana = request.getParameter("dana");
		
		if("pcl_list".equals(dana)){
			baseComm = new PclAdminListCommand();
		}else if("ajax_pcl_list".equals(dana)){
			baseComm = new PclAjaxAdminListCommand();
		}
		
		path = baseComm.exec(request, response);
		
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
