package doc.find.member;

public interface MemberDAO {
	// 회원가입(사용자)
	int insertUser(UserDTO userdto);

	// 회원가입(병원관계자)
	int insertHadmin(HadminDTO hadmindto);

	// 아이디중복체크(사용자,병원관계자,관리자)
	MemberDTO idcheck(String id, String tag);

	// 이메일중복체크(사용자,병원관계자)
	MemberDTO emailcheck(String email, String tag);

	// 회원정보수정(사용자,병원관계자)
	int update(MemberDTO memberdto, String tag);

	// 회원탈퇴(사용자,병원관계자)
	int delete(String id, String tag);
	
	int insertAdmin_app(String id);

}
