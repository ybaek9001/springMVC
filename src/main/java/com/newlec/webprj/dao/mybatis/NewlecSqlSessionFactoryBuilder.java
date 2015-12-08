package com.newlec.webprj.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewlecSqlSessionFactoryBuilder {// ��� ���ø����̼ǿ��� ���ٰ���

	static SqlSessionFactory ssf;

	static {
		String resource = "com/newlec/webprj/dao/mybatis/MybatisConfig.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return ssf;
	}
}