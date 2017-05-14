package com.danacom.control.mkr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.mkr.MkrAdminListCommand;
import com.danacom.model.mkr.MkrDeleteCommand;
import com.danacom.model.mkr.MkrInsertCommand;
import com.danacom.model.mkr.MkrPreUpdateCommand;
import com.danacom.model.mkr.MkrUpdateCommand;

@WebServlet("/MkrController")
public class MkrController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MkrController() {
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
		
		if("mkr_list".equals(dana)){
			baseComm = new MkrAdminListCommand();
		}else if("mkr_preUpdate".equals(dana)){
			baseComm = new MkrPreUpdateCommand();
		}else if("mkr_insert".equals(dana)){
			baseComm = new MkrInsertCommand();
			forward = false;
		}else if("mkr_update".equals(dana)){
			baseComm = new MkrUpdateCommand();
			forward = false;
		}else if("mkr_delete".equals(dana)){
			baseComm = new MkrDeleteCommand();
			forward = false;
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
