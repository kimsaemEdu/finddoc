package doc.find.member;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.ws.Response;

import org.apache.tiles.request.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;

import doc.find.login.LoginDTO;
import doc.find.login.LoginService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	LoginService loginService;

	// 회원가입 버튼 눌렀을때(사용자랑 병원관계자 둘다 이 메소드로 처리)
	@RequestMapping("/member/insert.do")
	public ModelAndView UserInsert(String action, UserDTO userdto, HadminDTO hadmindto) {
		ModelAndView mav = new ModelAndView();
		if (action.equals("user")) {
			// 성별 구하기
			int gender = Integer.parseInt(userdto.getSn2().substring(0, 1));
			if (gender == 1 || gender == 3) {
				userdto.setGender("m");
			} else {
				userdto.setGender("f");
			}
			// 나이 구하기
			Calendar cal = Calendar.getInstance();

			if (Integer.parseInt(userdto.getSn2().substring(0, 1)) == 1
					|| Integer.parseInt(userdto.getSn2().substring(0, 1)) == 2) {
				userdto.setAge(cal.get(Calendar.YEAR) - (Integer.parseInt(userdto.getSn1().substring(0, 2)) + 1900));
			} else {
				userdto.setAge(cal.get((Calendar.YEAR) - 2000) - Integer.parseInt(userdto.getSn1().substring(0, 2)));
			}
			memberService.insertUser(userdto);
			mav.setViewName("member/signupUser");
		} else {
			memberService.insertHadmin(hadmindto);
			mav.setViewName("member/signupDoc");
		}
		mav.addObject("result", "회원 가입 성공!");
		return mav;
	}

	/*
	 * // 메뉴에서 사용자 회원정보보기 버튼 눌렀을때
	 * 
	 * @RequestMapping("/member/updateUser.do") public String userUpdate(String
	 * action, HttpServletRequest req) { return "member/updateUser"; }
	 * 
	 * // 메뉴에서 병원관계자 회원정보수정 버튼 눌렀을때
	 * 
	 * @RequestMapping("/member/updateHadmin.do") public String docUpdate(String
	 * action, HttpServletRequest req) { return "member/updateHadmin"; }
	 */

	// 메뉴에서 사용자 회원정보수정 버튼 눌렀을때
	@RequestMapping("/member/updateUser.do")
	public String userUpdate(String action, HttpServletRequest req) throws Exception {
		return "member/updateUser";
	}

	// 메뉴에서 병원관계자 회원정보수정 버튼 눌렀을때
	@RequestMapping("/member/updateHadmin.do")
	public String docUpdate(String action, HttpServletRequest req) throws Exception {
		return "member/updateHadmin";
	}

	// 회원탈퇴 버튼 눌렀을때(사용자랑 병원관계자 둘다 이 메소드로 처리)
	@RequestMapping("/member/delete.do")
	public ModelAndView delete(String id, String pw, String action, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		LoginDTO logindto = new LoginDTO(id, pw, null, null);
		MemberDTO memberdto = loginService.login(action, logindto);
		if (memberdto == null) {
			mav.addObject("result", "비밀번호가 틀렸습니다.");
			mav.setViewName("member/delete");
		} else {
			memberService.delete(id, action);
			HttpSession ses = req.getSession(false);
			if (ses != null) {
				ses.invalidate();
			}
			mav.setViewName("login/login");
		}

		return mav;
	}

	// 회원가입할때 아이디 중복체크
	@RequestMapping(value = "/member/idcheck.do", method = RequestMethod.GET, produces = "application/text;charset=utf-8")
	public @ResponseBody String idcheck(String id) {

		String msg = "";

		if (memberService.idcheck(id) == true) {
			msg = "사용 가능";
		} else {
			msg = "사용 불가능";
		}
		return msg;
	}

	// 회원가입할때 이메일 중복체크
	@RequestMapping(value = "/member/emailcheck.do", method = RequestMethod.GET, produces = "application/text;charset=utf-8")
	public @ResponseBody String emailcheck(String email) {
		String msg = "";

		if (memberService.emailcheck(email) == true) {
			msg = "사용 가능";
		} else {
			msg = "사용 불가능";
		}
		return msg;
	}

	// 정보수정버튼눌렀을때(사용자,병원관계자 둘다처리)
	@RequestMapping("/member/update.do")
	public String update(String action, UserDTO userdto, HadminDTO hadmindto, HttpServletRequest req) throws Exception {
		int result = 0;
		if (action.equals("user")) {
			result = memberService.update(userdto, "user");
			if (result > 0) {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				return "login/login";
			} else {
				return "member/updateUser";
			}
		} else {
			result = memberService.update(hadmindto, "hadmin");
			if (result > 0) {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				return "login/login";
			} else {
				return "member/updateHadmin";
			}
		}

	}

	// 병원명 검색
	/*
	 * @RequestMapping(value = "member/hnameSearch.do", method = RequestMethod.GET,
	 * produces = "application/json;charset=utf-8")
	 */
	// 병원명 검색하면 팝업창으로 뜸
	@RequestMapping(value = "/member/hnameSearchPopup.do", method = RequestMethod.GET)
	public ModelAndView hanmeSearch(String hospname, String pageno, String rows, String haddr)
			throws IOException, Exception {
		ModelAndView mav = new ModelAndView();
		String result = "";
		if (haddr != null) {
			result = memberService.search(hospname, pageno, rows, haddr);
		} else {
			result = memberService.search(hospname, pageno, rows, "");
		}
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(result);
		JSONObject response = (JSONObject) object.get("response");
		JSONObject body = (JSONObject) response.get("body");
		String total = body.get("totalCount").toString();
		int totalnum = Integer.parseInt(total);
		int totPage = 0;
		if (totalnum % 10 == 0) {
			totPage = totalnum / 10;
		} else {
			totPage = (int) (Math.floor(totalnum / 10) + 1);
		}
		if (Integer.parseInt(pageno) > totPage) {
			if (haddr != null) {
				result = memberService.search(hospname, totPage + "", rows, haddr);
			} else {
				result = memberService.search(hospname, totPage + "", rows, "");
			}
			mav.addObject("pageno", totPage);

		} else {
			mav.addObject("pageno", pageno);
		}

		mav.addObject("haddr", haddr);
		mav.addObject("hospital", result);
		mav.setViewName("member/hnameSearchPopup");
		return mav;
	}

	/*
	 * // 병원명 검색하면 뜨는 팝업
	 * 
	 * @RequestMapping("member/hnameSearchPopup.do") public String
	 * hanmeSearchPopup() { return "member/hnameSearchPopup"; }
	 */
}
