package Member;

import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;
import Order.OrderVO;


public class MemberDAO 
{
   private static MemberDAO instance = new MemberDAO();
   private MemberDAO() {}
   Scanner scanner = new Scanner(System.in);
   
   private JdbcTemplate template = BrandaApplication.getTemplate();
   
   public static MemberDAO getInstance() 
   {
      return instance;
   }
   //회원가입
   public int Sign(MemberVO vo) {
        return template.update("INSERT INTO MEMBER (MEM_ID, MEM_NAME, MEM_ADD, MEM_PHONE, MEM_PW) VALUES (?, ?, ?, ?, ?)", vo.getMemId(), vo.getMemName(), vo.getMemAdd(), vo.getMemPhone(), vo.getMemPw());
    }
   
   //회원정보 수정 : 비밀번호 수정, 전화번호 수정, 주소 수정
   //1.비밀번호수정
   public int editPw(MemberVO vo) 
   {
      return template.update("UPDATE MEMBER SET MEM_PW=? WHERE MEM_ID =?",vo.getMemPw(),vo.getMemId());
   }
   //2.전화번호 수정
   public int editPhNum(MemberVO vo) 
   {
      return template.update("UPDATE MEMBER SET MEM_PHONE= ? WHERE MEM_ID = ?",vo.getMemPhone(), vo.getMemId());
   }
   //3.주소 수정
   public int editAdd(MemberVO vo) 
   {
      return template.update("UPDATE MEMBER SET MEM_ADD= ? WHERE MEM_ID = ?",vo.getMemAdd(), vo.getMemId());
   }
   //리뷰 : 등록, 수정, 삭제
   //1.등록
   public int Review(MemberVO vo,OrderVO ovo) throws Exception 
   {
      String rvTitle = scanner.nextLine();
      String rvContent = scanner.nextLine();
      String rvGrade = scanner.nextLine();
      
      return template.update("INSERT INTO REVIEW{\r\n"
            + "       REVIEW_ID,PROD_ID, ORD_CODE, REVIEW_TITLE,\r\n"
            + "       REVIEW_CONTENT,REVIEW_GRADE,MEM_ID)\r\n"
            + "   VALUES ('SELECT NVL(MAX(REVIEW_ID),0)+1 FROM REVIEW'\r\n"
            + " ?,?,?,?,?,?\r\n"
            +  ovo.getProdId(),ovo.getOrdCode(),rvTitle,rvContent,rvGrade,vo.getMemId()+ ")");
      
   }
   
   //2.수정
   public int editReview()
   {
      String rvTitle = scanner.nextLine();
      String rvContent = scanner.nextLine();
      String rvGrade = scanner.nextLine();
      
      return template.update("UPDATE REVIEW"
             +"SET REVIEW_TITLE = ?,REVIEW_CONTENT = ?,REVIEW_GRADE = ?"
             +"      WHERE EXISTS( SELECT a.MEM_ID, a.PROD_ID from ORD B, OPROD c,REVIEW a" 
             +"                     WHERE a.MEM_ID = B.MEM_ID and   a.PROD_ID = c.PROD_ID)"
             + rvTitle,rvContent,rvGrade+")");   
   }
   
   //3.삭제
   public int delReview(MemberVO vo)
   {
      String delMemId = scanner.nextLine();
      return template.update("DELETE REVIEW WHERE MEM_ID =?" , delMemId);
   }
   
}