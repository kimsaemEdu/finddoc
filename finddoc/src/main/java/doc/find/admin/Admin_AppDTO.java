package doc.find.admin;

public class Admin_AppDTO {
	// 병원관계자 아이디
	private String hadminid;
	// 승인유무
	private String approval;
	
	public Admin_AppDTO() {
		
	}
	public Admin_AppDTO(String hadminid, String approval) {
		super();
		this.hadminid = hadminid;
		this.approval = approval;
	}
	public String getHadminid() {
		return hadminid;
	}
	public void setHadminid(String hadminid) {
		this.hadminid = hadminid;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	@Override
	public String toString() {
		return "Admin_AppDTO [hadminid=" + hadminid + ", approval=" + approval + "]";
	}
}