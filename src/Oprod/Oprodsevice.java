package Oprod;

import java.util.List;

import Branda.HomeMenu;
import Member.MemberVO;
import ProdOrd.OrderVO;

public class Oprodsevice {
   private static Oprodsevice instance = new Oprodsevice();
   public static Oprodsevice getInstance() { return instance;}

   private Oprodsevice() {}
   private OprodDAO dao = OprodDAO.getInstance();

   //주문상품목록

      public OprodVO findByOrd(String memId) {
         return dao.findByOrd(memId);
      }

}