package com.multi.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:apiKey.properties")
public class OCRServiceImpl implements OCRService {

	
	@Value("${secretKey}")
	private String secretKey;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public String extractTextFromImage(String filePath) {
		log.info("secretKey={}",secretKey);
		log.info("apiUrl={}",apiUrl);
		//----------------------------------------------------
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "png"); // png, jpg 등 이미지 포맷 맞춰서 선택
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			
			String postParams = json.toString();
			System.out.println("postParams "+postParams);
			
			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(filePath);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response); // java로 parsing 해 보자
			
			//json 문자열로부터 내가 원하는 텍스트 문자만 추출하는 사용자 정의 메서드
			String text = myJsonToString(response.toString());
			return text;
			
			// return response.toString(); // json형태의 문자열
		} catch (Exception e) {
			System.out.println(e);
			return "error "+e.toString();
		}
		//----------------------------------------------------
		
	}//
	
	//json 문자열로부터 내가 원하는 텍스트 문자만 추출하는 사용자 정의 메서드
	private String myJsonToString(String jsonStr) {
		JSONObject jsonObj = new JSONObject(jsonStr); // org.json 라이브러리
		// 담아 주면 파싱이 더 쉬워짐 
	
		//images 키값 추출 => 배열 형태 images:[ {...fields:[]} ]
		JSONArray imagesArr = jsonObj.getJSONArray("images");
	
		//images 배열에 요소 1개 있으므로 index 0 지정해서 접근
		JSONObject imgObj =imagesArr.getJSONObject(0);
		
		JSONArray fieldsArr = imgObj.getJSONArray("fields");
		// images: [ { ... fields:[ {},{},{}, ... ] } ]
		String str = "";
		for(int i = 0; i<fieldsArr.length(); i++) {
			JSONObject obj = fieldsArr.getJSONObject(i);
			str += obj.getString("inferText")+"";
		}
		log.info("str={}", str);
		return str;
	}
	//--------------------------------------------------------
	private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	IOException {
	StringBuilder sb = new StringBuilder();
	sb.append("--").append(boundary).append("\r\n");
	sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
	sb.append(jsonMessage);
	sb.append("\r\n");

	out.write(sb.toString().getBytes("UTF-8"));
	out.flush();

	if (file != null && file.isFile()) {
		out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
		StringBuilder fileString = new StringBuilder();
		fileString
			.append("Content-Disposition:form-data; name=\"file\"; filename=");
		fileString.append("\"" + file.getName() + "\"\r\n");
		fileString.append("Content-Type: application/octet-stream\r\n\r\n");
		out.write(fileString.toString().getBytes("UTF-8"));
		out.flush();

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[8192];
			int count;
			while ((count = fis.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			out.write("\r\n".getBytes());
		}

		out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
	}
	out.flush();
}

}
