package kr.co.uracle.push.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.uracle.mybatis.session.ConnectionFactory;

public class AbstractDAO {

	protected SqlSessionFactory sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	
}
