package com.danacom.mybatis.pro;

import java.util.List;
import java.util.Map;

import com.danacom.mybatis.base.BaseDao;

public class ProDao extends BaseDao {

	public static List<ProductVo> getProAdminList(Map<String, String> proMap) {
		return getSql().selectList("proAdminPclList", proMap);
	}

}
