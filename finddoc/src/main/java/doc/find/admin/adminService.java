package doc.find.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import doc.find.member.HadminDTO;

public interface adminService {
	List<HadminDTO> listAll();
	List<HadminDTO> acceptlist();
	int accept(String hadminid);
	List<HadminDTO> searchAll(String tag, String search);
}
