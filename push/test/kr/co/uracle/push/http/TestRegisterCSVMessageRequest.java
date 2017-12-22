package kr.co.uracle.push.http;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.uracle.push.api.UPMCApi;

public class TestRegisterCSVMessageRequest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testToString() {
		RegisterCSVMessageRequest registerCSVMessageRequest = UPMCApi.REGISTER_MESSAGE_WITH_CSV.getReqeustObject();

		registerCSVMessageRequest.setAuthKey("보안토큰");
		registerCSVMessageRequest.setPsId("앱ID");
		registerCSVMessageRequest.setGroupSeq("그룹 시퀀스 번호");
		registerCSVMessageRequest.setMessage("PUSH 메시지");
		registerCSVMessageRequest.setPriority("우선순위");
		registerCSVMessageRequest.setBadgeNo("APNS전송만");
		registerCSVMessageRequest.setReserveDate("YYYYMMDD HHMISS");
		registerCSVMessageRequest.setServiceCode("PUSH 서비스 매칭 코드");
		registerCSVMessageRequest.setSoundFile("사운드 파일 명");
		registerCSVMessageRequest.setExt("PUSH 부가 히든 메시지");
		registerCSVMessageRequest.setSenderCode("메시지 구분 코드");
		registerCSVMessageRequest.setAppId("어플리케이션 식별 정보");
		registerCSVMessageRequest.setType("발송타입");
		registerCSVMessageRequest.setDbIn("성공 메시지 저장");
		registerCSVMessageRequest.setSplitMsgCnt("분할 발송 메시지 건수");
		registerCSVMessageRequest.setDelaySecond("분할 발송 지연 시간");
		registerCSVMessageRequest.setUploadFile("업로드 파일");

		String toString = registerCSVMessageRequest.toString();

		logger.debug(toString);

		assertNotNull(toString);
	}
}
