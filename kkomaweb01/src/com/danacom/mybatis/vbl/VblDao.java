package com.danacom.mybatis.vbl;

import java.util.List;
import java.util.Map;

import com.danacom.mybatis.base.BaseDao;

public class VblDao extends BaseDao {
	
	/**
     * 가상견적서 리스트
     * 
     * @author		유종훈
     * @date		2017. 05. 21
     */
	public static List<VirBillVo> getVblList(Map<String, Object> requestMap){
		return getSql().selectList("vblList", requestMap);
	}

}
