package kr.co.uracle.push.dao.sample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.uracle.push.dao.AbstractDAO;

public class SampleDAO extends AbstractDAO {

	public List<Map<String, ?>> selectAll() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("Test.selectAll");
		}
	}
	
	public int insert() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			return sqlSession.insert("a");
		}
	}
}
