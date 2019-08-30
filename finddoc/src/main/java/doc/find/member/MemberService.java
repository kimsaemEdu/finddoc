package doc.find.member;

import java.io.IOException;

public interface MemberService {
	// 회원가입(사용자)
	int insertUser(UserDTO userdto);

	// 회원가입(병원관계자)
	int insertHadmin(HadminDTO hadmindto);

	// 아이디중복체크(사용자,병원관계자,관리자)
	boolean idcheck(String id);

	// 이메일중복체크(사용자,병원관계자)
	boolean emailcheck(String email);

	// 회원정보수정(사용자,병원관계자)
	int update(MemberDTO memberdto, String action);

	// 병원명 검색
	String search(String hospname, String pageno, String rows, String haddr) throws IOException;

	// 회원탈퇴(사용자,병원관계자)
	int delete(String id, String action);
}
