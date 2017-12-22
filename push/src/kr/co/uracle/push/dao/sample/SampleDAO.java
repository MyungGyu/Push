package kr.co.uracle.push.dao.sample;

import java.util.List;
import java.util.Map;

import kr.co.uracle.mybatis.session.SqlSessionManager;

public class SampleDAO extends SqlSessionManager {

	public List<Map<String, ?>> selectAll() {
		return selectList("Test.selectAll");
	}
	
	public int insert() {
		return insert("insert");
	}
}
