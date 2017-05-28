package com.danacom.mybatis.pro;

import java.util.List;
import java.util.Map;

import com.danacom.mybatis.base.BaseDao;

public class SctDao extends BaseDao {

	public static List<Shop_cart> getSctList(int sct_mem_no) {
		return getSql().selectList("sctList", sct_mem_no);
	}

	public static Shop_proVO getSctProVo(Shop_cart temp) {
		return getSql().selectOne("sctProVo", temp);
	}

	public static Shop_proVO getSctPptVo(Shop_cart temp) {
		return getSql().selectOne("sctPptVo", temp);
	}

	public static SctTotPriceVO getSctTotPrice(SctTotPriceVO sctTotPrivceVo) {
		return getSql().selectOne("sctTotPrice", sctTotPrivceVo);
	}

	public static int sctInsertChk(Shop_cart sctCommand) {
		return getSql().selectOne("insertChk", sctCommand);
	}

	public static void sctInsert(Shop_cart sctCommand) {
		getSql().insert("sctInsert", sctCommand);
	}

	public static void sctCountUpdate(Shop_cart sctCommand) {
		getSql().update("countUpdate", sctCommand);
	}
	
	public static void sctUpdate(Shop_cart sctCommand) {
		getSql().update("sctUpdate", sctCommand);
	}
	
	public static void sctDelete(int sct_no) {
		getSql().delete("sctDelete", sct_no);
	}
	
	public static void sctAllDelete(int sct_mem_no) {
		getSql().delete("sctAllDelete", sct_mem_no);
	}
	
	public static void commit(){
		getSql().commit();
	}

	public static SctTotPriceVO getMemMilege(int sct_mem_no) {
		return getSql().selectOne("memMilege", sct_mem_no);
	}

	public static String getOdrMaxNo() {
		return getSql().selectOne("getOdrMaxNo");
	}

	public static void odrInsert(OdrDocVo doc) {
		getSql().insert("odrInsert", doc);
	}

	public static String getDlvMaxNo() {
		return getSql().selectOne("getDlvMaxNo");
	}

	public static void dlvInsert(OdrDocVo doc) {
		getSql().insert("dlvInsert", doc);
	}

	public static void odtInsert(OdrDet odtVo) {
		getSql().insert("odtInsert", odtVo);
	}
	
	public static void proCountUpdate(Map<String, Object> stockcount_map) {
		getSql().update("proCountUpdate", stockcount_map);
	}

	public static void editMileage(OdrDocVo doc) {
		getSql().update("editMileage", doc);
	}

	public static void memMilAdd(OdrDocVo doc) {
		getSql().update("memMilAdd", doc);
	}

	public static List<MpVo> getOrdersList(Map<String, Object> requestMap) {
		return getSql().selectList("getOrdersList", requestMap);
	}

	public static MpVo getOrdersDetList(String odr_no) {
		return getSql().selectOne("getOrdersDetList", odr_no);
	}

	public static List<Shop_cart> getOdcOdtList(String odr_no) {
		return getSql().selectList("getOdcOdtList", odr_no);
	}

	public static void conditionUpdate(OdrDocVo doc) {
		getSql().update("conditionUpdate", doc);
	}

}
