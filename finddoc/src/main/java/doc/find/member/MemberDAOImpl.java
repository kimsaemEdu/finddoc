package doc.find.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUser(UserDTO userdto) {
		return sqlSession.insert("finddoc.member.insertUser", userdto);
	}

	@Override
	public int insertHadmin(HadminDTO hadmindto) {
		return sqlSession.insert("finddoc.member.insertHadmin", hadmindto);
	}

	@Override
	public MemberDTO idcheck(String id, String tag) {
		return sqlSession.selectOne(tag, id);
	}

	@Override
	public int update(MemberDTO memberdto, String tag) {
		return sqlSession.update(tag, memberdto);
	}

	@Override
	public int delete(String id, String tag) {
		return sqlSession.update(tag, id);
	}

	@Override
	public MemberDTO emailcheck(String email, String tag) {
		return sqlSession.selectOne(tag, email);
	}

	@Override
	public int insertAdmin_app(String id) {
		System.out.println("========================="+id);
		return sqlSession.insert("finddoc.member.insertAdmin_app", id);
	}

}
