package com.danacom.mybatis.vbl;

import java.util.List;
import java.util.Map;

import com.danacom.mybatis.base.BaseDao;
import com.danacom.mybatis.pcl.ProClassVo;
import com.danacom.mybatis.pro.ProductVo;

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

	public static int getVblMaxNo() {
		return getSql().selectOne("vblMaxNo");
	}

	public static void vblInsert(VirBillVo vblCommand) {
		getSql().insert("vblInsert", vblCommand);
	}

	public static void vdtInsert(VblDetVo vdtCommand) {
		getSql().insert("vdtInsert", vdtCommand);
	}

	public static VirBillVo getVblVo(int vbl_no) {
		return getSql().selectOne("vblVo", vbl_no);
	}

	public static ProductVo getvVblProVo(ProClassVo pclVO2) {
		return getSql().selectOne("vblProVo", pclVO2);
	}
	
	public static void commit(){
		getSql().commit();
	}

	public static void vblUpdate(VirBillVo vblCommand) {
		getSql().update("vblUpdate", vblCommand);
	}

	public static void vdtDelete(int vblMaxNo) {
		getSql().delete("vdtDelete", vblMaxNo);
	}

	public static void vblDelete(int vblMaxNo) {
		getSql().delete("vblDelete", vblMaxNo);
	}

	public static int getVbbMaxNo() {
		return getSql().selectOne("vbbMaxNo");
	}

	public static void vbbInsert(VirBillVo vblCommand) {
		getSql().insert("vbbInsert", vblCommand);
	}

	public static void vdsInsert(VblDetVo vdtCommand) {
		getSql().insert("vdsInsert", vdtCommand);
	}

	public static List<VbbVo> getVbbList(Map<String, Object> requestMap) {
		return getSql().selectList("vbbList", requestMap);
	}

	public static void countUpVbbContent(VbbVo vbb_Command) {
		getSql().update("countUpVbbContent", vbb_Command);
	}

	public static VbbVo getVbbContent(VbbVo vbb_Command) {
		return getSql().selectOne("getVbbContent", vbb_Command);
	}

	public static List<VbsVo> getVbbContentPro(VbbVo vbb_Command) {
		return getSql().selectList("getVbbContentPro", vbb_Command);
	}

	public static List<VbbVo> getVbrList(VbbVo vbb_Command) {
		return getSql().selectList("getVbrList", vbb_Command);
	}

}
