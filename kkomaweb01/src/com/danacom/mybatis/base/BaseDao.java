package com.danacom.mybatis.base;

import org.apache.ibatis.session.SqlSession;

// DB관련된 처리하는 클래스
public class BaseDao {
	private static SqlSession ss;
	
	// 싱글톤 패턴 : 프로그램이 끝날때까지 해당 객체는 하나면 가지고 사용
	protected synchronized static SqlSession getSql(){
		if(ss == null){
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	public static int get_found_rows() {
		return getSql().selectOne("found_rows");
	}
	
	public static void commit(){
		getSql().commit();
	}
	
}
