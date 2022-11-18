package Branda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Member.MemberController;
import Member.MemberVO;
import Oprod.OprodController;
import Oprod.OprodVO;
import PastOrd.PastOrdController;
import PastOrd.PastOrdVO;
import ProdOrd.OrderController;
import ProdOrd.OrderVO;
import Sign.SignController;

public class BrandaView {
	private MemberVO session = BrandaApplication.getSession();
	private static BrandaView instance = new BrandaView();

	private BrandaView() {
	}

	public static BrandaView getInstance() {
		return instance;
	}

	Scanner scanner = new Scanner(System.in);
	private MemberVO mVo;

	//
	OrderVO ord = new OrderVO();

	public int init() {
		System.out.println();
		System.out.println("=============<모두의 쇼핑몰 브랜다에 오신걸 환영합니다!>=================");
		System.out.println();
		System.out.print(HomeMenu.HOME.getMenuString());
		return Integer.parseInt(scanner.nextLine());
	}

	public int getMenu() {
		return Integer.parseInt(scanner.nextLine());
	}

	// 상품리스트 출력
	public int getProdList(OrderController controller) {
		// 추가한 내용
		LocalDateTime now = LocalDateTime.now();
		String ordCode = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		controller.insertPastOrd(ordCode);
		
		List<OrderVO> orderList = controller.selectProdTopList("");
		orderList.forEach(OrderVO -> {
			System.out.printf("%d\t%s\t\t%,d원\t\n", OrderVO.getProdId(), OrderVO.getProdName(), OrderVO.getProdPrice());
		});

		boolean flag = true;
		while (flag) {
			flag = putCart(controller, orderList, ordCode);
		}
		return HomeMenu.PROD.getMenu();
	}

	private boolean putCart(OrderController controller, List<OrderVO> list, String ordCode) {
		OrderVO vo = new OrderVO();
		// 생성된 주문번호를 카트에 등록할 때마다 가져와서 추가
		vo.setOrdCode(ordCode);
		System.out.println("========================================================");
		System.out.print(" 상품 선택 =>  ");
		int selectedProdId = Integer.parseInt(scanner.nextLine());
		vo.setProdId(selectedProdId);

		OrderVO selectedProdVO = list.stream().filter(v -> v.getProdId() == selectedProdId).findFirst().get();

		System.out.print(" 수량 => ");
		int qty = Integer.parseInt(scanner.nextLine());
		vo.setOrdQty(qty);
		vo.setProdPrice(selectedProdVO.getProdPrice());

		// 구매금액 합계 변수 설정해서 넣어주기
//       if(selectedProdId == vo.getProdId()) {
//       int sum =controller.sum(vo);
//       vo.setOrdSum(ord.getOrdSum());
//       }

		vo.setMemId(mVo.getMemId());
		int insertOprod = controller.insertOrd(vo);
		if (insertOprod > 0) {
			System.out.println();
			System.out.println(" 장바구니에 담겼습니다 o(￣▽￣)ｄ");
		} else {
			System.out.println();
			System.out.println(" 장바구니 담기실패 o(TヘTo)");
		}
		System.out.print("추가할 상품이 있습니까?(Y/N)");
		String more = scanner.nextLine();
		if (more.equalsIgnoreCase("y") || more.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public int searchProd(OrderController controller) {
		scanner.nextLine();
		String search = scanner.nextLine();
		controller.selectProdTopList(search).forEach(OrderVO -> {
			System.out.printf("%d\t%s\t%d\t%d\n", OrderVO.getProdId(), OrderVO.getProdName(), OrderVO.getOrdQty(),
					OrderVO.getProdPrice());
		});
		return HomeMenu.PROD_LIST.getMenu();
	}

	public int member(MemberController controller) {
		int number;
		System.out.print(" 아이디 : ");
		String memId = scanner.nextLine();
		System.out.print(" 패스워드 : ");
		String memPw = scanner.nextLine();
		System.out.print(" 이름 : ");
		String memName = scanner.nextLine();
		System.out.print(" 전화번호 : ");
		String memPhone = scanner.nextLine();
		System.out.print(" 주소 : ");
		String memAdd = scanner.nextLine();
		number = controller.join(new MemberVO(memId,memPw,memName, memPhone, memAdd));
		if (number == HomeMenu.HOME.getMenu()) {
			System.out.println("☆ 회원가입이 완료되었습니다. 로그인해주세요 ☆");
		} else {
			System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까? (y 또는 n을 입력) : ");
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
		System.out.print(" 아이디 : ");
		String memId = scanner.nextLine();
		System.out.print(" 패스워드 : ");
		String memPw = scanner.nextLine();
		mVo = controller.signIn(new MemberVO(memId, memPw));
		if (mVo != null) {
			System.out.println();
			System.out.println(mVo.getMemName() + "님 로그인되었습니다.");
			number = HomeMenu.MAIN.getMenu();
		} else {
			System.out.println();
			System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.⊙.☉");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	////// 회원정보 수정
	/// 회원정보 수정 확인용
	public int getCustomerInfo(MemberController controller) {
		MemberVO customer = controller.findMemberVO();
		System.out.printf("아이디 : %s\n", customer.getMemId());
		System.out.printf("이름 : %s\n", customer.getMemName());
		System.out.printf("주소 : %s\n", customer.getMemAdd());
		System.out.printf("휴대전화번호 : %s\n", customer.getMemPhone());
		return HomeMenu.MEMBER.getMenu();
	}

	// 주문내역 확인
	public int getOrdList(PastOrdController controller) {
		List<PastOrdVO> pastOrdList = controller.pastOrdList();
		pastOrdList.forEach(vo -> {
			System.out.printf("주문번호: %s\t주문일자: %s\n", vo.getOrdCode(), vo.getOrdDate());
		});
		return HomeMenu.MEMBER.getMenu();

	}

	public int changePw(MemberController controller) {
		String newPw = scanner.nextLine();
		System.out.println("비밀번호 확인을 위해 다시 한번 입력해주세요 : ");
		String confirmPw = scanner.nextLine();
		if (newPw.equals(confirmPw)) {
			controller.modifyPassword(confirmPw);
			System.out.println("비밀번호가 변경되었습니다.bㅇㅅㅇb");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다. ㅠ.ㅠ");
		}
		return HomeMenu.MEMBER.getMenu();
	}

	// 주소 변경
	public int changeAdd(MemberController controller) {
		String newAdd = scanner.nextLine();
		controller.modifyAddress(newAdd);
		System.out.println(" 주소가 변경되었습니다.");
		return HomeMenu.MEMBER.getMenu();
	}

	// 전화번호 변경
	public int changePhNum(MemberController controller) {
		String newPhNum = scanner.nextLine();
		controller.modifyPhone(newPhNum);
		System.out.println(" 전화번호가 변경되었습니다.");
		return HomeMenu.MEMBER.getMenu();
	}

	// 주문목록 리스트 출력
	public int getOprodlist(OprodController oprodController, OrderController orderController) {
		OprodVO customer = oprodController.findByOrdVO();
//      OrderVO ordCode = orderController.findByProd(0);
//      System.out.printf("주문번호: %s\n", customer.getOrdCode());
		System.out.printf("회원번호: %s\n", customer.getMemId());
		System.out.printf("상품번호: %s\n", customer.getProdId());
		System.out.printf("상품이름: %s\n", customer.getProdName());
		System.out.printf("주문수량: %s\n", customer.getOprodQty());
		System.out.printf("상품금액: %s\n", customer.getprodPrice());

		return HomeMenu.PAY_PAGE.getMenu();
	}
}