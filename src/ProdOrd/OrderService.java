package ProdOrd;

import java.util.List;

import Member.MemberVO;

public class OrderService {

	public static OrderService instance = new OrderService();

	public static OrderService getInstance() {
		return instance;
	}

	private OrderService() {
	}

	private OrderDAO dao = OrderDAO.getInstance();

	// 리스트
	public List<OrderVO> findAll(String search) {
		return dao.findAll(search);
	}

	public OrderVO findByProdId(int prodId) {
		return dao.findByProdId(prodId);
	}

	// 상품선택
	public List<OrderVO> selectProd() {
		return dao.selectProd();
	}

//   public int sum(OrderVO vo) {
//      return dao.(vo);
//   }
//   
	public int insertOrd(OrderVO vo) {
		return dao.insertOrd(vo);
	}

	public int insertPastOrd(OrderVO vo) {
		return dao.insertPastOrd(vo);
	}

}