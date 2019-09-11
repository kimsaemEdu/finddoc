package doc.find.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class mypageServiceImpl implements mypageService {
	@Autowired
	@Qualifier("mypageDao")
	mypageDAO dao;

	@Override
	public int insertbookmark(mypageDTO mypage) {
		int result = 0;
		int admincheck = dao.hosp_check(mypage.getYkiho());
		if(admincheck!=0){
			int check = dao.bookmark_search(mypage);
			if(check==0) { //자주가는 병원에 등록되어 있는 병원인가 확인
				result=dao.bookmark_insert(mypage);
			}
			else {
				result=0; //등록되어 있는 병원의 경우 등록되었다고 표시
			}
		}
		else {
			result=20000;
		}
		
		return result;
	}

	@Override
	public List<MyhospitalDTO> selectAll(String id) {
		return dao.selectAll(id);
	}

	@Override
	public int deletebookmark(mypageDTO mypage) {
		return dao.bookmark_delete(mypage);
	}

	@Override
	public List<MyhospitalDTO> selectTag(String tag, String search, String id) {
		return dao.selectTag(tag, search, id);
	}

}
