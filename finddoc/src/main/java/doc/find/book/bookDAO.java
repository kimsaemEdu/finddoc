package doc.find.book;

import org.springframework.stereotype.Repository;

public interface bookDAO {
	int insertbook(BookDTO bookdto);
	int book_check(BookDTO checkbook);
}
