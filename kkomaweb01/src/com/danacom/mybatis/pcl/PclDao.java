package com.danacom.mybatis.pcl;

import java.util.List;

import com.danacom.mybatis.base.BaseDao;

public class PclDao extends BaseDao {

	/**
     * 메인 상단 상품분류 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 08
     */
	public static List<ProClassVo> getPclList(String pcl_upperno){
		return getSql().selectList("pclList", pcl_upperno);
	}
	
	/**
     * 사용자 상품 리스트 상품분류명 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 08
     */
	public static String getMainPclName(String pro_pcl_no){
		return getSql().selectOne("mainPclName", pro_pcl_no);
	}
	
}