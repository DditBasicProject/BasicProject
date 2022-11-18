package PastOrd;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;
import ProdOrd.OrderVO;

public class PastOrdDAO {
	private static PastOrdDAO instance = new PastOrdDAO();
	private PastOrdDAO() {}
	
	private JdbcTemplate template = BrandaApplication.getTemplate();
	
	public static PastOrdDAO getInstance() {
		return instance;
	}	
	//주문 내역 조회
	public List<PastOrdVO> pastOrdList() {
		return template.query("select * from pastord", new BeanPropertyRowMapper<PastOrdVO>(PastOrdVO.class));
//		try {
//		return template.update("INSERT INTO PASTORD(PROD_ID, ORD_CODE, MEM_ID, ORD_DATE) \r\n"
//				+ "     VALUES (?,?,?,SYSDATE)",vo.getProdId(),vo.getOrdCode(),vo.getMemId());
//		} catch (EmptyResultDataAccessException e) {
//			e.printStackTrace();
	}


}
