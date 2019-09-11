package doc.find.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mypageDao")
public class mypageDAOImpl implements mypageDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int bookmark_search(mypageDTO mypage) {
		String check = sqlSession.selectOne("user.bookmark.checkbookmark",mypage);
		int result = Integer.parseInt(check);
		return result;
	}

	@Override
	public int bookmark_insert(mypageDTO mypage) {
		return sqlSession.insert("user.bookmark.insertbookmark",mypage);
	}

	@Override
	public int bookmark_delete(mypageDTO mypage) {
		return sqlSession.update("user.bookmark.deletebookmark", mypage);
	}

	@Override
	public List<MyhospitalDTO> selectAll(String id) {
		return sqlSession.selectList("user.bookmark.selectall", id);
	}

	@Override
	public List<MyhospitalDTO> selectTag(String tag, String search, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		map.put("userid", id);
		return sqlSession.selectList("user.bookmark.dynamicSearch", map);
	}

	@Override
	public int hosp_check(String ykiho) {
		String check = sqlSession.selectOne("user.bookmark.hospcheck",ykiho);
		System.out.println("============================="+check);
		int result = Integer.parseInt(check);
		return result;
	}
}
