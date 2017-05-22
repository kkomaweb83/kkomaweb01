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

}
