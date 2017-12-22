package kr.co.uracle.mybatis.factory;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.uracle.mybatis.session.ConnectionFactory;

public class TestConnectionFatocy {

	@Test
	public void testGetSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
		assertNotNull(sqlSessionFactory);
	}
}
