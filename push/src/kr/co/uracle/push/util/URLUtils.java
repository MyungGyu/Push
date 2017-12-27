package kr.co.uracle.push.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import kr.co.uracle.push.http.MessageResponse;
import kr.co.uracle.push.http.annotation.Require;

public class URLUtils {

	private String url;
	private Header[] headers;
	private List<NameValuePair> nameValuePairs;
	private HttpResponse response;
	private StatusLine statusLine;

	public URLUtils(String url) {
		this.url = url;
		this.nameValuePairs = new ArrayList<>();
	}

	public URLUtils setHeaders(Header... headers) {
		this.headers = headers;
		return this;
	}

	private boolean send(HttpUriRequest request) {
		try {
			response = HttpClientBuilder.create().build().execute(request);
			statusLine = response.getStatusLine();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean sendGet() {
		HttpGet get = new HttpGet(
				new StringBuffer()
				.append(this.url)
				.append(URLEncodedUtils.format(this.nameValuePairs, Consts.UTF_8))
				.toString());

		get.setHeaders(this.headers);

		return send(get);
	}

	public boolean sendPost() {
		HttpPost post = new HttpPost(this.url);
		post.setHeaders(this.headers);
		post.setEntity(new UrlEncodedFormEntity(this.nameValuePairs, Consts.UTF_8));

		return send(post);
	}

	public int getStatusCode() {
		return statusLine.getStatusCode();
	}

	public MessageResponse getResponse() {
		Gson gson = new GsonBuilder().create();
		HttpEntity httpEntity = response.getEntity();

		MessageResponse messageResponse = null;
		
		try (Reader reader = new InputStreamReader(httpEntity.getContent(), Consts.UTF_8)) {
			System.out.println(EntityUtils.toString(httpEntity));
			messageResponse = gson.fromJson(reader, MessageResponse.class);
		} catch (JsonSyntaxException | JsonIOException | UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		
		return messageResponse;
	}

	public URLUtils setUrlEncodedFormEntity(Object target) {
		for(Field field : target.getClass().getDeclaredFields()) {
			String name = getSerializedName(field);
			String value = StringUtils.defaultString(getValue(field, target));

			if(!"".equals(value) || isRequire(field)) {
				nameValuePairs.add(new BasicNameValuePair(name, value));
			}
		}

		return this;
	}

	private String getValue(Field field, Object target) {
		for (Method method : target.getClass().getMethods()) {
			String methodName = method.getName();
			if (methodName.startsWith("get") && methodName.endsWith(StringUtils.capitalize(field.getName()))) {
				try {
					return (String) method.invoke(target);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private boolean isRequire(Field field) {
		return field.getAnnotation(Require.class) != null;
	}

	private String getSerializedName(Field field) {
		SerializedName serializedName = field.getAnnotation(SerializedName.class);
		return serializedName != null ? serializedName.value() : field.getName();
	}

	/*
	private String encodeURIComponent(String parameters) {
		String result = "";
		try {
			//result = replace(URLEncoder.encode(parameters, "UTF-8"));
			result = URLEncoder.encode(parameters, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String replace(String encodedString) {
		return encodedString.replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'")
							.replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
	}
	*/
}
