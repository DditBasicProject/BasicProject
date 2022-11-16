package Order;

import java.util.List;

import Branda.BrandaApplication;


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
    
    public int insertOprod(OrderVO vo) {
    	return service.insertOprod(vo);
    }
  
}
