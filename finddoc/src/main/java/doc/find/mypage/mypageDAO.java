package doc.find.mypage;

import java.util.List;

public interface mypageDAO {
	int bookmark_search(mypageDTO mypage);
	
	int bookmark_insert(mypageDTO mypage);
	
	int bookmark_delete(mypageDTO mypage);
	
	List<MyhospitalDTO> selectAll(String id);
	
	List<MyhospitalDTO> selectTag(String tag, String search, String id);
	
	int hosp_check(String ykiho);
}
