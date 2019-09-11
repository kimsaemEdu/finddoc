package doc.find.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int noticeinsert(Notice_BoardDTO noticedto) {
		return sqlSession.insert("finddoc.board.insertnotice", noticedto);
	}

	@Override
	public List<Notice_BoardDTO> noticelist(String id, String tag, int startIndex) {
		HashMap<String, String> map = new HashMap<String, String>();
		String start = startIndex + "";
		String end = startIndex + 9 + "";
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(tag, map);
	}

	@Override
	public Notice_BoardDTO noticeread(String noticeboardnum) {
		return sqlSession.selectOne("finddoc.board.noticeread", noticeboardnum);
	}

	@Override
	public int noticecount(String noticeboardnum) {
		return sqlSession.update("finddoc.board.noticecount", noticeboardnum);
	}

	@Override
	public int noticedelete(String noticeboardnum) {
		return sqlSession.update("finddoc.board.noticedelete", noticeboardnum);
	}

	@Override
	public int noticeupdate(Notice_BoardDTO noticedto) {
		return sqlSession.update("finddoc.board.noticeupdate", noticedto);
	}

	@Override
	public List<Notice_BoardDTO> noticesearchcount(String tag, String id, String category, String search,
			String hadminid) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("search", search);
		map.put("id", id);
		map.put("hadminid", hadminid);
		return sqlSession.selectList(tag, map);
	}

	@Override
	public List<Notice_BoardDTO> noticesearch(String tag, String id, String category, String search, String hadminid,
			int startIndex) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("search", search);
		String start = startIndex + "";
		String end = startIndex + 9 + "";
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		map.put("hadminid", hadminid);
		return sqlSession.selectList(tag, map);
	}

	@Override
	public int reviewinsert(Review_BoardDTO reviewdto) {
		return sqlSession.insert("finddoc.board.insertreview", reviewdto);
	}

	@Override
	public List<Review_BoardDTO> reviewlist(String id, String tag, int startIndex) {
		HashMap<String, String> map = new HashMap<String, String>();
		String start = startIndex + "";
		String end = startIndex + 9 + "";
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(tag, map);
	}

	@Override
	public List<Review_BoardDTO> reviewsearch(String category, String search, int startIndex) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("search", search);
		return sqlSession.selectList("finddoc.board.reviewsearch", map);
	}

	@Override
	public List<Review_BoardDTO> reviewsearchhname(String category, String id, int startIndex) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("id", id);
		return sqlSession.selectList("finddoc.board.reviewsearchhname", map);
	}

	@Override
	public int noticeCount(String id, String tag) {
		return sqlSession.selectOne(tag, id);
	}

	@Override
	public int reviewCount(String id, String tag) {
		return sqlSession.selectOne(tag, id);
	}

	@Override
	public List<Notice_BoardDTO> myhospitallist(String userid) {
		return sqlSession.selectList("finddoc.board.myhospital", userid);
	}

	@Override
	public int reviewcount(String reviewboardnum) {
		return sqlSession.update("finddoc.board.reviewcount", reviewboardnum);
	}

	@Override
	public Review_BoardDTO reviewread(String reviewboardnum) {
		return sqlSession.selectOne("finddoc.board.reviewread", reviewboardnum);
	}

	// @Override
	// public List<Review_BoardDTO> hospitallist() {
	// return sqlSession.selectList("finddoc.board.hospital");
	// }

}
