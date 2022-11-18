package PastOrd;

import java.sql.Date;

public class PastOrdVO {
	// 과거 주문 내역
	// 회원에 주문한 ORD 내역을 보관
	// 한 회원이 주문한 후 ORD에서 ORD 내역을 PastOrd로 이동한 후 ORD에서는 주문 내역 삭제
	private int prodId;
	private String ordCode;
	private String memId;
	private Date ordDate;

	public PastOrdVO() {
	}

	public PastOrdVO(int prodId, String ordCode, String memId) {
		this.prodId = prodId;
		this.ordCode = ordCode;
		this.memId = memId;
	}

	public PastOrdVO(int prodId, String ordCode, String memId, Date ordDate) {
		this.prodId = prodId;
		this.ordCode = ordCode;
		this.memId = memId;
		this.ordDate = ordDate;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
}
