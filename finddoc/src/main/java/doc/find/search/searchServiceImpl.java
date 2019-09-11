package doc.find.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class searchServiceImpl implements searchService {
	
	//검색한 결과 페이징을 위한 메소드
	@Override
	public String search(String pageno, String loctxt, String hospname, String zipCd, String dgsbjtCd) throws IOException {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /*URL*/

	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D", "UTF-8")); /*서비스키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageno, "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("emdongNm","UTF-8") + "=" + URLEncoder.encode(loctxt, "UTF-8")); /*읍면동명*/
	        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode(hospname, "UTF-8")); /*병원명 (UTF-8 인코딩 필요)*/
	        urlBuilder.append("&" + URLEncoder.encode("zipCd","UTF-8") + "=" + URLEncoder.encode(zipCd, "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("dgsbjtCd","UTF-8") + "=" + URLEncoder.encode(dgsbjtCd, "UTF-8"));
	        urlBuilder.append("&_type=json");
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        return sb.toString();
	}
	
	//검색한 결과 모두 보여주는 메소드
	@Override
	public String searchAll(String loctxt, String hospname, String zipCd, String dgsbjtCd) throws IOException {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D", "UTF-8")); /*서비스키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50000", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("emdongNm","UTF-8") + "=" + URLEncoder.encode(loctxt, "UTF-8")); /*읍면동명*/
	        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode(hospname, "UTF-8")); /*병원명 (UTF-8 인코딩 필요)*/
	        urlBuilder.append("&" + URLEncoder.encode("zipCd","UTF-8") + "=" + URLEncoder.encode(zipCd, "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("dgsbjtCd","UTF-8") + "=" + URLEncoder.encode(dgsbjtCd, "UTF-8"));
	        urlBuilder.append("&_type=json");
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        return sb.toString();
	}

	//드래그한 결과 페이징을 위한 메소드
	@Override
	public String dragmap(String pageno, String xPos, String yPos, String radius) throws IOException {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /*URL*/
		 urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D", "UTF-8")); /*서비스키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageno, "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("xPos","UTF-8") + "=" + URLEncoder.encode(xPos, "UTF-8")); /*x좌표(소수점 15)*/
	        urlBuilder.append("&" + URLEncoder.encode("yPos","UTF-8") + "=" + URLEncoder.encode(yPos, "UTF-8")); /*y좌표(소수점 15)*/
	        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode(radius, "UTF-8")); /*단위 : 미터(m)*/
	        urlBuilder.append("&_type=json");
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
			return sb.toString();
	}
	
	//드래그한 결과 모두 보여주는 메소드
	@Override
	public String dragmapAll(String xPos, String yPos, String radius) throws IOException {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /*URL*/
		 urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D", "UTF-8")); /*서비스키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("xPos","UTF-8") + "=" + URLEncoder.encode(xPos, "UTF-8")); /*x좌표(소수점 15)*/
	        urlBuilder.append("&" + URLEncoder.encode("yPos","UTF-8") + "=" + URLEncoder.encode(yPos, "UTF-8")); /*y좌표(소수점 15)*/
	        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode(radius, "UTF-8")); /*단위 : 미터(m)*/
	        urlBuilder.append("&_type=json");
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
			return sb.toString();
	}

	@Override
	public String ykiho_detailinfo(String ykiho,String path) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/medicInsttDetailInfoService/"); /*URL*/
		urlBuilder.append(path);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=rtXyzvtNloEBJC0rtjlfRgr026JEgjNKDhOh%2F5VjvhYppyhbkbcuYDCxa7MDv1Ooc%2BuPCEezvaYRDHcEPls%2B6w%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("rtXyzvtNloEBJC0rtjlfRgr026JEgjNKDhOh%2F5VjvhYppyhbkbcuYDCxa7MDv1Ooc%2BuPCEezvaYRDHcEPls%2B6w%3D%3D", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("ykiho","UTF-8") + "=" + URLEncoder.encode(ykiho, "UTF-8")); /*암호화된 요양기호*/
        urlBuilder.append("&_type=json");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
	}
}
