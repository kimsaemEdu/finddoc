package doc.find.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;

	@Override
	public int insertUser(UserDTO userdto) {
		return dao.insertUser(userdto);
	}

	@Override
	public int insertHadmin(HadminDTO hadmindto) {
		int result=0;
		int resulth=dao.insertHadmin(hadmindto);
		int resulta=dao.insertAdmin_app(hadmindto.getHadminid());
		if(resulth>0) {
			result=1;
		}
		return result;
	}

	@Override
	public boolean idcheck(String id) {
		String tag1, tag2, tag3;
		tag1 = "finddoc.member.idcheckUser";
		tag2 = "finddoc.member.idcheckHadmin";
		tag3 = "finddoc.member.idcheckAdmin";
		if (dao.idcheck(id, tag1) != null) {
			return false;
		} else if (dao.idcheck(id, tag2) != null) {
			return false;
		} else if (dao.idcheck(id, tag3) != null) {
			return false;
		}
		return true;
	}

	@Override
	public int update(MemberDTO memberdto, String action) {
		String tag;
		if (action.equals("user")) {
			tag = "finddoc.member.updateUser";
			return dao.update(memberdto, tag);
		} else {
			tag = "finddoc.member.updateHadmin";
			return dao.update(memberdto, tag);
		}
	}

	@Override
	public String search(String hospname, String pageno, String rows, String haddr) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(
				"EcZBFp8riC1kWptGZdp7ZikCotqiO6vy18vQdIuWjG%2FeOrxS4y6VR6i0dUv0vFBCLaFg6eOE4exgXOOBIC8Dmw%3D%3D",
				"UTF-8")); /* 서비스키 */
		urlBuilder.append("&" + URLEncoder.encode("yadmNm", "UTF-8") + "="
				+ URLEncoder.encode(hospname, "UTF-8")); /* 병원명 (UTF-8 인코딩 필요) */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageno, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(rows, "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("emdongNm", "UTF-8") + "=" + URLEncoder.encode(haddr, "UTF-8")); /* 읍면동명 */
		urlBuilder.append("&_type=json");
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
	public int delete(String id, String action) {
		String tag;
		if (action.equals("user")) {
			tag = "finddoc.member.deleteUser";
		} else {
			tag = "finddoc.member.deleteHadmin";
		}
		return dao.delete(id, tag);
	}

	@Override
	public boolean emailcheck(String email) {
		String tag1, tag2;
		tag1 = "finddoc.member.emailcheckUser";
		tag2 = "finddoc.member.emailcheckHadmin";
		if (dao.idcheck(email, tag1) != null) {
			return false;
		} else if (dao.idcheck(email, tag2) != null) {
			return false;
		}
		return true;
	}

}
