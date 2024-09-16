package com.foodAppDOC;

import java.util.List;

import com.foodAppModule.OrderHistory;

public interface OrderHistoryDao {
	int addOrderHistory(OrderHistory orderhistory);
	List<OrderHistory>getAllOrderHistorys();
	List<OrderHistory> getOrderHistory(int UserId);

}
 