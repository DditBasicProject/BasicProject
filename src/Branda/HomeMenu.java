package Branda;

import java.util.Scanner;

public enum HomeMenu {
    HOME(-1, "8.로그인\t2.회원가입\t0.프로그램 종료\n메뉴를 선택하세요: "),
    QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
    MAIN(1, "3.주문\t40.리뷰작성\t5.마이페이지\t9.로그아웃\t\n메뉴를 선택하세요: "),
    JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n"),
    PROD(3, "31.쇼핑하기\t32.장바구니\t1.돌아가기\n메뉴를 선택하세요: "),
    ORDER(4, "주문 확인\n"),
    PROD_LIST(31, "전체 상품목록\n "),
    MEMBER(5, "51.패스워드수정\t52.전화번호수정\t53.주소변경\t1.돌아가기\n메뉴를 선택하세요: "),
    LOGIN(8, "아이디와 비밀번호를 입력하세요.\n"),
    LOGOUT(9, "로그아웃 되었습니다!\n"),
//    PROD_CART(20, "장바구니에 담을 상품을 입력하세요: "),
    PROD_CART_YN(32, "80.결제하기\t1.주문으로 돌아가기 "),
    MODIFY_ADDRESS(53, "주소 수정\n변경할 주소를 입력하세요: "),
    MODIFY_PHONE(52, "휴대전화번호 수정\n변경할 휴대전화번호를 입력하세요: "),
    MODIFY_PASSWORD(51, "패스워드 변경\n변경할 패스워드를 입력하세요: "),
	REVIEW(40, "41.등록하기\t42.수정하기\t43.삭제하기\t1.돌아가기 "),
	REVIEW_INSERT(41, "리뷰 등록이 완료되었습니다\t40.돌아가기"),
	REVIEW_UPDATE(42, "리뷰 수정이 완료되었습니다\t40.돌아가기"),
	REVIEW_DELETE(43, "리뷰 삭제가 완료되었습니다\t40.돌아가기 ");

	
    private final int menu;
    private final String menuString;

    HomeMenu(int menu, String menuString) {
        this.menu = menu;
        this.menuString = menuString;
    }

    public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }

    public static HomeMenu findMenu(int number) throws MenuNotFoundException {
        for (HomeMenu menu: values()) {
            if (menu.getMenu() == number) {
                return menu;
            }
        }
        throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
    }
    public void display(Scanner scanner) {
    }
}