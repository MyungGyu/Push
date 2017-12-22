package kr.co.uracle.push.http;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.api.UPMCApi;

public class TestRegisterMessageRequest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testToString() {
		RegisterMessageRequest registerMessageRequest = UPMCApi.REGISTER_MESSAGE.getReqeustObject();

		registerMessageRequest.setAuthKey("보안토큰");
		registerMessageRequest.setPsId("앱 ID");
		registerMessageRequest.setCuId("사용자 ID");
		registerMessageRequest.setMessage("PUSH 메시지");
		registerMessageRequest.setPriority("우선순위");
		registerMessageRequest.setBadgeNo("APNS전송만");
		registerMessageRequest.setReserveDate("YYYYMMDD HHMISS");
		registerMessageRequest.setServiceCode("서비스 매칭 코드");
		registerMessageRequest.setSoundFile("사운드 파일 명");
		registerMessageRequest.setExt("PUSH 부가 히든 메시지");
		registerMessageRequest.setSenderCode("메시지 구분 코드");
		registerMessageRequest.setAppId("어플리케이션 식별 정보");
		registerMessageRequest.setType("발송타입");
		registerMessageRequest.setDbIn("성공메시지 저장");
		registerMessageRequest.setSplitMsgCnt("분할 발송 메시지 건수");
		registerMessageRequest.setDelaySecond("분할 발송 지연 시간");

		String toString = registerMessageRequest.toString();

		logger.debug(toString);

		assertNotNull(toString);
	}

}
