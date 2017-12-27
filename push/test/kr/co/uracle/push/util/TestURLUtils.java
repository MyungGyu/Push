package kr.co.uracle.push.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.http.MessageResponse;

public class TestURLUtils {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testSendGet() {
		String url = "http://211.241.199.11:10002/receiver/asking_authorization.ctl";
		
		URLUtils urlUtils = new URLUtils(url);
		
		urlUtils.sendGet();
		
		MessageResponse messageResponse = urlUtils.getResponse();
		
		logger.debug(messageResponse.toString());
		
		assertNotNull(messageResponse);
	}
	
	@Test
	public void testSendPost() {
		
		String url = "http://211.241.199.11:10002/receiver/asking_authorization.ctl";
		
		URLUtils urlUtils = new URLUtils(url);
		
		urlUtils.sendPost();
		
		MessageResponse messageResponse = urlUtils.getResponse();
		
		logger.debug(messageResponse.toString());
		
		assertNotNull(messageResponse);
		
		return;
	}
}
