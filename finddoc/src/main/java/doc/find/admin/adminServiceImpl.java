package doc.find.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doc.find.member.HadminDTO;

@Service
public class adminServiceImpl implements adminService {
	@Autowired
	adminDAO dao;

	@Override
	public List<HadminDTO> listAll() {
		return dao.listAll();
	}

	@Override
	public List<HadminDTO> acceptlist() {
		return dao.acceptlist();
	}

	@Override
	public int accept(String hadminid) {
		return dao.accept(hadminid);
	}

	@Override
	public List<HadminDTO> searchAll(String tag, String search) {
		return dao.searchAll(tag, search);
	}

}
