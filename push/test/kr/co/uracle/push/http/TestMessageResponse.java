package kr.co.uracle.push.http;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.uracle.push.api.UPMCApi;
import kr.co.uracle.push.http.MessageResponse.MessageResponseBody;
import kr.co.uracle.push.http.MessageResponse.MessageResponseHeader;

public class TestMessageResponse {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testToString() {
		MessageResponse registerMessageResponse = UPMCApi.REGISTER_MESSAGE.getResponseObject();
		MessageResponse registerCSVMessageResponse = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getResponseObject();

		MessageResponseHeader registerMessageResponseHeader = new MessageResponseHeader();
		registerMessageResponseHeader.setResultCode("0000");
		registerMessageResponseHeader.setResultBody("OK");
		registerMessageResponseHeader.setService("rcv_register_message");

		MessageResponseBody registerMessageResponseBody = new MessageResponseBody();
		registerMessageResponseBody.setReserveSeqNo("발송 메시지 고유 번호");

		registerMessageResponse.setHeader(registerMessageResponseHeader);
		registerMessageResponse.setBody(registerMessageResponseBody);

		String result1 = registerMessageResponse.toString();

		logger.debug(result1);

		assertNotNull(result1);

		MessageResponseHeader registerCSVMessageResponseHeader = new MessageResponseHeader();
		registerCSVMessageResponseHeader.setResultCode("0000");
		registerCSVMessageResponseHeader.setResultBody("OK");
		registerCSVMessageResponseHeader.setService("rcv_register_csvmessage");

		MessageResponseBody registerCSVMessageResponseBody = new MessageResponseBody();
		registerCSVMessageResponseBody.setSendMsgSeqNo("발송 메시지 고유 번호");
		registerCSVMessageResponseBody.setRegSuccessCnt("10");
		registerCSVMessageResponseBody.setRegFailCnt("0");
		registerCSVMessageResponseBody.setUpns("0");
		registerCSVMessageResponseBody.setApns("0");
		registerCSVMessageResponseBody.setGcm("0");
		registerCSVMessageResponseBody.setHostUrl("localhost");

		registerCSVMessageResponse.setHeader(registerCSVMessageResponseHeader);
		registerCSVMessageResponse.setBody(registerCSVMessageResponseBody);

		String result2 = registerCSVMessageResponse.toString();

		logger.debug(result2);

		assertNotNull(result2);
	}

	@Test
	public void testSerializeJSON() {

	}

	@Test
	public void testDeserializeJSON() {
		String registerMessageResponseJSON = "{\"HEADER\":{\"RESULT_CODE\":\"0000\", \"RESULT_BODY\":\"OK\"},\"BODY\":{\"RESERVE_SEQNO\":\"20\"}}";
		String registerCSVMessageResponseJSON = "{\"BODY\":{\"APNS\":\"0\",\"REG_SUCCESS_CNT\":\"1\",\"UPNS\":\"1\",\"REG_FAIL_CNT\":\"0\",\"GCM\":\"0\",\"SENDMSG_SEQNO\":\"1151\",\"HOST_URL\":\"\"},\"HEADER\":{\"RESULT_CODE\":\"0000\",\"RESULT_BODY\":\"OK\"}}";
		
		Gson gson = new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.IDENTITY).create();
		
		MessageResponse registerMessageResponse = gson.fromJson(registerMessageResponseJSON, MessageResponse.class);
		MessageResponse registerCSVMessageResponse = gson.fromJson(registerCSVMessageResponseJSON, MessageResponse.class);
		
		String result1 = registerMessageResponse.toString();
		String result2 = registerCSVMessageResponse.toString();
		
		logger.debug(result1);
		logger.debug(result2);
		
		assertNotNull(result1);
		assertNotNull(result2);
	}
}
