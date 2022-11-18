package Branda;

import Member.MemberController;
import Member.MemberVO;
import Oprod.OprodController;
import PastOrd.PastOrdController;
import ProdOrd.OrderController;
import Sign.SignController;


public class BrandaHome {

    private MemberController memberController = MemberController.getInstance();
    private SignController signController = SignController.getInstance();
    private OrderController orderController = OrderController.getInstance();
    private PastOrdController pastOrdController = PastOrdController.getInstance();
    private OprodController oprodController = OprodController.getInstance();
    private BrandaView view = BrandaView.getInstance();

    public void initialize() {
        home(view.init());
    }
    private void home(int number) {
        loop:
        while (true) {
            try {
                HomeMenu menu = HomeMenu.findMenu(number);
                System.out.print(menu.getMenuString());
                switch (menu) {
                    case HOME:
                    case PROD:
                    case MAIN:
                    case PROD_CART_YN:
                    case PAY:
                    case PAY_PAGE:
                    case MEMBER:
                       number = view.getMenu();
                       break;
                    case MEMBER_INFO:
                    	number = view.getCustomerInfo(memberController);
                    	break;
                  case ORDER:
                    	number = view.getOrdList(pastOrdController);
                    	break;
                    case JOIN:
                        number = view.member(memberController);
                        break;
                    case LOGIN:
                        number = view.login(signController);
                        break;
                    case LOGOUT:
                        number = signController.signOut();
                        break;
                    case PROD_LIST:
                        number = view.getProdList(orderController);
                        break;                	
//                    case PROD_CART:   
//                    case ORDER: 
//                    	number = number = view.getOrdList(pastOrdController);
//                    	break;                	
                    case MODIFY_ADDRESS:
                    	number = view.changeAdd(memberController);
                    	break;
                    case MODIFY_PHONE:
                    	number = view.changePhNum(memberController);
                    	break;
                    case MODIFY_PASSWORD: 
                    	number = view.changePw(memberController);
                    	break;	
                    case QUIT:
                        break loop;
                }
            } catch (MenuNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.print(HomeMenu.HOME.getMenuString());
            }
            System.out.println();
        }
    }
}