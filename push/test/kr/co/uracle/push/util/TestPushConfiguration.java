package kr.co.uracle.push.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.api.UPMCApi;

public class TestPushConfiguration {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testGet() {
		String value = PushConfiguration.get("push.receiver.ip");

		assertEquals("localhost", value);
	}

	@Test
	public void testGetInteger() {
		int value = PushConfiguration.getInteger("scheduler.unit.delay");

		logger.debug(UPMCApi.REGISTER_MESSAGE.getControllerURL());
		logger.debug(UPMCApi.REGISTER_MESSAGE_WITH_CSV.getControllerURL());

		assertEquals(1000, value);
	}
}
