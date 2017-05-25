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

	public static int vdtInsert(VblDetVo vdtCommand) {
		return getSql().insert("vdtInsert", vdtCommand);
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

	public static int vdsInsert(VblDetVo vdtCommand) {
		return getSql().insert("vdsInsert", vdtCommand);
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

	public static void recommVbbContent(VbbVo vbb_Command) {
		getSql().update("recommVbbContent", vbb_Command);
	}

	public static void replyInsert(VbbVo vbb_Command) {
		getSql().insert("replyInsert", vbb_Command);
	}

	public static void replyUpdate(VbbVo vbb_Command) {
		getSql().update("replyUpdate", vbb_Command);
	}

	public static void replyDelete(VbbVo vbb_Command) {
		getSql().delete("replyDelete", vbb_Command);
	}
	
	public static List<BtlVo> getBtlList(Map<String, Object> requestMap) {
		return getSql().selectList("btlList", requestMap);
	}

	public static void btlInsert(BtlVo btl_Command) {
		getSql().insert("btlInsert", btl_Command);
	}

	public static BtlVo getBtlView(BtlVo btl_Command) {
		return getSql().selectOne("getBtlView", btl_Command);
	}

	public static List<BtlVo> getBtlDetList(BtlVo btl_Command) {
		return getSql().selectList("getBtlDetList", btl_Command);
	}

	public static int getVbjMaxNo() {
		return getSql().selectOne("vbjMaxNo");
	}

	public static void vbjInsert(BtlVo btl_Command) {
		getSql().insert("vbjInsert", btl_Command);
	}

	public static List<BtlVo> getVdsNoList(BtlVo btl_Command) {
		return getSql().selectList("getVdsNoList", btl_Command);
	}

	public static void vbdInsert(BtlVo btl_Command) {
		getSql().insert("vbdInsert", btl_Command);
	}

	public static void answerVbbUpdate(BtlVo btl_Command) {
		getSql().update("answerVbbUpdate", btl_Command);
	}

	public static BtlVo getBtlJoinContent(BtlVo btl_Command) {
		return getSql().selectOne("getBtlJoinContent", btl_Command);
	}

	public static List<BtlVo> getBtlJoinDetList(BtlVo btl_Command) {
		return getSql().selectList("getBtlJoinDetList", btl_Command);
	}

	public static void vbdDelete(BtlVo btl_Command) {
		getSql().delete("vbdDelete", btl_Command);
	}

	public static void vbjDelete(BtlVo btl_Command) {
		getSql().delete("vbjDelete", btl_Command);
	}

	public static void gradeVbjUpdate(BtlVo btl_Command) {
		getSql().update("gradeVbjUpdate", btl_Command);
	}

}
