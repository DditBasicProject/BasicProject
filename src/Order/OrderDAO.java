package Order;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Branda.BrandaApplication;

import java.util.Scanner;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	Scanner scanner = new Scanner(System.in);
	private OrderDAO() {}
	
	private JdbcTemplate template = BrandaApplication.getTemplate();

	//상품리스트 출력
    public List<OrderVO> findAll(String search) {
	    return template.query("SELECT PROD_ID, PROD_NAME, PROD_QTY, PROD_PRICE FROM PROD WHERE PROD_ID like '%' || ? || '%' ORDER BY 1", new BeanPropertyRowMapper<>(OrderVO.class), search);
	}

	public OrderVO findByProdId(int prodId) {
	    return template.queryForObject("SELECT PROD_ID, PROD_NAME, PROD_QTY, PROD_PRICE FROM PROD WHERE PROD_ID = ?", new BeanPropertyRowMapper<>(OrderVO.class), prodId);
	}
	//상품선택
	public List<OrderVO> selectProd() {
		return template.query("SELECT PROD_ID, PROD_NAME, PROD_PRICE FROM PROD WHERE PROD_ID = ? ",new BeanPropertyRowMapper<>(OrderVO.class));
	}
	//주문번호에 상품넣는 것
	public int insertOprod(OrderVO vo) {
		return template.update("INSERT INTO OPROD (PROD_ID, ORD_CODE, OPROD_QTY) VALUES (?, ?, ?)", vo.getProdId(),vo.getOrdCode(),vo.getOprodQty());
	}

//	//주문번호 생성
//	public int OrdCode(OrderVO vo) {
//		return template.update("SELECT MAX(TO_NUMBER(ORD_CODE))FROM OPROD",vo.getOrdCode()+1);
//	}
//	    
	
//	public int insertOrdCode(OrderVO vo) {
//		return template.update("INSERT INTO ORD(ORD_CODE, ORD_QTY, MEM_ID, ORD_DATE, ORD_SUM) VALUES("
//				+ "(SELECT NVL(MAX(REVIEW_ID),0) + 1 FROM REVIEW),?,?,?,?) "
//						, vo.()
//						, vo.getReviewTitle()
//						, vo.getReviewContent()
//						, vo.getReviewGrade());
//		}
}

