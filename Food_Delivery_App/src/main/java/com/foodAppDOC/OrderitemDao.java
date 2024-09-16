package com.foodAppDOC;

import java.util.List;

import com.foodAppModule.Orderitem;

public interface OrderitemDao {
	int addOrderitem(Orderitem orderitem);
	List<Orderitem>getAllOrderitems();
	Orderitem getOrder(int OrderId);
}
