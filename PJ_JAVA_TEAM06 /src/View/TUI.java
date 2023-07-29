package View;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.Dto.ResDto;

public class TUI {
    private Scanner sc = new Scanner(System.in);

    private FrontController controller;
    String sid;
    String role;
    public TUI() {
        controller = new FrontController();
    } 

    public void loginMenu() {
        System.out.println("--------------------------");
        System.out.println("로그인");
        System.out.println("--------------------------");
        System.out.print("ID : ");
        String id = sc.next();
        System.out.print("PW : ");
        String pw = sc.next();

        // 로그인 성공!!
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("pw", pw);

        Map<String, Object> result = controller.execute("/Member", 1, param);
        if (result != null) {
            sid = (String) result.get("sid");
            role = (String) result.get("role");
            System.out.println(sid+" "+role );
            if (sid != null) {
            	// 로그인 성공 메시지 출력
                System.out.println("로그인 성공");     
                매장목록조회함수();
            }
            else
            {
            	
            }
        }
    }
    
    public void 매장목록조회함수()
    {	//
    	if (role != null && role.equals("ROLE_RES")){
            Map<String, Object> resParam = new HashMap<>();
            resParam.put("sid", sid);
            Map<String, Object> resResult = controller.execute("/Res", 1, resParam);
            List<ResDto> resList = (List<ResDto>) resResult.get("result");
            if (resList != null && !resList.isEmpty()) {
                System.out.println("--------------------------");
                System.out.println("매장 목록");
                System.out.println("--------------------------");
                for (ResDto res : resList) {
                    System.out.println("매장 ID: " + res.getRes_id());
                    System.out.println("매장 이름: " + res.getRes_name());
                    System.out.println("매장 주소: " + res.getRes_addr());
                    System.out.println("매장 전화번호: " + res.getRes_phone());
                    System.out.println("--------------------------");
                }
                
            } else {
                System.out.println("조회된 매장이 없습니다.");
            } 
    }
   
    
}}
