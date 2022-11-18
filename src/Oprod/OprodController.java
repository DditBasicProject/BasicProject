package Oprod;

import Branda.BrandaApplication;
import Branda.HomeMenu;
import Member.MemberVO;

public class OprodController {
   public static OprodController instance = new OprodController();
   public static OprodController getInstance() {return instance;}

   private OprodController() {}
   private Oprodsevice service = Oprodsevice.getInstance();

   public OprodController(Oprodsevice service) {
      this.service = service;
   }

   public OprodVO findByOrdVO() {
      MemberVO session = BrandaApplication.getSession();
      return service.findByOrd(session.getMemId());
   }
//   public int join(OprodVO vo) {
//		try {
//			if(service.join(vo) == 1) {
//				return HomeMenu.HOME.getMenu();
//			}
//		}catch(Exception e) {
//			System.out.println("알수 없는 오류가 발생하였습니다");
//           return HomeMenu.JOIN.getMenu();
//       }
//       return HomeMenu.HOME.getMenu();
//	}
}