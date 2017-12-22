package kr.co.uracle.push.api;

import kr.co.uracle.push.http.MessageResponse;
import kr.co.uracle.push.http.RegisterCSVMessageRequest;
import kr.co.uracle.push.http.RegisterMessageRequest;
import kr.co.uracle.push.util.PushConfiguration;

public enum UPMCApi {

	REGISTER_MESSAGE {
		private String controllerURL = "rcv_register_message.ctl";
		
		@Override
		public String getControllerURL() {
			return getControllerURL(true);
		}
		
		@Override
		public String getControllerURL(boolean isParse) {
			return isParse ? parseHTTPURL(controllerURL) : controllerURL;
		}

		@Override
		@SuppressWarnings("unchecked")
		public RegisterMessageRequest getReqeustObject() {
			return new RegisterMessageRequest();
		}
	},

	REGISTER_MESSAGE_WITH_CSV {
		private String controllerURL = "rcv_register_csvmessage.ctl";
		
		@Override
		public String getControllerURL() {
			return getControllerURL(true);
		}
		
		@Override
		public String getControllerURL(boolean isParse) {
			return isParse ? parseHTTPURL(controllerURL) : controllerURL;
		}

		@Override
		@SuppressWarnings("unchecked")
		public RegisterCSVMessageRequest getReqeustObject() {
			return new RegisterCSVMessageRequest();
		}
	};

	private static final String receiverIP = PushConfiguration.get("push.receiver.ip");
	private static final String receiverPort = PushConfiguration.get("push.receiver.port");

	static String parseHTTPURL(String controllerURL) {
		return new StringBuffer().append("http://").append(receiverIP).append(":").append(receiverPort).append("/")
				.append(controllerURL).toString();
	}

	public abstract String getControllerURL();
	
	public abstract String getControllerURL(boolean isParse);

	public abstract <T> T getReqeustObject();

	public MessageResponse getResponseObject() {
		return new MessageResponse();
	}
}
