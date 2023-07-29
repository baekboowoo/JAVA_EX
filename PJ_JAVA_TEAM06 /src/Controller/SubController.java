package Controller;

import java.util.Map;

public interface SubController {

	// 1 Select , 2 Insert , 3 Update , 4 Delete
	Map<String, Object> execute(int serviceNo, Map<String, Object> param);

}