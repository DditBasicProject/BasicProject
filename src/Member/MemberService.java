package Member;

import Branda.HomeMenu;
import ProdOrd.OrderVO;


public class MemberService {
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() { return instance;}

	private MemberService() {}
	private MemberDAO dao = MemberDAO.getInstance();

//회원 목록
	public MemberVO findMember(String memId) {
		return dao.findMember(memId);
	}
	
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
//////////이것도 추가
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

