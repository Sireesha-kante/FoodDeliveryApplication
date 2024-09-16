package com.foodAppDOC;

import java.util.List;
import com.foodAppModule.Menu;

public interface MenuDao {
	int addMenu(Menu menu);
	List<Menu>getAllMenu();
	List<Menu> getMenu(int RestaurantId);
	
	int updateMenu(Menu menu);
	int  deleteMenu(String MenuName);
}
