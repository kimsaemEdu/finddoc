package doc.find.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doc.find.mypage.mypageDAO;

@Service
public class bookServiceImpl implements bookService {
	@Autowired
	bookDAO dao;
	@Autowired
	mypageDAO mypagedao;

	@Override
	public String insertbook(BookDTO bookdto) {
		int check = mypagedao.hosp_check(bookdto.getYkiho());
		BookDTO checkbook = new BookDTO(bookdto.getYkiho(), bookdto.getMajor(), bookdto.getBookdate(), bookdto.getHour(), bookdto.getMint());
		String message="";
		if(check>0) {
			System.out.println(checkbook);
			int bookcheck = dao.book_check(checkbook);
			if(bookcheck==0) {
				int result = dao.insertbook(bookdto); 
				if(result>0) {
					message="예약 신청 완료";
				}
				else {
					message="예약 신청 실패";
				}
			}
			else {
				message="예약 불가능한 시간입니다.";
			}
		}
		else {
			message="이용 불가한 병원입니다.";
		}
		System.out.println(message);
		return message;
	}

}
