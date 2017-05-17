package com.danacom.mybatis.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danacom.mybatis.base.BaseDao;

public class ProDao extends BaseDao {

	public static List<ProductVo> getProAdminList(Map<String, Object> requestMap) {
		return getSql().selectList("proAdminPclList", requestMap);
	}

	public static int getProMaxNo() {
		return getSql().selectOne("proMaxNO");
	}

	public static void proInsert(ProductVo proCommand) {
		getSql().insert("proInsert", proCommand);
	}

	public static void psmInsert(ProductVo proCommand) {
		getSql().insert("psmInsert", proCommand);
	}

	public static void pmgInsert(Pro_imgVo pmgCommand) {
		getSql().insert("pmgInsert", pmgCommand);
	}

	public static void pdtInsert(Pro_detVo pdtCommand) {
		getSql().insert("pdtInsert", pdtCommand);
	}
	
	public static void commit(){
		getSql().commit();
	}

	public static ProductVo getProVo(int pro_no) {
		return getSql().selectOne("proVo", pro_no);
	}

	public static String getPmgFile(int pro_no, int idt_no) {
		Map<String, Integer> map = new HashMap<>();
		map.put("pro_no", pro_no);
		map.put("idt_no", idt_no);
		return getSql().selectOne("pmgFile", map);
	}

	public static void proUpdate(ProductVo proCommand) {
		getSql().update("proUpdate", proCommand);
	}

	public static void psmUpdate(ProductVo proCommand) {
		getSql().update("psmUpdate", proCommand);
	}

	public static void pmgUpdate(Pro_imgVo pmgCommand) {
		getSql().update("pmgUpdate", pmgCommand);
	}

	public static void pdtDelete(int proMaxNo) {
		getSql().delete("pdtDelete", proMaxNo);
	}

	public static void pmgDelete(int proMaxNo) {
		getSql().delete("pmgDelete", proMaxNo);
	}

	public static void psmDelete(int proMaxNo) {
		getSql().delete("psmDelete", proMaxNo);
	}

	public static void proDelete(int proMaxNo) {
		getSql().delete("proDelete", proMaxNo);
	}

	public static List<ProductVo> getProMainList(Map<String, Object> requestMap) {
		return getSql().selectList("proMainList", requestMap);
	}

}
