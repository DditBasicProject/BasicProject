package ProdOrd;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

	Scanner scanner = new Scanner(System.in);

	private OrderDAO() {
	}

	private JdbcTemplate template = BrandaApplication.getTemplate();

	// 상품리스트 출력
	public List<OrderVO> findAll(String search) {
		return template.query(
				"SELECT PROD_ID,PROD_NAME, PROD_PRICE FROM PROD WHERE PROD_ID like '%' || ? || '%' ORDER BY 1",
				new BeanPropertyRowMapper<>(OrderVO.class), search);
	}

	public OrderVO findByProdId(int prodId) {
		return template.queryForObject("SELECT PROD_ID, PROD_NAME, PROD_PRICE FROM PROD WHERE PROD_ID = ?",
				new BeanPropertyRowMapper<>(OrderVO.class), prodId);
	}

	// 상품선택
	public List<OrderVO> selectProd() {
		return template.query("SELECT PROD_ID, PROD_NAME, PROD_PRICE FROM PROD WHERE PROD_ID = ? ",
				new BeanPropertyRowMapper<>(OrderVO.class));
	}

	public int insertOrd(OrderVO vo) {
		// return template.update("INSERT INTO ORD (ORD_CODE, ORD_QTY, MEM_ID, ORD_DATE,
		// ORD_SUM) VALUES (?, ?, ?, sysdate, ?)",
		// vo.getOrdCode(),vo.getOrdQty(),mVo.getMemId(),vo.getOrdSum());
		//
		return template.update(
				"INSERT INTO ORD(ORD_CODE, MEM_ID, ORD_DATE, ORD_SUM, ORD_QTY, PROD_ID) VALUES (?,?,SYSDATE, ?, ?,?)",
				vo.getOrdCode(), vo.getMemId(), vo.getOrdSum(), vo.getOrdQty(), vo.getProdId());

	}

	public int insertPastOrd(OrderVO vo) {
		return template.update("INSERT INTO PASTORD(ORD_CODE, MEM_ID) VALUES (?,?)", vo.getOrdCode(), vo.getMemId());
	}

}