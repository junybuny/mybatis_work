package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// 마이바티스
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml => 파일 읽어들이기
		// 해당 DB와 접속된 SqlSession 객체 생성해서 반환하기
		
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해서는 => SqlSessionFactory필요
		// SqlSessionFactory 생성하기 위해서는 => SqlSessionFactoryBuilder필요
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			// openSession(boolean flag) => flag: 자동커밋 여부 (true: 자동커밋 false: 수동커밋)
			
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}
}
