package Branda;

import java.util.Scanner;

public enum HomeMenu {
    HOME(-1, "[8.로그인]\t\t[2.회원가입]\t\t[0.프로그램 종료]\n\n => 메뉴를 선택하세요 : "),
    QUIT(0, "\n[ ♡ ♡ 이용해주셔서 감사합니다 ♡ ♡ ( ﾟдﾟ)つ Bye ]\n"),
    MAIN(1, "[3.주문]\t\t[5.마이페이지]\t\t[9.로그아웃]\n\n => 메뉴를 선택하세요 : "),
    JOIN(2, "[  회원가입에 필요한 정보를 입력해주세요:)  ] \n"),
    PROD(3, "[31.쇼핑하기]\t\t[32.장바구니]\t\t[1.돌아가기]\n\n => 메뉴를 선택하세요 : "),
    ORDER(32, "\t\t[♡ 주문내역조회 ♡]\n"),
    PAY_PAGE(321, "[21.결제페이지]\t\t[1.돌아가기]"),
    PROD_LIST(31, "========================[♡ 전체 상품목록 ♡]========================\n "),
    MEMBER(5, "[50.개인정보 확인]\t[51.패스워드수정]\t[52.전화번호수정]\t[53.주소변경]   [1.돌아가기]\n\n => 메뉴를 선택하세요 : "),
    MEMBER_INFO(50, "['◡' 개인정보 확인 '◡']\n"),
    LOGIN(8, " ♬ 아이디와 비밀번호를 입력하세요 (∩^o^)⊃━☆\n "),
    LOGOUT(9, "[ ･_･ 로그아웃 되었습니다! ･_･ ]\n"),
//    PROD_CART(20, "장바구니에 담을 상품을 입력하세요: "),
    PROD_CART_YN(21, "[ 80.결제하기 ]\t[ 1.주문으로 돌아가기 ]"),
    MODIFY_PASSWORD(51, "[ 패스워드 변경  ]\n변경할 패스워드를 입력하세요 : "),
    MODIFY_PHONE(52, "[ 휴대전화번호 수정 ]\n변경할 휴대전화번호를 입력하세요 : "),
    MODIFY_ADDRESS(53, "[ 주소 수정 ]\n변경할 주소를 입력하세요 : "),
    PAY(80,"[ 결제되었습니다 ] \t[ 1.돌아가기 ]");

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