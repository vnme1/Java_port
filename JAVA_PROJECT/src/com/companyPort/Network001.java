package com.companyPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network001 {
	public static void main(String[] args) {
		try {
			//1. URL객체얻기
			URL url = new URL("https://www.google.com/");
			// 부모 = 자식 업캐스팅/타입캐스팅 필요x
			// 자식 = 부모 다운캐스팅/타입캐스팅 필요o
			
			//				   자식						 부모
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//2. 연결객체(HttpURLConnection)
			//3. 요청메서드 설정
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setReadTimeout(1000); //1000 -> 1초
			conn.setRequestMethod("GET"); //주소표시창에 데이터 노출
			
			//4. 응답코드 - 200
			//System.out.println(conn.getResponseCode());
			int code =conn.getResponseCode();
			
			//5. 응답데이터
			BufferedReader br;
			if(code == 200) {
				br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else { //에러 발생시
				br= new BufferedReader(new InputStreamReader(conn.getInputStream()));	
			}
			
			String line=""; StringBuffer sb = new StringBuffer();
			while((line=br.readLine()) != null) { sb.append(line+"\n"); }
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
			
		} catch (Exception e) { e.printStackTrace(); }
	}
}

