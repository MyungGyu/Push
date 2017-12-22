package kr.co.uracle.push.http;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 20171220L;

	public static class MessageResponseHeader {

		@SerializedName("RESULT_CODE")
		private String resultCode;
		
		@SerializedName("RESULT_BODY")
		private String resultBody;
		
		@SerializedName("SERVICE")
		private String service;

		public String getResultCode() {
			return resultCode;
		}

		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}

		public String getResultBody() {
			return resultBody;
		}

		public void setResultBody(String resultBody) {
			this.resultBody = resultBody;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
		}
	}

	public static class MessageResponseBody {
		
		@SerializedName("RESERVE_SEQNO")
		private String reserveSeqNo;
		
		@SerializedName("SENDMSG_SEQNO")
		private String sendMsgSeqNo;
		
		@SerializedName("REG_SUCCESS_CNT")
		private String regSuccessCnt;
		
		@SerializedName("REG_FAIL_CNT")
		private String regFailCnt;
		
		@SerializedName("UPNS")
		private String upns;
		
		@SerializedName("APNS")
		private String apns;
		
		@SerializedName("GCM")
		private String gcm;
		
		@SerializedName("HOST_URL")
		private String hostUrl;

		public String getReserveSeqNo() {
			return reserveSeqNo;
		}

		public void setReserveSeqNo(String reserveSeqNo) {
			this.reserveSeqNo = reserveSeqNo;
		}

		public String getSendMsgSeqNo() {
			return sendMsgSeqNo;
		}

		public void setSendMsgSeqNo(String sendMsgSeqNo) {
			this.sendMsgSeqNo = sendMsgSeqNo;
		}

		public String getRegSuccessCnt() {
			return regSuccessCnt;
		}

		public void setRegSuccessCnt(String regSuccessCnt) {
			this.regSuccessCnt = regSuccessCnt;
		}

		public String getRegFailCnt() {
			return regFailCnt;
		}

		public void setRegFailCnt(String regFailCnt) {
			this.regFailCnt = regFailCnt;
		}

		public String getUpns() {
			return upns;
		}

		public void setUpns(String upns) {
			this.upns = upns;
		}

		public String getApns() {
			return apns;
		}

		public void setApns(String apns) {
			this.apns = apns;
		}

		public String getGcm() {
			return gcm;
		}

		public void setGcm(String gcm) {
			this.gcm = gcm;
		}

		public String getHostUrl() {
			return hostUrl;
		}

		public void setHostUrl(String hostUrl) {
			this.hostUrl = hostUrl;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
		}
	}

	@SerializedName("HEADER")
	private MessageResponseHeader header;
	
	@SerializedName("BODY")
	private MessageResponseBody body;

	public MessageResponseHeader getHeader() {
		return header;
	}

	public void setHeader(MessageResponseHeader header) {
		this.header = header;
	}

	public MessageResponseBody getBody() {
		return body;
	}

	public void setBody(MessageResponseBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
