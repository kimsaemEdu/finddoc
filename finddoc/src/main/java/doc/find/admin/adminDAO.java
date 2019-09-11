package doc.find.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import doc.find.member.HadminDTO;

@Repository
public interface adminDAO {
	List<HadminDTO> listAll();
	List<HadminDTO> acceptlist();
	int accept(String hadminid);
	List<HadminDTO> searchAll(String tag, String search);
}
