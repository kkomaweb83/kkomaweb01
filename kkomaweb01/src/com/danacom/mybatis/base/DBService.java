package com.danacom.mybatis.base;

import java.net.InetAddress;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	static private SqlSessionFactory factory;
	
	// 초기화
	static{
		try {
			String config = "config.xml";
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Host Name = [" + ip.getHostName() + "]"); 
			System.out.println("Host Address = [" + ip.getHostAddress() + "]");
			
			if("183.111.100.173".equals(ip.getHostAddress())){
				config = "mysql_config.xml";
			}
			config = "mysql_config.xml";

			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/danacom/mybatis/base/"+config));
		} catch (Exception e) {
		}
	}
	
	public static SqlSessionFactory getFactory(){
		return factory;
	}
}
