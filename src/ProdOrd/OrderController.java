package ProdOrd;

import java.util.List;

import Branda.BrandaApplication;
import Member.MemberVO;


public class OrderController {

   private static OrderController instance = new OrderController();
    public static OrderController getInstance() {
        return instance;
    }
    private OrderController() {}

    private OrderService service = OrderService.getInstance();
    
    //리스트 출력
    public List<OrderVO> selectProdTopList(String search){
       return service.findAll(search);
    }
    
    public OrderVO findByProd(int prodId) {
       return service.findByProdId(prodId);
    }
    
    //상품선택
    public List<OrderVO> selectProd(String string){
       return service.selectProd();
    }
    
//    public int sum(OrderVO vo) {
//       return service.sum(vo);
//    }
    
    public int insertOrd(OrderVO vo) {
       return service.insertOrd(vo);
    }
    
	public int insertPastOrd(String ordCode) {
		MemberVO session = BrandaApplication.getSession();
		OrderVO vo = new OrderVO();
		vo.setOrdCode(ordCode);
		vo.setMemId(session.getMemId());
		return service.insertPastOrd(vo);
	}
    
}