package doc.find.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import doc.find.member.UserDTO;

@Controller
public class mypageController {
	@Autowired
	mypageService service;
	
	//자주가는 병원 목록보여주기
	@RequestMapping("/mypage/bookmark.do")
	public ModelAndView bookmarklist(HttpServletRequest req) {
		String id = getid(req);
		ModelAndView mav = new ModelAndView();
		List<MyhospitalDTO> bookmarklist = service.selectAll(id);
		mav.setViewName("mypage/bookmark");
		mav.addObject("bookmarklist", bookmarklist);
		return mav;
	}

	//자주가는 병원 등록
	@RequestMapping(value = "/mypage/insert_bookmark.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public @ResponseBody String bookmark(String ykiho,HttpServletRequest req){
		mypageDTO mypage = new mypageDTO();
		mypage.setUserid(getid(req));
		mypage.setYkiho(ykiho);
		String message = "";
		int result=service.insertbookmark(mypage);
		if(result==0) {
			message="이미 등록된 병원입니다.";
		}
		else {
			message="등록이 완료되었습니다.";
		}
		return message;
	}
	
	//자주가는 병원 삭제
	@RequestMapping(value="/mypage/delete_bookmark.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public @ResponseBody String delete_bookmark(String ykiho,HttpServletRequest req){
		mypageDTO mypage = new mypageDTO();
		mypage.setUserid(getid(req));
		mypage.setYkiho(ykiho);
		int result=service.deletebookmark(mypage);
		String message="";
		if(result>0) {
			message="삭제완료";
		}
		else {
			message="삭제실패";
		}
		return message;
	}
	
	//자주가는 병원검색
	@RequestMapping("/mypage/search_bookmark.do")
	public ModelAndView search(String tag, String search, HttpServletRequest req) {
		System.out.println("컨트롤러 들어옴");
		String id = getid(req);
		ModelAndView mav = new ModelAndView();
		List<MyhospitalDTO> searchlist = service.selectTag(tag,search, id);
		mav.addObject("bookmarklist", searchlist);
		mav.setViewName("mypage/bookmark");
		return mav;
	}

	//로그인 세션
	public String getid(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		UserDTO loginuser = (UserDTO) ses.getAttribute("loginuser");
		String id = loginuser.getUserid();
		return id;
	}
}
