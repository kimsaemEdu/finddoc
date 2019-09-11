package doc.find.book;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class bookDAOImpl implements bookDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertbook(BookDTO bookdto) {
		return sqlSession.insert("user.book.insert", bookdto);
	}

	@Override
	public int book_check(BookDTO checkbook) {
		return sqlSession.selectOne("user.book.check_book", checkbook);
	}
}
