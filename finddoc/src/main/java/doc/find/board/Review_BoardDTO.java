package doc.find.board;

public class Review_BoardDTO {
	private int reviewboardnum;
	private int reviewcount;
	private String id;
	private String title;
	private String text;
	private String del;
	private String txupdate;
	private String moddate;
	private String APPROVALNUM;
	private int reco;
	private String hname;
	private String name;

	public Review_BoardDTO(int reviewboardnum, int reviewcount, String id, String title, String text, String del,
			String txupdate, String moddate, String aPPROVALNUM, int reco, String hname, String name) {
		super();
		this.reviewboardnum = reviewboardnum;
		this.reviewcount = reviewcount;
		this.id = id;
		this.title = title;
		this.text = text;
		this.del = del;
		this.txupdate = txupdate;
		this.moddate = moddate;
		APPROVALNUM = aPPROVALNUM;
		this.reco = reco;
		this.hname = hname;
		this.name = name;
	}

	public Review_BoardDTO() {
		super();
	}

	public int getReviewboardnum() {
		return reviewboardnum;
	}

	public void setReviewboardnum(int reviewboardnum) {
		this.reviewboardnum = reviewboardnum;
	}

	public int getReviewcount() {
		return reviewcount;
	}

	public void setReviewcount(int reviewcount) {
		this.reviewcount = reviewcount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getTxupdate() {
		return txupdate;
	}

	public void setTxupdate(String txupdate) {
		this.txupdate = txupdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public String getAPPROVALNUM() {
		return APPROVALNUM;
	}

	public void setAPPROVALNUM(String aPPROVALNUM) {
		APPROVALNUM = aPPROVALNUM;
	}

	public int getReco() {
		return reco;
	}

	public void setReco(int reco) {
		this.reco = reco;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Review_BoardDTO [reviewboardnum=" + reviewboardnum + ", reviewcount=" + reviewcount + ", id=" + id
				+ ", title=" + title + ", text=" + text + ", del=" + del + ", txupdate=" + txupdate + ", moddate="
				+ moddate + ", APPROVALNUM=" + APPROVALNUM + ", reco=" + reco + ", hname=" + hname + ", name=" + name
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}