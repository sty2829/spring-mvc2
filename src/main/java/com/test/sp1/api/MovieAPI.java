package com.test.sp1.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.sp1.xml.movie.Result;

@Component
public class MovieAPI {

	private static final Logger log = LoggerFactory.getLogger(MovieAPI.class);
	private final static String API_URI = "http://api.kcisa.kr/openapi/service/rest/convergence2017/conver3";
	private final static String KEY_NAME = "serviceKey";
	private final static String SERVICE_KEY = "c2222d02-8e16-4173-b0d1-5ede723513b3";
	
	@Autowired
	private ObjectMapper om;
	
	public Result getResult() {
		String json = getSourceString();
		Result result = null;
		try {
			result = om.readValue(json, Result.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public HttpURLConnection getHttpURLConnection() {
		String uri = API_URI + "?" + KEY_NAME + "=" + SERVICE_KEY;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(uri);
			conn = (HttpURLConnection)url.openConnection();
			return conn;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getSourceString() {
		HttpURLConnection conn = null;
		try {
			conn = getHttpURLConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json;charset=UTF-8");
			conn.setDoOutput(true);
			
			int status = conn.getResponseCode();
			
			StringBuilder sb = new StringBuilder();
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String str;
			while((str=br.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return "";
	}
	
	public static void main(String[] args) {
		MovieAPI movieAPI = new MovieAPI();
		Result result = movieAPI.getResult();
		System.out.println(result);
	}
}
