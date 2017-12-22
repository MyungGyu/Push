package kr.co.uracle.push.dao.sample;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.co.uracle.push.dao.AbstractDAO;
import kr.co.uracle.push.dao.sample.SampleDAO;

public class TestSampleDAO extends AbstractDAO {

	@Test
	public void testSelectAll() {
		SampleDAO dao = new SampleDAO();
		
		List<Map<String, ?>> list = dao.selectAll();

		for(Map<String, ?> m : list) {
			System.out.println(m);
		}
		
		assertNotNull(list);
	}
}
