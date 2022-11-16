package Sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;
import Member.MemberVO;

public class SignDAO {

	   private static SignDAO instance = new SignDAO();
	    public static SignDAO getInstance() {
	        return instance;
	    }
	    private SignDAO() {}

	    private JdbcTemplate template = BrandaApplication.getTemplate();

	    public MemberVO findUser(MemberVO vo) {
	        try {
	            return template.queryForObject("SELECT MEM_ID, MEM_ID, MEM_NAME, MEM_ADD, MEM_PHONE FROM MEMBER WHERE MEM_ID = ? AND MEM_PW = ?", new BeanPropertyRowMapper<>(MemberVO.class), vo.getMemId(), vo.getMemPw());
	        } catch (DataAccessException e) {
	            return null;
	        }
	    }
}
