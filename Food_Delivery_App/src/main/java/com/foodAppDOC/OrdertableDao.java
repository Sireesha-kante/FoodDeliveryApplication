package com.foodAppDOC;

import java.util.List;

import com.foodAppModule.Ordertable;

public interface OrdertableDao {
	int addOrder(Ordertable ordertable);
	List<Ordertable>getAllOrders();
	Ordertable getOrder(int OrderId);

}
