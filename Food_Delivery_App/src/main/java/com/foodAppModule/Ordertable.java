package com.foodAppModule;

import java.util.Date;

public class Ordertable {
	
private int OrderId;
private int RestaurantId;
private int UserId;
private Date OrderDate;
private float TotalAmount;
private String Status;
private String PaymentMode;

public Ordertable()
{
	
}

public Ordertable(int orderId, int restaurantId, int userId, Date orderDate, float totalAmount, String status,
		String paymentMode) {
	super();
	this.OrderId = orderId;
	this.RestaurantId = restaurantId;
	this.UserId = userId;
	this.OrderDate = orderDate;
	this.TotalAmount = totalAmount;
	this.Status = status;
	this.PaymentMode = paymentMode;
}


public Ordertable(int restaurantId, int userId, float totalAmount, String status, String paymentMode) {
	super();
	this.RestaurantId = restaurantId;
	this.UserId = userId;
	this.TotalAmount = totalAmount;
	this.Status = status;
	this.PaymentMode = paymentMode;
}

public int getOrderId() {
	return OrderId;
}

public void setOrderId(int orderId) {
	OrderId = orderId;
}

public int getRestaurantId() {
	return RestaurantId;
}

public void setRestaurantId(int restaurantId) {
	RestaurantId = restaurantId;
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

public float getTotalAmount() {
	return TotalAmount;
}

public void setTotalAmount(float totalAmount) {
	TotalAmount = totalAmount;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public String getPaymentMode() {
	return PaymentMode;
}

public void setPaymentMode(String paymentMode) {
	PaymentMode = paymentMode;
}

@Override
public String toString() {
	return "Ordertable [OrderId=" + OrderId + ", RestaurantId=" + RestaurantId + ", UserId=" + UserId + ", OrderDate="
			+ OrderDate + ", TotalAmount=" + TotalAmount + ", Status=" + Status + ", PaymentMode=" + PaymentMode + "]";
}


}
