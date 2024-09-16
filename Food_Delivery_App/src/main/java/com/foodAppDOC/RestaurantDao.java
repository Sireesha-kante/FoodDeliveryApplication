package com.foodAppDOC;

import java.util.List;
import com.foodAppModule.Restaurant;


public interface RestaurantDao {
	int addRestaurant(Restaurant restaurant);
	List<Restaurant>getAllRestaurants();
	Restaurant getRestaurant(String RestaurantName)	;
	int updateRestaurant(Restaurant restaurant);
	int  deleteRestaurant(String   RestaurantName);
}
