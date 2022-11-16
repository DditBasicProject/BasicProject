package Member;

import Branda.HomeMenu;


public class MemberService {
   private static MemberService instance = new MemberService();
   public static MemberService getInstance() { return instance;}

   private MemberService() {}
   private MemberDAO dao = MemberDAO.getInstance();

//회원찾기 쓸꺼면 여기에 내용 넣기

   public int join(MemberVO vo) {
      return dao.Sign(vo);
   }
   public int editMember(MemberVO vo,HomeMenu menu) 
   {
      int result = 0;
      switch(menu) 
      {
      case MODIFY_PASSWORD:
         result = dao.editPw(vo);
         break;
      case MODIFY_PHONE:
         result = dao.editPhNum(vo);
         break;
      case MODIFY_ADDRESS:
         result =dao.editAdd(vo);
         break;
      }
      return result;
   }

   public int modifyPassword(MemberVO vo) {
	      return dao.editPw(vo);
	   }
	   public int modifyAddress(MemberVO vo) {
	      return dao.editAdd(vo);
	   }
	   public int modifyPhone(MemberVO vo) {
	      return dao.editPhNum(vo);
	   }

}
