package com.danacom.control.pro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.pro.LoginCommand;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
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
		
		if("loginChk".equals(dana)){
			baseComm = new LoginCommand();
		
			path = baseComm.exec(request, response);
			
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		
		}else if("logout".equals(dana)){
			request.getSession().removeAttribute("login");
			response.sendRedirect("ProController?dana=pro_main_prelist&pro_pcl_no=0101");
		}
		
	}

}
