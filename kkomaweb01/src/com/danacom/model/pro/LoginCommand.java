package com.danacom.model.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danacom.model.base.BaseCommand;
import com.danacom.mybatis.pro.LoginDao;
import com.danacom.mybatis.pro.MemComVo;

public class LoginCommand implements BaseCommand {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		MemComVo login = new MemComVo(); 
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		String url = "ProController?dana=pro_main_prelist&pro_pcl_no=0101";
		
		List<MemComVo> list = LoginDao.getLoginChk(mem_id);
		
		if(list == null || list.size() == 0){
			login.setMsg("해당 ID가 존재하지 않습니다.");
			login.setCmd(102);
		}else if(list.size() == 1){
			login = list.get(0);
			if(login.getMem_pass().equals(mem_pass)){
				login.setMsg("");
				login.setCmd(101);
				
				request.getSession().setAttribute("login", login);
				if(login.getMem_admin_autho().equals("y")){
					url = "PclController?dana=pcl_list";
				}
			}else{
				login.setMsg("해당 PW가 같지 않습니다.");
				login.setCmd(102);
			}
		}else if(list.size() > 1){
			login.setMsg("해당 ID가 여러개 존재 합니다.");
			login.setCmd(102);
		}
		if(login.getCmd() == 102){
			request.setAttribute("login", login);
		}
		
		return url;
	}

}
