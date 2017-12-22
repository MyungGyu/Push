package kr.co.uracle.mybatis.session;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.uracle.mybatis.session.ConnectionFactory;

public class SqlSessionManager {

	private final SqlSessionFactory sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	
	private boolean isAutoCommit = false;
	
	private ExecutorType executorType = ExecutorType.BATCH;
	
	protected void setAutoCommit (boolean isAutoCommit) {
		this.isAutoCommit = isAutoCommit;
	}
	
	protected void setExecutorType (ExecutorType executorType) {
		this.executorType = executorType;
	}
	
	protected <E> List<E> selectList (String statement) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList(statement);
		}
	}
	
	protected <E> List<E> selectList (String statement, Object parameters) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList(statement, parameters);
		}
	}
	
	protected <E> E selectOne (String statement) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne(statement);
		}
	}
	
	protected <E> E selectOne (String statement, Object parameters) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne(statement, parameters);
		}
	}
	
	protected int insert (String statement) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.insert(statement);
		}
	}
	
	protected int insert (String statement, Object parameters) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.insert(statement, parameters);
		}
	}
	
	protected int update (String statement) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.update(statement);
		}
	}
	
	protected int update (String statement, Object parameters) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.update(statement, parameters);
		}
	}
	
	protected int delete (String statement) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.delete(statement);
		}
	}
	
	protected int delete (String statement, Object parameters) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession( executorType, isAutoCommit )) {
			return sqlSession.delete(statement, parameters);
		}
	}
}
