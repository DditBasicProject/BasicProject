package Sign;

import Branda.BrandaApplication;
import Branda.HomeMenu;
import Member.MemberVO;

public class SignController {
	   private static SignController instance = new SignController();
	    public static SignController getInstance() {
	        return instance;
	    }
	    private SignController() {}

	    private SignService service = SignService.getInstance();

	    private MemberVO session = BrandaApplication.getSession();

	    public MemberVO signIn(MemberVO vo) {
	        MemberVO member = service.findUser(vo);
	        if (member == null) {
	            return null;
	        }
	        session.setMemId(member.getMemId());
	        session.setMemName(member.getMemName());
	        return member;
	    }
	    public int signOut() {
	        // 세션 초기화
	        session.invalidate();
	        return HomeMenu.HOME.getMenu();
	    }

}
