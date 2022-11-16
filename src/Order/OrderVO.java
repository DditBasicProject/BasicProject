package Order;

import java.sql.Date;
import java.util.Objects;

public class OrderVO {
	//카테고리
	private int cateId;
	private String cateName;
	//상품
	private int prodId;
	private String prodName;
	private int prodQty;
	private int prodPrice;
	//주문
	private Date ordDate;
	private int ordSum;	
	// 주문상품
	private String ordCode;
	private int oprodQty;

	
	public OrderVO() {}

	public OrderVO(int cateId, String cateName, int prodId, String prodName, int prodQty, int prodPrice, Date ordDate,
			int ordSum, String ordCode, int oprodQty) {
		this.cateId = cateId;
		this.cateName = cateName;
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodQty = prodQty;
		this.prodPrice = prodPrice;
		this.ordDate = ordDate;
		this.ordSum = ordSum;
		this.ordCode = ordCode;
		this.oprodQty = oprodQty;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public int getOrdSum() {
		return ordSum;
	}

	public void setOrdSum(int ordSum) {
		this.ordSum = ordSum;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public int getOprodQty() {
		return oprodQty;
	}

	public void setOprodQty(int oprodQty) {
		this.oprodQty = oprodQty;
	}

	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        OrderVO OrderVO = (OrderVO) o;
	        return prodId == OrderVO.prodId && prodName == OrderVO.prodName 
	        		&& Objects.equals(prodQty, OrderVO.prodQty)
	        		&& Objects.equals(prodPrice, OrderVO.prodPrice);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(prodId, prodName, prodQty, prodPrice);
	    }

	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("ProdVO{");
	        sb.append("prodId=").append(prodId);
	        sb.append(", prodName='").append(prodName).append('\'');
	        sb.append(", prodQty='").append(prodQty).append('\'');
	        sb.append(", prodPrice=").append(prodPrice);
	        sb.append('}');
	        return sb.toString();
	    }
//	@Override
//	public String toString() {
//		return "OrderVO [cateId=" + cateId + ", cateName=" + cateName + ", prodId=" + prodId + ", prodName=" + prodName
//				+ ", prodQty=" + prodQty + ", prodPrice=" + prodPrice + ", ordDate=" + ordDate + ", ordSum=" + ordSum
//				+ ", ordCode=" + ordCode + ", oprodQty=" + oprodQty + ", deliveryFee=" + deliveryFee + ", deliveryAdd="
//				+ deliveryAdd + "]";
//	}
	
}
