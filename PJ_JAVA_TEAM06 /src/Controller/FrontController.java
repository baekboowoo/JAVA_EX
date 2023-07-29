package Controller;

import java.util.HashMap;

import java.util.Map;

public class FrontController {

    private Map<String, SubController> map = new HashMap<>();
    // 초기값 설정
    // 사용자 요구사항API Controller에 맞게 저장
    // /
    private void init() {
    	
        map.put("/User", new UserController());
        map.put("/Res", new MenuController());
        map.put("/order", new OrderController());
    }
    //request에 맞는 Controller를 추출, 해당 컨트롤러 실행
    //request, ServiceNo(1 select ,2 insert, 3 update, 4 delete), param
    
    public Map<String, Object> execute(String request, int serviceNo, Map<String, Object> param) {
    	SubController controller = map.get(request);
        Map<String, Object> result = new HashMap<>();

        if (controller instanceof UserController) {
            UserController userController = (UserController) controller;
            result = userController.execute(serviceNo, param);
        } else if (controller instanceof MenuController) {
            MenuController resController = (MenuController) controller;
            result = resController.execute(serviceNo, param);
        } else {
            System.out.println("요청 에러!");
        }

        return result;
    }
}
