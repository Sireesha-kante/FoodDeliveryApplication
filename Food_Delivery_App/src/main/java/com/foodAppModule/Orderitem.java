package com.foodAppModule;

public class Orderitem {
private int OrderItemId;
private int OrderId;
private  int MenuId;
private int Quantity;
private  float SubTotal;
public Orderitem() {
	super();
}
public Orderitem(int orderItemId, int orderId, int menuId, int quantity, float subTotal) {
	super();
	OrderItemId = orderItemId;
	OrderId = orderId;
	MenuId = menuId;
	Quantity = quantity;
	SubTotal = subTotal;
}


public Orderitem(int orderId, int menuId, int quantity, float subTotal) {
	super();
	OrderId = orderId;
	MenuId = menuId;
	Quantity = quantity;
	SubTotal = subTotal;
}
public int getOrderItemId() {
	return OrderItemId;
}
public void setOrderItemId(int orderItemId) {
	OrderItemId = orderItemId;
}
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public int getMenuId() {
	return MenuId;
}
public void setMenuId(int menuId) {
	MenuId = menuId;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public float getSubTotal() {
	return SubTotal;
}
public void setSubTotal(float subTotal) {
	SubTotal = subTotal;
}
@Override
public String toString() {
	return "Orderitem [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", MenuId=" + MenuId + ", Quantity="
			+ Quantity + ", SubTotal=" + SubTotal + "]";
}


}
