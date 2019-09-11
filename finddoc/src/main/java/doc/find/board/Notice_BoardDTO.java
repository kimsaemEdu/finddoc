package doc.find.board;

public class Notice_BoardDTO {
	private int noticeboardnum;
	private int noticecount;
	private String hadminid;
	private String title;
	private String text;
	private String del;
	private String txupdate;
	private String moddate;
	private String hname;
	private String name;
	private int rn;
	private int count;

	public Notice_BoardDTO() {
		super();
	}

	public Notice_BoardDTO(int noticeboardnum, int noticecount, String hadminid, String title, String text, String del,
			String txupdate, String moddate, String hname, String name, int rn, int count) {
		super();
		this.noticeboardnum = noticeboardnum;
		this.noticecount = noticecount;
		this.hadminid = hadminid;
		this.title = title;
		this.text = text;
		this.del = del;
		this.txupdate = txupdate;
		this.moddate = moddate;
		this.hname = hname;
		this.name = name;
		this.rn = rn;
		this.count = count;
	}

	public int getNoticeboardnum() {
		return noticeboardnum;
	}

	public void setNoticeboardnum(int noticeboardnum) {
		this.noticeboardnum = noticeboardnum;
	}

	public int getNoticecount() {
		return noticecount;
	}

	public void setNoticecount(int noticecount) {
		this.noticecount = noticecount;
	}

	public String getHadminid() {
		return hadminid;
	}

	public void setHadminid(String hadminid) {
		this.hadminid = hadminid;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Notice_BoardDTO [noticeboardnum=" + noticeboardnum + ", noticecount=" + noticecount + ", hadminid="
				+ hadminid + ", title=" + title + ", text=" + text + ", del=" + del + ", txupdate=" + txupdate
				+ ", moddate=" + moddate + ", hname=" + hname + ", name=" + name + ", rn=" + rn + ", count=" + count
				+ "]";
	}

}