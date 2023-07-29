package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.Dto.MenuDto;

public class TUIMenu {

	Scanner sc = new Scanner(System.in);
	FrontController controller = new FrontController();

	public void main() {
		while (true) {
			System.out.println("------MAIN-------");
			System.out.println("1 매장추가");
			System.out.println("2 유저추가");
			System.out.println("3 주문하기");
			System.out.println("4 주문확인");
			System.out.println("5 종료");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("매장ID/매장PW/매장명/매장주소/연락처입력 : ");
				String res_id = sc.next();
				String res_pw = sc.next();
				String res_name = sc.next();
				String res_addr = sc.next();
				String res_phone = sc.next();
				List<MenuDto> menus = new ArrayList();
				while (true) {
					System.out.print("ID|NAME|PRICE 순으로 입력(-1 : 종료) : ");
					String menu_id = sc.next();
					String menu_name = sc.next();
					int price = sc.nextInt();
					if (menu_id.equals("-1")) {
						break;
					}
					menus.add(new MenuDto(menu_id, menu_name, price));

				}
				Map<String, Object> param = new HashMap();
				param.put("res_id", res_id);
				param.put("res_pw", res_pw);
				param.put("res_name", res_name);
				param.put("res_addr", res_addr);
				param.put("res_phone", res_phone);
				param.put("menus", menus);

				Map<String, Object> result = new HashMap();
				result = controller.execute("/Res", 1, param);
				boolean isAdded = (boolean) result.get("result");
				System.out.println("매장 추가 여부 : " + isAdded);

				break;
			case 2:
				System.out.println("ID/PW/NAME/ADDR/PHONE : ");
				String id = sc.next();
				String pw = sc.next();
				String name = sc.next();
				String addr = sc.next();
				String phone = sc.next();
				String role = "ROLE_USER";

				Map<String, Object> paramUser = new HashMap();
				paramUser.put("id", id);
				paramUser.put("pw", pw);
				paramUser.put("name", name);
				paramUser.put("addr", addr);
				paramUser.put("phone", phone);
				paramUser.put("role", role);
				Map<String, Object> resultUser = new HashMap();
				resultUser = controller.execute("/User", 2, paramUser);
				boolean isUserAdd = (boolean) resultUser.get("result");
				System.out.println("유저 가입 확인 : " + isUserAdd);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:

			}
		}
	}
}
