package com.danacom.mybatis.mkr;

import java.util.List;

import com.danacom.mybatis.base.BaseDao;

public class MkrDao extends BaseDao {

	/**
     * 관리자 제조사 리스트 조회
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	public static List<MakerVo> getMkrList(String pro_pcl_no){
		return getSql().selectList("mkrList", pro_pcl_no);
	}

	/**
     * 관리자 제조사 등록
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	public static void mkrInsert(MakerVo mkrCom) {
		getSql().insert("mkrInsert", mkrCom);
		getSql().commit();
	}
	
	/**
     * 관리자 제조사 상세조회
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	public static MakerVo getMkrVO(String mkr_no){
		return getSql().selectOne("mkrVO", mkr_no);
	}
	
	/**
     * 관리자 제조사 수정
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	public static void mkrUpdate(MakerVo mkrCom) {
		getSql().insert("mkrUpdate", mkrCom);
		getSql().commit();
	}
	
	/**
     * 관리자 제조사 삭제
     * 
     * @author		유종훈
     * @date		2017. 05. 14
     */
	public static void mkrDelete(String mkr_no) {
		getSql().delete("mkrDelete", mkr_no);
		getSql().commit();
	}
		
}
