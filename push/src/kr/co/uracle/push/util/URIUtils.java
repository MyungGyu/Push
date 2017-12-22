package kr.co.uracle.push.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

import kr.co.uracle.push.api.UPMCApi;
import kr.co.uracle.push.http.RegisterMessageRequest;
import kr.co.uracle.push.http.annotation.Require;

public class URIUtils {

	private static final String ARRAY_BRACKET = "[]";
	private static final String EQUALSIGN = "=";
	private static final String SEPARATOR = "&";
	
	public static String parseURI (Object target, boolean isEncoded) {
		List<String> parseURI = new ArrayList<>();

		Field[] fields = target.getClass().getDeclaredFields();

		for(Field field : fields) {
			String fieldName = getSerializedName(field);
			Object fieldValue = getValue(field, target);
			if(fieldValue != null || isRequire(field)) {
				fieldValue = fieldValue != null ? fieldValue : "";
				fieldValue = isEncoded ? encodeURIComponent(String.valueOf(fieldValue)) : fieldValue;
				parseURI.add(new StringBuffer().append(fieldName).append(EQUALSIGN).append(fieldValue).toString());
			}
		}
		
		return StringUtils.join(parseURI, SEPARATOR);
	}
	
	private static Object getValue (Field field, Object target) {
		for(Method method : target.getClass().getMethods()) {
			String methodName = method.getName();
			if(methodName.startsWith("get") 
					&& methodName.endsWith(StringUtils.capitalize(field.getName()))) {
				try {
					return method.invoke(target);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static String getSerializedName (Field field) {
		SerializedName serializedName = field.getAnnotation(SerializedName.class);
		return serializedName != null ? serializedName.value() : field.getName();
	}
	
	private static boolean isRequire (Field field) {
		return field.getAnnotation(Require.class) != null;
	}
	
	private static String encodeURIComponent (String parameters) {		
		String result = "";
		try {
			result = replace(URLEncoder.encode(parameters, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static String replace (String encodedString) {
		return encodedString.replaceAll("\\+", "%20")
						    .replaceAll("\\%21", "!")
						    .replaceAll("\\%27", "'")
						    .replaceAll("\\%28", "(")
						    .replaceAll("\\%29", ")")
						    .replaceAll("\\%7E", "~");
	}
	
	public static void main(String[] args) {

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
		
		System.out.println(parseURI(registerMessageRequest, true));
		
		return;
	}
}
