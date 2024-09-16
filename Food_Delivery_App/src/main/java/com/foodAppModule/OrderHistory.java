package com.foodAppModule;

import java.util.Date;

public class OrderHistory {
private int OrderHistoryId;
private  int OrderId;
private  int UserId;
private  Date OrderDate;
private  Float TotalAmount;
private  String Status;

public OrderHistory() {
	super();
}

public OrderHistory(int orderHistoryId, int orderId, int userId, Date orderDate, Float totalAmount, String status) {
	super();
	OrderHistoryId = orderHistoryId;
	OrderId = orderId;
	UserId = userId;
	OrderDate = orderDate;
	TotalAmount = totalAmount;
	Status = status;
}


public OrderHistory(int orderId, int userId, Float totalAmount, String status) {
	super();
	OrderId = orderId;
	UserId = userId;
	TotalAmount = totalAmount;
	Status = status;
}

public int getOrderHistoryId() {
	return OrderHistoryId;
}

public void setOrderHistoryId(int orderHistoryId) {
	OrderHistoryId = orderHistoryId;
}

public int getOrderId() {
	return OrderId;
}

public void setOrderId(int orderId) {
	OrderId = orderId;
}

public int getUserId() {
	return UserId;
}

public void setUserId(int userId) {
	UserId = userId;
}

public Date getOrderDate() {
	return OrderDate;
}

public void setOrderDate(Date orderDate) {
	OrderDate = orderDate;
}

public Float getTotalAmount() {
	return TotalAmount;
}

public void setTotalAmount(Float totalAmount) {
	TotalAmount = totalAmount;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

@Override
public String toString() {
	return "OrderHistory [OrderHistoryId=" + OrderHistoryId + ", OrderId=" + OrderId + ", UserId=" + UserId
			+ ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount + ", Status=" + Status + "]";
}



}
