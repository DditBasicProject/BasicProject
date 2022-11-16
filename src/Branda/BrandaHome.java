package Branda;

import Branda.HomeMenu;
import Branda.MenuNotFoundException;
import Member.MemberController;
import Order.OrderController;
import Sign.SignController;

public class BrandaHome {

    private MemberController memberController = MemberController.getInstance();
    private SignController signController = SignController.getInstance();
    private OrderController orderController = OrderController.getInstance();

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
                    	number = view.getMenu();
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
                    case MEMBER:
                    case PROD_LIST:
                    	number = view.getProdList(orderController);
                    	break;
                    	
//                    case PROD_CART:
//                    	//break;
//                    case PROD_CART_YN:
//                    	//break;
//                    case ORDER:
//                    	//break;
                    case MODIFY_ADDRESS:
                        number = view.changeAdd(memberController);
                        break;
                     case MODIFY_PHONE:
                        number = view.changePhNum(memberController);
                        break;
                     case MODIFY_PASSWORD: 
                        number = view.changePw(memberController);
                        break;
                    case REVIEW:	
                    	//break;
                    case REVIEW_INSERT:	
                    	//break;
                    case REVIEW_UPDATE:	
                    	//break;
                    case REVIEW_DELETE:	
                    	//break;
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
