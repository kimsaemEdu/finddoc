package doc.find.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import doc.find.member.UserDTO;

@Controller
public class bookController {
	@Autowired
	bookService service;
	
	// 예약 화면과 예약버튼 눌렀을때 둘다 처리
	@RequestMapping("/user/book.do")
	public ModelAndView user_book(String action, String hname, String ykiho, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/book");
		// 검색한 결과에서 예약 버튼눌렀을 때
		if (action.equals("search")) {
			mav.addObject("book", hname);
			mav.addObject("ykiho", ykiho);
		}
		// 자주가는 병원에서 예약버튼 눌렀을 때
		else if (action.equals("mypage")) {
			mav.addObject("book", hname);
			mav.addObject("ykiho", ykiho);
		}
		// 메인페이지나 탑메뉴의 예약버튼을 눌럿을 때
		else {
			mav.addObject("book", hname);
			mav.addObject("ykiho", ykiho);
		}
		return mav;
	}

	@RequestMapping("/user/insertbook.do")
	public ModelAndView userbook(BookDTO bookdto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		bookdto.setUserid(getid(req));
		String message=service.insertbook(bookdto);
		mav.setViewName("user/booklist");
		mav.addObject("message", message);
		return mav;
	}

	// 예약 목록
	@RequestMapping("/user/booklist.do")
	public String user_booklist() {
		return "user/booklist";
	}

	// 예약 상세 페이지
	@RequestMapping("/user/bookinfo.do")
	public String user_bookinfo(String action) {
		// 진료정보 링크 눌렀을때 예약 상세페이지
		if (action.equals("read")) {
			return "user/bookinfo";
			// 수정버튼 눌렀을때 수정 페이지로 이동
		} else {
			return "user/bookupdate";
		}
	}

	// 예약 수정
	@RequestMapping("/user/bookupdate.do")
	public String user_bookupdate() {
		return "user/booklist";
	}

	// 병원관계자 예약 목록
	@RequestMapping("/doc/booklist.do")
	public String doc_booklist() {
		return "doc/booklist";
	}

	// 로그인 세션
	public String getid(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		UserDTO loginuser = (UserDTO) ses.getAttribute("loginuser");
		String id = loginuser.getUserid();
		return id;
	}
}
