package kr.co.uracle.push.http;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

import kr.co.uracle.push.http.annotation.Require;

public class RegisterCSVMessageRequest implements Serializable {

	private static final long serialVersionUID = 20171220L;

	@SerializedName("AUTHKEY")
	private String authKey;

	@SerializedName("PSID")
	private String psId;

	@Require
	@SerializedName("TYPE")
	private String type;

	@Require
	@SerializedName("GROUPSEQ")
	private String groupSeq;

	@Require
	@SerializedName("MESSAGE")
	private String message;

	@Require
	@SerializedName("PRIORITY")
	private String priority;

	@Require
	@SerializedName("BADGENO")
	private String badgeNo;

	@Require
	@SerializedName("RESERVEDATE")
	private String reserveDate;

	@Require
	@SerializedName("SERVICECODE")
	private String serviceCode;

	@Require
	@SerializedName("SOUNDFILE")
	private String soundFile;

	@SerializedName("EXT")
	private String ext;

	@Require
	@SerializedName("SENDERCODE")
	private String senderCode;

	@Require
	@SerializedName("APP_ID")
	private String appId;

	@SerializedName("DB_IN")
	private String dbIn;

	// MULTIPART 고려
	// 수정해야됨
	@Require
	@SerializedName("upload_file")
	private String uploadFile;

	@SerializedName("SPLIT_MSG_CNT")
	private String splitMsgCnt;

	@SerializedName("DELAY_SECOND")
	private String delaySecond;

	@SerializedName("SEND_TIME_LIMIT")
	private String sendTimeLimit;

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getPsId() {
		return psId;
	}

	public void setPsId(String psId) {
		this.psId = psId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(String groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getBadgeNo() {
		return badgeNo;
	}

	public void setBadgeNo(String badgeNo) {
		this.badgeNo = badgeNo;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getSoundFile() {
		return soundFile;
	}

	public void setSoundFile(String soundFile) {
		this.soundFile = soundFile;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSenderCode() {
		return senderCode;
	}

	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDbIn() {
		return dbIn;
	}

	public void setDbIn(String dbIn) {
		this.dbIn = dbIn;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getSplitMsgCnt() {
		return splitMsgCnt;
	}

	public void setSplitMsgCnt(String splitMsgCnt) {
		this.splitMsgCnt = splitMsgCnt;
	}

	public String getDelaySecond() {
		return delaySecond;
	}

	public void setDelaySecond(String delaySecond) {
		this.delaySecond = delaySecond;
	}

	public String getSendTimeLimit() {
		return sendTimeLimit;
	}

	public void setSendTimeLimit(String sendTimeLimit) {
		this.sendTimeLimit = sendTimeLimit;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
