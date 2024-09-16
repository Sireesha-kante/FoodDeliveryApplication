package com.foodAppModule;

public class Menu {
private int MenuId;
private int RestaurantId;
private String MenuName;
private String Description;
private float Price;
private String isAvailable;
private String imgPath;
public Menu() {
	super();
	// TODO Auto-generated constructor stub
}
public Menu(int menuId, int restaurantId, String menuName, String description, float price, String isAvailable,
		String imgPath) {
	super();
	this.MenuId = menuId;
this.RestaurantId = restaurantId;
	this.MenuName = menuName;
	this.Description = description;
	this.Price = price;
	this.isAvailable = isAvailable;
	this.imgPath = imgPath;
}
public Menu(String menuName, String description, float price, String isAvailable, String imgPath) {
	super();
	MenuName = menuName;
	Description = description;
	Price = price;
	this.isAvailable = isAvailable;
	this.imgPath = imgPath;
}
public int getMenuId() {
	return MenuId;
}
public void setMenuId(int menuId) {
	MenuId = menuId;
}
public int getRestaurantId() {
	return RestaurantId;
}
public void setRestaurantId(int restaurantId) {
	RestaurantId = restaurantId;
}
public String getMenuName() {
	return MenuName;
}
public void setMenuName(String menuName) {
	MenuName = menuName;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public float getPrice() {
	return Price;
}
public void setPrice(float price) {
	Price = price;
}
public String getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(String isAvailable) {
	this.isAvailable = isAvailable;
}
public String getImgPath() {
	return imgPath;
}
public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}
@Override
public String toString() {
	return "Menu [MenuId=" + MenuId + ", RestaurantId=" + RestaurantId + ", MenuName=" + MenuName + ", Description="
			+ Description + ", Price=" + Price + ", isAvailable=" + isAvailable + ", imgPath=" + imgPath + "]";
}



}
