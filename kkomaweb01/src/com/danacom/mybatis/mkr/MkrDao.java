package com.danacom.mybatis.mkr;

import java.util.List;

import com.danacom.mybatis.base.BaseDao;

public class MkrDao extends BaseDao {

	/**
     * 사용자 상품 리스트 상단 검색조건 제조사 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 08
     */
	public static List<MakerVo> getMkrList(String pro_pcl_no){
		return getSql().selectList("mkrList", pro_pcl_no);
	}
		
}
