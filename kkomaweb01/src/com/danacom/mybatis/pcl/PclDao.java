package com.danacom.mybatis.pcl;

import java.util.List;

import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.pro.ProTempVo;

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
	
	public static ProClassVo getPclVO(String pcl_upperno){
		return getSql().selectOne("pclVO", pcl_upperno);
	}

	public static String getMaxPclNo(String pcl_uppercode) {
		return getSql().selectOne("pclAutoPclNo", pcl_uppercode);
	}

	public static void pclInsert(ProClassVo pclVO) {
		getSql().insert("pclInsert", pclVO);
		getSql().commit();
	}
	
	public static void pclUpdate(ProClassVo pclVO) {
		getSql().update("pclUpdate", pclVO);
		getSql().commit();
	}
	
	public static void pclDelete(String pcl_no) {
		getSql().delete("pclDelete", pcl_no);
		getSql().commit();
	}

	public static ProTempVo getNextPclVo(ProTempVo proTempVO) {
		return getSql().selectOne("nextPclVo", proTempVO);
	}
	
}
