package Member;

import Branda.BrandaApplication;
import Branda.HomeMenu;
import PastOrd.PastOrdVO;
import ProdOrd.OrderVO;



public class MemberController {
	public static MemberController instance = new MemberController();
	public static MemberController getInstance() {return instance;}
	
	private MemberController() {}
	private MemberService service = MemberService.getInstance();
	private MemberVO session = BrandaApplication.getSession();
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	public int join(MemberVO vo) {
		try {
			if(service.join(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		}catch(Exception e) {
			System.out.println("알수 없는 오류가 발생하였습니다");
            return HomeMenu.JOIN.getMenu();
        }
        return HomeMenu.HOME.getMenu();
			
	}
	 public int modifyInfo(String modifyData ,HomeMenu menu) {
	         MemberVO vo = new MemberVO();
	        vo.setMemId(session.getMemId());
	        switch (menu) {
	            case MODIFY_ADDRESS:
	                vo.setMemAdd(modifyData);
	                break;
	            case MODIFY_PHONE:
	                vo.setMemPhone(modifyData);
	                break;
	        }
	        return service.editMember(vo, menu);
	    }
//////////////////회원정보 변경 확인용
	 public MemberVO findMemberVO() {
		 return service.findMember(session.getMemId());
	 }
/////////////////내용추가	 
	 public int modifyPassword(String password) {
		 MemberVO vo = new MemberVO();
		 vo.setMemId(session.getMemId());
		 vo.setMemPw(password);
		 return service.modifyPassword(vo);
	 }
	 public int modifyPhone(String phone) {
		 MemberVO vo = new MemberVO();
		 vo.setMemId(session.getMemId());
		 vo.setMemPhone(phone);
		 return service.modifyPhone(vo);
	 }
	 public int modifyAddress(String address) {
		 MemberVO vo = new MemberVO();
		 vo.setMemId(session.getMemId());
		 vo.setMemAdd(address);
		 return service.modifyAddress(vo);
	 }
	 

}
