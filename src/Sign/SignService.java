package Sign;

import Member.MemberVO;

public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public MemberVO findUser(MemberVO vo) {
        return dao.findUser(vo);
    }
}