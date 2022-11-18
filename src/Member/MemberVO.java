package Member;

public class MemberVO {

   private String memId; // pk
   private String memPw;
   private String memName;
   private String memPhone;
   private String memAdd;

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

   public String getMemAdd() {
      return memAdd;
   }

   public void setMemAdd(String memAdd) {
      this.memAdd = memAdd;
   }

   public MemberVO() { }

   public MemberVO(String memId) {
      this.memId = memId;
   }

   public MemberVO(String memId, String memPw) {
      this.memId = memId;
      this.memPw = memPw;
   }

   public MemberVO(String memId, String memName, String memPhone, String memAdd) {
      this.memId = memId;
      this.memName = memName;
      this.memPhone = memPhone;
      this.memAdd = memAdd;
   }
   

   public MemberVO(String memId, String memPw, String memName, String memPhone, String memAdd) {
	super();
	this.memId = memId;
	this.memPw = memPw;
	this.memName = memName;
	this.memPhone = memPhone;
	this.memAdd = memAdd;
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
            + ", memPoint=" + ", memAdd=" + memAdd + "]";
   }

}