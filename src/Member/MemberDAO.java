package Member;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;


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
        return template.update("INSERT INTO MEMBER (MEM_ID, MEM_PW,MEM_NAME,MEM_PHONE,MEM_ADD) VALUES (?, ?, ?, ?, ?)", vo.getMemId(), vo.getMemPw(),vo.getMemName(), vo.getMemPhone(), vo.getMemAdd());
    }
	
	//회원정보 확인용
	public MemberVO findMember(String memId) {
		return template.queryForObject("SELECT MEM_ID, MEM_NAME, MEM_ADD, MEM_PHONE FROM MEMBER WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(MemberVO.class), memId);
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
	
}