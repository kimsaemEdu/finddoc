package doc.find.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;

	@Override
	public int noticeinsert(Notice_BoardDTO noticedto) {
		return dao.noticeinsert(noticedto);
	}

	@Override
	public List<Notice_BoardDTO> noticelist(String id, String state) {
		List<Notice_BoardDTO> noticelist = null;
		String tag;
		if (state.equals("hadmin")) {
			tag = "finddoc.board.noticeall";
			noticelist = dao.noticelist(id, tag);
		} else {
			tag = "finddoc.board.noticeuserall";
			noticelist = dao.noticelist(id, tag);
		}
		return noticelist;
	}

	@Override
	public Notice_BoardDTO noticeread(String noticeboardnum) {
		dao.noticecount(noticeboardnum);
		Notice_BoardDTO dto = dao.noticeread(noticeboardnum);
		return dto;
	}

	@Override
	public int noticedelete(String noticeboardnum) {
		return dao.noticedelete(noticeboardnum);
	}

	@Override
	public int noticeupdate(Notice_BoardDTO noticedto) {
		return dao.noticeupdate(noticedto);
	}

	@Override
	public List<Notice_BoardDTO> noticesearch(String category, String search) {
		return dao.noticesearch(category, search);
	}

	@Override
	public int reviewinsert(Review_BoardDTO reviewdto) {
		return dao.reviewinsert(reviewdto);
	}

	@Override
	public List<Review_BoardDTO> reviewlist(String id, String state) {
		List<Review_BoardDTO> reviewlist = null;
		String tag;
		if (state.equals("user")) {
			tag = "finddoc.board.reviewuserall";
			reviewlist = dao.reviewlist(id, tag);
		} else {
			tag = "finddoc.board.reviewall";
			reviewlist = dao.reviewlist(id, tag);
		}
		return reviewlist;
	}

	@Override
	public List<Review_BoardDTO> reviewsearch(String category, String search) {
		return dao.reviewsearch(category, search);
	}

	@Override
	public List<Review_BoardDTO> reviewsearchhname(String category, String id) {
		return dao.reviewsearchhname(category, id);
	}
}
