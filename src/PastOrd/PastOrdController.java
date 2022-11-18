package PastOrd;

import java.util.List;

import ProdOrd.OrderVO;

public class PastOrdController {
	public	static PastOrdController instance = new PastOrdController();
	public static PastOrdController getInstance() {
		return instance;
		}
	private PastOrdController() {}
	private PastOrdService service = PastOrdService.getInstance();
	
	public PastOrdController(PastOrdService service) {
		this.service = service;
	}
	
	public List<PastOrdVO> pastOrdList() {
		return service.pastOrdList();
	}


	
}
