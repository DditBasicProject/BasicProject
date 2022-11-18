package ProdOrd;

import java.sql.Date;

public class OrderVO {
   
   private int prodId;
   private String prodName;
   private int prodPrice;
   private String ordCode;
   private String memId;
   private Date ordDate;
   private int ordSum;
   private int ordQty;

   public OrderVO() {}

   public OrderVO(int prodId, String prodName, int prodPrice) {
      this.prodId = prodId;
      this.prodName = prodName;
      this.prodPrice = prodPrice;
   }

   public OrderVO(String memId) {
      this.memId = memId;
   }

   public OrderVO(int prodId, String ordCode, String memId, Date ordDate, int ordSum, int ordQty) {
      this.prodId = prodId;
      this.ordCode = ordCode;
      this.memId = memId;
      this.ordDate = ordDate;
      this.ordSum = ordSum;
      this.ordQty = ordQty;
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

   public int getProdPrice() {
      return prodPrice;
   }

   public void setProdPrice(int prodPrice) {
      this.prodPrice = prodPrice;
      this.ordSum = this.ordQty * this.prodPrice;
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

   public int getOrdSum() {
      return ordSum;
   }

   public void setOrdSum(int ordSum) {
      this.ordSum = ordSum;
   }

   public int getOrdQty() {
      return ordQty;
   }

   public void setOrdQty(int ordQty) {
      this.ordQty = ordQty;
   }
   
}