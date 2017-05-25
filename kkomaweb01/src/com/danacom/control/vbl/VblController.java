package com.danacom.control.vbl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.model.vbl.BtlAdminInsertCommand;
import com.danacom.model.vbl.BtlAdminListCommand;
import com.danacom.model.vbl.BtlDetListCommand;
import com.danacom.model.vbl.BtlDetPreJoinCommand;
import com.danacom.model.vbl.VbbInsertCommand;
import com.danacom.model.vbl.VbbListCommand;
import com.danacom.model.vbl.VbbRecommCommand;
import com.danacom.model.vbl.VbbReplyDeleteCommand;
import com.danacom.model.vbl.VbbReplyInsertCommand;
import com.danacom.model.vbl.VbbReplyUpdateCommand;
import com.danacom.model.vbl.VbbViewCommand;
import com.danacom.model.vbl.VblAjaxMkrPclCommand;
import com.danacom.model.vbl.VblAjaxProListCommand;
import com.danacom.model.vbl.VblDeleteCommand;
import com.danacom.model.vbl.VblInsertCommand;
import com.danacom.model.vbl.VblListCommand;
import com.danacom.model.vbl.VblUpdateCommand;
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
		}else if("ajax_vbl_update".equals(dana)){
			baseComm = new VblUpdateCommand();
			forward = false;
		}else if("ajax_vbl_delete".equals(dana)){
			baseComm = new VblDeleteCommand();
			forward = false;
		}else if("ajax_vbb_insert".equals(dana)){
			baseComm = new VbbInsertCommand();
			forward = false;
		}else if("vbb_prelist".equals(dana)){
			exec_go = false;
			path = "vbl/vbb_list.jsp";
		}else if("ajax_vbb_list".equals(dana)){
			baseComm = new VbbListCommand();
		}else if("vbb_view".equals(dana)){
			baseComm = new VbbViewCommand();
		}else if("vbb_reply_insert".equals(dana)){
			baseComm = new VbbReplyInsertCommand();
		}else if("vbb_reply_update".equals(dana)){
			baseComm = new VbbReplyUpdateCommand();
		}else if("vbb_reply_delete".equals(dana)){
			baseComm = new VbbReplyDeleteCommand();
		}else if("vbb_recomm".equals(dana)){
			baseComm = new VbbRecommCommand();
		}else if("btl_admin_list".equals(dana)){
			baseComm = new BtlAdminListCommand();
		}else if("btl_admin_preInsert".equals(dana)){
			exec_go = false;
			path = "vbl/btl_admin_insert.jsp";
		}else if("btl_admin_insert".equals(dana)){
			baseComm = new BtlAdminInsertCommand();
		}else if("btlDetList".equals(dana)){
			baseComm = new BtlDetListCommand();
		}else if("btlDetPrejoin".equals(dana)){
			baseComm = new BtlDetPreJoinCommand();
		}else if("ajaxVbbList".equals(dana)){
			baseComm = new VbbListCommand();
		}else if("ajaxBtlDetList".equals(dana)){
			baseComm = new BtlDetListCommand();
		}else if("btl_main_list".equals(dana)){
			baseComm = new BtlAdminListCommand();
		}else if("ajaxVbbRead".equals(dana)){
			baseComm = new VbbViewCommand();
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
