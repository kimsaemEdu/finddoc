package doc.find.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import doc.find.member.HadminDTO;
import doc.find.member.MemberDTO;

@Controller
public class adminController {
	@Autowired
	adminService service;

	// 관리자 승인 대기 병원목록 화면
	@RequestMapping("/admin/accept_list.do")
	public ModelAndView accept_list() {
		ModelAndView mav = new ModelAndView();
		List<HadminDTO> acceptlist = service.acceptlist();
		mav.setViewName("admin/accept_list");
		mav.addObject("acceptlist", acceptlist);
		return mav;
	}

	// 관리자 병원 승인한 병원목록 화면
	@RequestMapping("admin/hos_list.do")
	public ModelAndView hos_list(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		List<HadminDTO> hoslist= service.listAll();
		mav.addObject("hoslist", hoslist);
		mav.setViewName("admin/hos_list");
		return mav;
	}
	
	// 병원 승인
	@RequestMapping(value="admin/accept_hospital.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public @ResponseBody String hos_accept(String hadminid) {
		System.out.println(hadminid);
		int result = service.accept(hadminid);
		String str="";
		if(result>0) {
			str="승인완료";
		}
		else {
			str="승인오류";
		}
		return str;
	}
	
	//승인된 병원 검색
	@RequestMapping("/admin/acceptsearch.do")
	public ModelAndView searchAll(String tag, String search) {
		ModelAndView mav = new ModelAndView();
		List<HadminDTO> searchresult = service.searchAll(tag, search);
		mav.addObject("hoslist", searchresult);
		mav.setViewName("admin/hos_list");
		return mav;
	}

	// 관리자 1:1문의 게시판 목록 화면
	@RequestMapping("/admin/oneboardlist.do")
	public ModelAndView oneboardlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/oneboardlist");
		return mav;
	}

	// 관리자 1:1문의 게시판 글등록 화면
	@RequestMapping("/admin/oneboard_write.do")
	public ModelAndView oneboardwrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/oneboard_write");
		return mav;
	}
	
	// 첫 화면 페이지
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}

	// 관리자 화면
	@RequestMapping("/admin.do")
	public String admin() {
		return "admin";
	}
}
