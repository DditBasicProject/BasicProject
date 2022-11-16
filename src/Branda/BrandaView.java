package Branda;

import java.util.Scanner;

import Member.MemberController;
import Member.MemberVO;
import Order.OrderController;
import Order.OrderVO;
import Sign.SignController;


public class BrandaView {

    private static BrandaView instance = new BrandaView();
    private BrandaView() {}
    public static BrandaView getInstance() {
        return instance;
    }

    Scanner scanner = new Scanner(System.in);

    public int init() {
        System.out.println("모두의 쇼핑몰 브랜다에 오신걸 환영합니다!");
        System.out.print(HomeMenu.HOME.getMenuString());
        return Integer.parseInt(scanner.nextLine());
    }

    public int getMenu() {
        return Integer.parseInt(scanner.nextLine());
    }

    public int member(MemberController controller) {
        int number;
        System.out.print("아이디: ");
        String memId = scanner.nextLine();
        System.out.print("이름: ");
        String memName = scanner.nextLine();
        System.out.print("주소: ");
        String memAdd = scanner.nextLine();
        System.out.print("전화번호: ");
        String memPhone = scanner.nextLine();
        System.out.print("패스워드: ");
        String memPw = scanner.nextLine();
        number = controller.join(new MemberVO(memId, memName, memAdd, memPhone, memPw));
        if (number == HomeMenu.HOME.getMenu()) {
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
        } else {
            System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
            String inputFlag = scanner.nextLine();
            if (inputFlag.equalsIgnoreCase("y")) {
                number = HomeMenu.JOIN.getMenu();
            } else {
                number = HomeMenu.HOME.getMenu();
            }
        }
        return number;
   }
    public int login(SignController controller) {
        int number;
//        scanner.nextLine();
        System.out.print("아이디: ");
        String memId = scanner.nextLine();
        System.out.print("패스워드: ");
        String memPw = scanner.nextLine();
        MemberVO vo = controller.signIn(new MemberVO(memId, memPw));
        if (vo != null) {
            System.out.println(vo.getMemName() + "님 로그인되었습니다.");
            number = HomeMenu.MAIN.getMenu();
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
            number = HomeMenu.HOME.getMenu();
        }
        return number;
    }
    
    // 상품리스트 출력
    public int getProdList(OrderController controller) {
    	controller.selectProdTopList("").forEach(OrderVO ->{
    		System.out.printf("%d\t%s\t%d\t%d\n", OrderVO.getProdId(),OrderVO.getProdName(),OrderVO.getProdQty(),OrderVO.getProdPrice());
    	});
    	boolean flag = true;
    	while (flag) {
    		flag = putCart(controller);
		}
    	return HomeMenu.PROD.getMenu();
    }
    
    private boolean putCart(OrderController controller) {
    	//상품선택
    	OrderVO vo = new OrderVO();
    	System.out.print("상품 선택> ");
    	int selectedProdId = Integer.parseInt(scanner.nextLine());
    	vo.setProdId(selectedProdId);
    	System.out.print("수량> ");
    	int qty = Integer.parseInt(scanner.nextLine());
    	vo.setProdQty(qty);

    	//주문번호 생성
    	vo.setOrdCode("0000001");
    	
    	//장바구니 담기
    	int insertOprod = controller.insertOprod(vo);
    	if (insertOprod > 0) {
			System.out.println("장바구니에 담겼습니다.");
		} else {
			System.out.println("장바구니 담기실패");
		}
    	System.out.println("추가할 상품이 있습니까?(Yes/no)");
    	String more = scanner.nextLine();
    	if (more.equalsIgnoreCase("yes") || more.equals("")) {
			return true;
		} else {
			return false;
		}
    }

    public int searchProd(OrderController controller) {
    	scanner.nextLine();
    	String search = scanner.nextLine();
    	controller.selectProdTopList(search).forEach(OrderVO ->{
    		System.out.printf("%d\t%s\t%d\t%d\n", OrderVO.getProdId(),OrderVO.getProdName(),OrderVO.getProdQty(),OrderVO.getProdPrice());
    	});
    	return HomeMenu.PROD_LIST.getMenu();
    }
    



    //회원정보 수정
    public int editAdd(MemberController controller, HomeMenu menu) {
        scanner.nextLine();
        int result = controller.modifyInfo(scanner.nextLine(), menu);
        if (result == 1) {
           System.out.println("정상적으로 수정되었습니다.");
        }
        return HomeMenu.MEMBER.getMenu();
     }
     
     public int changePw(MemberController controller) {
        String newPw = scanner.nextLine();
        System.out.println("비밀번호 확인을 위해 다시 한번 입력해주세요:");
        String confirmPw = scanner.nextLine();
        if(newPw.equals(confirmPw)) {
           controller.modifyPassword(confirmPw);
           
           System.out.println("비밀번호가 변경되었습니다.");
        } else {
          System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다."); 
        }
        return HomeMenu.MEMBER.getMenu();
     }
     public int changeAdd(MemberController controller) {
        scanner.nextLine();
        System.out.println("변경하실 주소를 입력해주세요:");
        String newAdd = scanner.nextLine();
        System.out.println("주소가 변경되었습니다.");
        return HomeMenu.MEMBER.getMenu();
     }  
     public int changePhNum(MemberController controller) {
        scanner.nextLine();
        System.out.println("변경하실 전화번호를 입력해주세요");
        String newPhNum = scanner.nextLine();
        System.out.println("전화번호가 변경되었습니다.");
        return HomeMenu.MEMBER.getMenu();
     }


    


}
