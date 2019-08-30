package doc.find.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import doc.find.member.HadminDTO;
import doc.find.member.MemberDTO;
import doc.find.member.UserDTO;
import oracle.net.aso.n;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	// 후기 게시판
	@RequestMapping("/board/reviewBoardList.do")
	public ModelAndView review(String category) {
		ModelAndView mav = new ModelAndView();
		if (category.equals("all")) {
			mav.setViewName("board/reviewBoardList");
		}
		return mav;
	}

	// 후기 게시판 글등록버튼 눌렀을때
	@RequestMapping("/board/reviewBoard_insert.do")
	public ModelAndView reviewInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/reviewBoardList");
		return mav;
	}

	// Q&A 게시판
	@RequestMapping("/board/qaBoardList.do")
	public ModelAndView qa(String category) {
		ModelAndView mav = new ModelAndView();
		if (category.equals("all")) {
			mav.setViewName("board/qaBoardList");
		}
		return mav;
	}

	// Q&A 게시판 글등록버튼 눌렀을때
	@RequestMapping("/board/qaBoard_insert.do")
	public ModelAndView qaInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/qaBoardList");
		return mav;
	}

	// 공지사항 게시판
	@RequestMapping("/board/noticeBoardList.do")
	public ModelAndView notice(HttpServletRequest req, String category) {
		ModelAndView mav = new ModelAndView();
		HttpSession ses = req.getSession(false);
		MemberDTO memberdto = null;
		List<Notice_BoardDTO> noticelist = null;

		if (ses != null) {
			memberdto = (MemberDTO) ses.getAttribute("loginuser");
		}
		if (memberdto instanceof UserDTO) {
			UserDTO userdto = (UserDTO) memberdto;
			if (category.equals("all")) {
				noticelist = boardService.noticelist(userdto.getUserid(), "user");
			}

		} else {
			HadminDTO hadmindto = (HadminDTO) memberdto;
			noticelist = boardService.noticelist(hadmindto.getHadminid(), "hadmin");
		}

		mav.addObject("noticelist", noticelist);
		mav.setViewName("board/noticeBoardList");
		return mav;
	}

	// 공지사항 글눌러서 read화면으로 이동
	@RequestMapping("/board/noticeBoard_read.do")
	public ModelAndView noticeRead(String noticeboardnum, String hname, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		Notice_BoardDTO noticeread = boardService.noticeread(noticeboardnum);
		mav.addObject("noticeread", noticeread);
		mav.setViewName("board/noticeBoard_Read");
		return mav;
	}

	// 공지사항 게시판 글삭제
	@RequestMapping("/board/noticeBoard_delete.do")
	public String noticeDelete(String noticeboardnum) {
		boardService.noticedelete(noticeboardnum);
		return "redirect:/board/noticeBoardList.do";
	}

	// 공지사항 게시판 카테고리별로 검색
	@RequestMapping("/board/noticeBoard_search.do")
	public ModelAndView noticeSearch(String category, String search, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession ses = req.getSession(false);
		MemberDTO memberdto = null;
		HadminDTO hadmindto = null;
		UserDTO userdto = null;
		List<Notice_BoardDTO> noticelist = null;

		if (ses != null) {
			memberdto = (MemberDTO) ses.getAttribute("loginuser");
		}

		if (memberdto.getState().equals("hadmin")) {
			hadmindto = (HadminDTO) memberdto;
		} else {
			userdto = (UserDTO) memberdto;
		}

		if (search != "") {
			noticelist = boardService.noticesearch(category, search);
		} else {
			noticelist = boardService.noticelist(hadmindto.getHadminid(), "hadmin");
		}
		mav.addObject("noticelist", noticelist);
		mav.setViewName("board/noticeBoardList");
		return mav;
	}

	// 공지사항 게시판 글수정
	@RequestMapping("/board/noticeBoard_update.do")
	public ModelAndView noticeUpdate(String noticeboardnum, String action, String hname, String title, String text) {
		ModelAndView mav = new ModelAndView();
		Notice_BoardDTO notice = boardService.noticeread(noticeboardnum);
		if (action.equals("read")) {
			mav.addObject("notice", notice);
			mav.setViewName("board/noticeBoard_Update");
		} else {
			notice.setTitle(title);
			notice.setText(text);
			boardService.noticeupdate(notice);
			mav.setViewName("redirect:/board/noticeBoardList.do");
		}
		return mav;
	}

	// 공시사항 게시판 글등록버튼 눌렀을때
	@RequestMapping("/board/noticeBoard_insert.do")
	public ModelAndView noticeInsert(Notice_BoardDTO noticedto) {
		ModelAndView mav = new ModelAndView();
		boardService.noticeinsert(noticedto);
		mav.setViewName("redirect:/board/noticeBoardList.do");
		return mav;
	}
}
