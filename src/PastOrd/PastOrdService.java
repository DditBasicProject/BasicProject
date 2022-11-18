package PastOrd;

import java.util.List;

import ProdOrd.OrderVO;

public class PastOrdService {
	private static PastOrdService instance = new PastOrdService();
	public static PastOrdService getInstance() {
		return instance;
	}
	private PastOrdService() {}
	private PastOrdDAO dao = PastOrdDAO.getInstance();

	//회원번호로 주문내역 조회
	public List<PastOrdVO> pastOrdList() {
		return dao.pastOrdList();
	}

	
}
