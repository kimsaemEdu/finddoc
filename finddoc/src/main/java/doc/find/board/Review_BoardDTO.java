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
	private String ykiho;
	private int reco;
	private String hname;
	private String name;
	private int rn;

	public Review_BoardDTO(int reviewboardnum, int reviewcount, String id, String title, String text, String del,
			String txupdate, String moddate, String ykiho, int reco, String hname, String name, int rn) {
		super();
		this.reviewboardnum = reviewboardnum;
		this.reviewcount = reviewcount;
		this.id = id;
		this.title = title;
		this.text = text;
		this.del = del;
		this.txupdate = txupdate;
		this.moddate = moddate;
		this.ykiho = ykiho;
		this.reco = reco;
		this.hname = hname;
		this.name = name;
		this.rn = rn;
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

	public String getykiho() {
		return ykiho;
	}

	public void setykiho(String ykiho) {
		ykiho = ykiho;
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

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "Review_BoardDTO [reviewboardnum=" + reviewboardnum + ", reviewcount=" + reviewcount + ", id=" + id
				+ ", title=" + title + ", text=" + text + ", del=" + del + ", txupdate=" + txupdate + ", moddate="
				+ moddate + ", ykiho=" + ykiho + ", reco=" + reco + ", hname=" + hname + ", name=" + name + ", rn=" + rn
				+ "]";
	}

}