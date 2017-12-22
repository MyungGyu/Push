package kr.co.uracle.push.util;

import java.io.IOException;
import java.util.Properties;

public class PushConfiguration {

	private static Properties pushConfiguration;

	private PushConfiguration() {
	}

	public static String get(String key) {
		return pushConfiguration.getProperty(key);
	}

	public static int getInteger(String key) {
		return Integer.parseInt(get(key));
	}

	static {
		String path = "/kr/co/uracle/config/config.properties";

		if (pushConfiguration == null) {
			pushConfiguration = new Properties();
			try {
				pushConfiguration.load(PushConfiguration.class.getResourceAsStream(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
