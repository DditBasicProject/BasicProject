package Oprod;

public class OprodVO {
   
   private int prodId; //PK 
//   private String ordCode;  
   private String memId;
   private int oprodQty;   
   private String prodName;
   private int prodPrice;

   public String getProdName() {
      return prodName;
   }
   public void setProdName(String prodName) {
      this.prodName = prodName;
   }
   public int getprodPrice() {
      return prodPrice;
   }
   public void setprodPrice(int prodPrice) {
      this.prodPrice = prodPrice;
   }
   
   public int getProdId() {
      return prodId;
   }
   public void setProdId(int prodId) {
      this.prodId = prodId;
   }
//   public String getOrdCode() {
//      return ordCode;
//   }
//   public void setOrdCode(String ordCode) {
//      this.ordCode = ordCode;
//   }
   public String getMemId() {
      return memId;
   }
   public void setMemId(String memId) {
      this.memId = memId;
   }
   public int getOprodQty() {
      return oprodQty;
   }
   public void setOprodQty(int oprodQty) {
      this.oprodQty = oprodQty;
   }
//   public OprodVO(int prodId, String ordCode, String memId, int oprodQty) {
//      super();
//      this.prodId = prodId;
//      this.ordCode = ordCode;
//      this.memId = memId;
//      this.oprodQty = oprodQty;
//   }
   public OprodVO() {
   }
//   public void invalidate() {
//      this.prodId= 0;
//      this.ordCode =null;
//      this.oprodQty= 0;
//       this.memId = null;
//      }
   
//   @Override
//   public String toString() {
//      return "OprodVO [prodId=" + prodId + ", ordCode=" + ordCode + ", memId=" + memId + ", ordQty=" + ordQty + "]";
//   }
   
   
   

}