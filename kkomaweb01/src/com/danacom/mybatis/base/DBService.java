package com.danacom.mybatis.base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	static private SqlSessionFactory factory;
	
	// 초기화
	static{
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/danacom/mybatis/base/config.xml"));
		} catch (Exception e) {
		}
	}
	
	public static SqlSessionFactory getFactory(){
		return factory;
	}
}
