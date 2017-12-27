package kr.co.uracle.mybatis.session;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.data.TestData;

public class TestSqlSessionManager extends SqlSessionManager {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Ignore
	public void testSelectList() {
		String statement = "Test.selectAll";
		
		List<Map<String, String>> selectList = selectList(statement);
		
		for(Map<String, String> list : selectList) {
			logger.debug(list.toString());
		}
		
		assertNotNull(selectList);
		
		return;
	}
	
	@Test
	public void testSelectOne() {
		
	}
	
	@Test
	public void testInsert() {
		String statement = "Test.insert";

		List<TestData> list = new ArrayList<>();
		
		for(int i=0 ; i<10 ; i+=1) {
			TestData d = new TestData();
			d.setId("T2" + i);
			d.setPw("T2" + i);
			d.setName("T2" + i);
			list.add(d);
		}

		Map<String, List<TestData>> map = new HashMap<>();
		
		map.put("list", list);
		
		//setAutoCommit(true);
		
		int result = insert(statement, map);
		
		logger.debug("result : ");
		logger.debug(String.valueOf(result));
		
		//assertEquals(1, result);
		
		return;
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
	
}
