package Member;

public class MemberVO {

	private String memId; // pk
	private String memPw;
	private String memName;
	private String memPhone;
	private int memPoint;
	private String memAdd;

	private int reviewId; // pk
	private String revTitle;
	private String revContent;
	private String revGrade;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getRevTitle() {
		return revTitle;
	}

	public void setRevTitle(String revTitle) {
		this.revTitle = revTitle;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public String getRevGrade() {
		return revGrade;
	}

	public void setRevGrade(String revGrade) {
		this.revGrade = revGrade;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}

	public String getMemAdd() {
		return memAdd;
	}

	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}

	public MemberVO() {
	}

	public MemberVO(String memId) {
		this.memId = memId;
	}

	public MemberVO(String memId, String memPw) {
		this.memId = memId;
		this.memPw = memPw;
	}

	public MemberVO(String memId, String memName, String memPhone, int memPoint, String memAdd) {
		this.memId = memId;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memPoint = memPoint;
		this.memAdd = memAdd;
	}

	public MemberVO(String memId, String memPw, String memName, String memPhone, int memPoint, String memAdd) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memPoint = memPoint;
		this.memAdd = memAdd;
	}

	public MemberVO(String revTitle, String revContent, String revGrade) {
		super();
		this.revTitle = revTitle;
		this.revContent = revContent;
		this.revGrade = revGrade;
	}

	public MemberVO(int reviewId, String revTitle, String revContent, String revGrade) {
		super();
		this.reviewId = reviewId;
		this.revTitle = revTitle;
		this.revContent = revContent;
		this.revGrade = revGrade;
	}

	public MemberVO(String memId, String memName, String memAdd, String memPhone, String memPw) {
		this.memId = memId;
		this.memName = memName;
		this.memAdd = memAdd;
		this.memPhone = memPhone;
		this.memPw = memPw;
	}

	public void invalidate() {
		this.memId = null;
		this.memName = null;
		this.memAdd = null;
		this.memPhone = null;
		this.memPw = null;

	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memPhone=" + memPhone
				+ ", memPoint=" + memPoint + ", memAdd=" + memAdd + "]";
	}

}
