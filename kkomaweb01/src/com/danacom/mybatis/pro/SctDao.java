package com.danacom.mybatis.pro;

import java.util.List;

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

}
