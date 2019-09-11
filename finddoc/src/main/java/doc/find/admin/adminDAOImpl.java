package doc.find.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import doc.find.member.HadminDTO;

@Repository
public class adminDAOImpl implements adminDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<HadminDTO> listAll() {
		return sqlSession.selectList("admin.selectAll");
	}

	@Override
	public List<HadminDTO> acceptlist() {
		return sqlSession.selectList("admin.acceptlist");
	}

	@Override
	public int accept(String hadminid) {
		// TODO Auto-generated method stub
		return sqlSession.update("admin.accept", hadminid);
	}

	@Override
	public List<HadminDTO> searchAll(String tag, String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		return sqlSession.selectList("admin.searchAll",map);
	}

}
