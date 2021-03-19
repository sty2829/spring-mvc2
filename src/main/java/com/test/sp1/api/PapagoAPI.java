package com.test.sp1.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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

import com.test.sp1.entity.Papago;
import com.test.sp1.entity.papago.PapagoResult;

@Component
public class PapagoAPI {

	private static final Logger log = LoggerFactory.getLogger(PapagoAPI.class);
	private final static String API_URI = "https://openapi.naver.com/v1/papago/n2mt";
	private final static String ID_HEADER = "X-Naver-Client-Id";
	private final static String CLIENT_ID = "RaAL_JihfjXIzTIxHkys";
	private final static String SECRET_HEADER = "X-Naver-Client-Secret";
	private final static String CLIENT_SECRET = "MFGR8vSxas";
	
	@Autowired
	private ObjectMapper om;
	
	public PapagoResult getPapagoResult(Papago papago) {
		String json = getSourceString(papago);
		log.debug("json => {}", json);
		PapagoResult ppr = null;
		try {
			ppr = om.readValue(json, PapagoResult.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ppr;
	}
	
	public HttpURLConnection getHttpURLConnection() {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(API_URI);
			conn = (HttpURLConnection)url.openConnection();
			return conn;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getSourceString(Papago papago) {
		HttpURLConnection conn = null;
		try {
			conn = getHttpURLConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty(ID_HEADER, CLIENT_ID);
			conn.setRequestProperty(SECRET_HEADER, CLIENT_SECRET);
			conn.setDoOutput(true);
			
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			String param = "source=" + papago.getSource() + "&";
			param += "target=" + papago.getTarget() + "&";
			param += "text=" + papago.getText() + "&";
			param = param.substring(0, param.length()-1);
			log.debug("param => {}", param);
			dos.write(param.getBytes("UTF-8"));
			dos.flush();
			dos.close();
			
			int status = conn.getResponseCode();
			if(status == 200) {
				
			}
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
		PapagoAPI papagoAPI = new PapagoAPI();
		Papago papago = new Papago();
		papago.setSource("ko");
		papago.setTarget("en");
		papago.setText("사랑합니다");
		String str = papagoAPI.getSourceString(papago);
	}
	
}
