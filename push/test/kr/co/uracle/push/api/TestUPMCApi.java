package kr.co.uracle.push.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.http.MessageResponse;
import kr.co.uracle.push.http.RegisterCSVMessageRequest;
import kr.co.uracle.push.http.RegisterMessageRequest;

public class TestUPMCApi {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testGetControllerURL() {
		String registerMessageControllerURL = UPMCApi.REGISTER_MESSAGE.getControllerURL();
		String registerMessageControllerURLWithoutParsing = UPMCApi.REGISTER_MESSAGE.getControllerURL(false);
		String registerCSVMessageControllerURL = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getControllerURL();
		String registerCSVMessageControllerURLWithoutParsing = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getControllerURL(false);
		
		logger.debug(registerMessageControllerURL);
		logger.debug(registerMessageControllerURLWithoutParsing);
		logger.debug(registerCSVMessageControllerURL);
		logger.debug(registerCSVMessageControllerURLWithoutParsing);
		
		assertEquals("http://localhost:8080/rcv_register_message.ctl", registerMessageControllerURL);
		assertEquals("rcv_register_message.ctl", registerMessageControllerURLWithoutParsing);
		
		assertEquals("http://localhost:8080/rcv_register_csvmessage.ctl", registerCSVMessageControllerURL);
		assertEquals("rcv_register_csvmessage.ctl", registerCSVMessageControllerURLWithoutParsing);
	}
	
	@Test
	public void testGetRequestObject() {
		RegisterMessageRequest registerMessageRequest = UPMCApi.REGISTER_MESSAGE.getReqeustObject();
		RegisterCSVMessageRequest registerCSVMessageRequest = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getReqeustObject();

		assertTrue(registerMessageRequest instanceof RegisterMessageRequest);
		assertTrue(registerCSVMessageRequest instanceof RegisterCSVMessageRequest);
	}
	
	@Test
	public void testGetResponseObject() {
		MessageResponse registerMessageResponse = UPMCApi.REGISTER_MESSAGE.getResponseObject();
		MessageResponse registerCSVMessageResponse = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getResponseObject();
		
		assertTrue(registerMessageResponse instanceof MessageResponse && registerCSVMessageResponse instanceof MessageResponse);
	}
}
