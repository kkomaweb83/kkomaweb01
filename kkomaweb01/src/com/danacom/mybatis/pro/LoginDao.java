package com.danacom.mybatis.pro;

import java.util.List;

import com.danacom.mybatis.base.BaseDao;

public class LoginDao extends BaseDao {
	
	/**
     * 사용자 로그인 체크
     * 
     * @author		유종훈
     * @date		2017. 05. 09
     */
	public static List<MemComVo> getLoginChk(String mem_id){
		return getSql().selectList("loginChk", mem_id);
	}

}
