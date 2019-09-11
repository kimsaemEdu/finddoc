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
	public List<Notice_BoardDTO> noticelist(String id, String state, int startIndex) {
		List<Notice_BoardDTO> noticelist = null;
		String tag;
		if (state.equals("hadmin")) {
			tag = "finddoc.board.noticeall";
			noticelist = dao.noticelist(id, tag, startIndex);
		} else {
			tag = "finddoc.board.noticeuserall";
			noticelist = dao.noticelist(id, tag, startIndex);
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
	public List<Notice_BoardDTO> noticesearch(String id, String category, String search, String state, String hadminid,
			int startIndex) {
		List<Notice_BoardDTO> noticelist = null;
		String tag;
		if (search == "") {
			if (state.equals("hadmin")) {
				tag = "finddoc.board.noticeall";
				noticelist = dao.noticelist(id, tag, startIndex);
			} else {
				tag = "finddoc.board.noticeuserall";
				noticelist = dao.noticelist(id, tag, startIndex);
			}
			return noticelist;
		} else {
			if (state.equals("user")) {
				if (hadminid.equals("all")) {
					tag = "finddoc.board.noticesearch";
					noticelist = dao.noticesearch(tag, id, category, search, hadminid, startIndex);
				} else {
					tag = "finddoc.board.noticesearcheach";
					noticelist = dao.noticesearch(tag, id, category, search, hadminid, startIndex);
				}
				return noticelist;
			} else {
				tag = "finddoc.board.noticesearcheach";
				noticelist = dao.noticesearch(tag, id, category, search, hadminid, startIndex);
				return noticelist;
			}
		}
	}

	@Override
	public List<Notice_BoardDTO> noticesearchcount(String id, String category, String search, String state,
			String hadminid) {
		List<Notice_BoardDTO> noticelist = null;
		String tag;
		if (search == "") {
			if (state.equals("hadmin")) {
				tag = "finddoc.board.noticeallcount";
				noticelist = dao.noticelist(id, tag, 0);
			} else {
				tag = "finddoc.board.noticeuserallcount";
				noticelist = dao.noticelist(id, tag, 0);
			}
			return noticelist;
		} else {
			if (hadminid.equals("all")) {
				tag = "finddoc.board.noticesearchcount";
				noticelist = dao.noticesearchcount(tag, id, category, search, hadminid);
			} else {
				tag = "finddoc.board.noticesearcheachcount";
				noticelist = dao.noticesearchcount(tag, id, category, search, hadminid);
			}

			return noticelist;
		}
	}

	@Override
	public int reviewinsert(Review_BoardDTO reviewdto) {
		return dao.reviewinsert(reviewdto);
	}

	@Override
	public List<Review_BoardDTO> reviewlist(String id, String state, int startIndex) {
		List<Review_BoardDTO> reviewlist = null;
		String tag;
		if (state.equals("user")) {
			tag = "finddoc.board.reviewuserall";
			reviewlist = dao.reviewlist(id, tag, startIndex);
		} else {
			tag = "finddoc.board.reviewall";
			reviewlist = dao.reviewlist(id, tag, startIndex);
		}
		return reviewlist;
	}

	@Override
	public List<Review_BoardDTO> reviewsearch(String category, String search, int startIndex) {
		return dao.reviewsearch(category, search, startIndex);
	}

	@Override
	public List<Review_BoardDTO> reviewsearchhname(String category, String id, int startIndex) {
		if (category.equals("전체")) {
			String tag = "finddoc.board.reviewuserall";
			return dao.reviewlist(id, tag, startIndex);
		}
		return dao.reviewsearchhname(category, id, startIndex);
	}

	@Override
	public int noticeCount(String id, String state) {
		List<Notice_BoardDTO> noticelist = null;
		String tag;
		int result = 0;
		if (state.equals("hadmin")) {
			tag = "finddoc.board.noticeCount";
			result = dao.noticeCount(id, tag);
		} else {
			tag = "finddoc.board.noticeuserCount";
			result = dao.noticeCount(id, tag);
		}
		return result;
	}

	@Override
	public int reviewCount(String id, String state) {
		List<Notice_BoardDTO> reviewlist = null;
		String tag;
		int result = 0;
		if (state.equals("hadmin")) {
			tag = "finddoc.board.reviewCount";
			result = dao.reviewCount(id, tag);
		} else {
			tag = "finddoc.board.reviewuserCount";
			result = dao.reviewCount(id, tag);
		}
		return result;
	}

	@Override
	public List<Notice_BoardDTO> myhospitallist(String userid) {
		return dao.myhospitallist(userid);
	}

	@Override
	public Review_BoardDTO reviewread(String reviewboardnum) {
		dao.reviewcount(reviewboardnum);
		Review_BoardDTO dto = dao.reviewread(reviewboardnum);
		return dto;
	}

	// @Override
	// public List<Review_BoardDTO> hospitallist() {
	// return dao.hospitallist();
	// }

}
