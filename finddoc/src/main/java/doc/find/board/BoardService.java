package doc.find.board;

import java.util.List;

public interface BoardService {
	// 공지사항게시판에 글쓰기
	int noticeinsert(Notice_BoardDTO noticedto);

	// 공지사항들어오면 보여지는 공지사항리스트
	List<Notice_BoardDTO> noticelist(String id, String state);

	// 공지사항게시판 글읽기
	Notice_BoardDTO noticeread(String noticeboardnum);

	// 공지사항 게시판 글삭제
	int noticedelete(String noticeboardnum);

	// 공지사항 게시판 글수정
	int noticeupdate(Notice_BoardDTO noticedto);

	// 공지사항 게시판 검색
	List<Notice_BoardDTO> noticesearch(String category, String search);

}
