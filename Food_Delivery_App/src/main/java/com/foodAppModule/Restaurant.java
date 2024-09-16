package com.foodAppModule;


public class Restaurant {
private int RestaurantId;
private String RestaurantName;
private int DeliveryTime;
private String CuisineType;
private String Address;
private float Rating;
private String isActive;
private int AdminId;
private String imgPath;

public Restaurant ()
{}

public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cuisineType, String address,
		float rating, String isActive, int adminId, String imgPath) {
	super();
	this.RestaurantId = restaurantId;
	this.RestaurantName = restaurantName;
	this.DeliveryTime = deliveryTime;
	this.CuisineType = cuisineType;
	this.Address = address;
	this.Rating = rating;
	this.isActive = isActive;
	this.AdminId = adminId;
	this.imgPath = imgPath;
}
public Restaurant(String restaurantName, int deliveryTime, String cuisineType, String address, float rating,
		String isActive, int adminId, String imgPath) {
	super();
	this.RestaurantName = restaurantName;
	this.DeliveryTime = deliveryTime;
	this.CuisineType = cuisineType;
	this.Address = address;
	this.Rating = rating;
	this.isActive = isActive;
	this.AdminId = adminId;
	this.imgPath = imgPath;
}

public int getRestaurantId() {
	return RestaurantId;
}
public void setRestaurantId(int restaurantId) {
	RestaurantId = restaurantId;
}
public String getRestaurantName() {
	return RestaurantName;
}
public void setRestaurantName(String restaurantName) {
	RestaurantName = restaurantName;
}
public int getDeliveryTime() {
	return DeliveryTime;
}
public void setDeliveryTime(int deliveryTime) {
	DeliveryTime = deliveryTime;
}
public String getCuisineType() {
	return CuisineType;
}
public void setCuisineType(String cuisineType) {
	CuisineType = cuisineType;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public float getRating() {
	return Rating;
}
public void setRating(float rating) {
	Rating = rating;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public int getAdminId() {
	return AdminId;
}
public void setAdminId(int adminId) {
	AdminId = adminId;
}
public String getImgPath() {
	return imgPath;
}
public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}
@Override
public String toString() {
	return "Restaurant [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", DeliveryTime="
			+ DeliveryTime + ", CuisineType=" + CuisineType + ", Address=" + Address + ", Rating=" + Rating
			+ ", isActive=" + isActive + ", AdminId=" + AdminId + ", imgPath=" + imgPath + "]";
}

}
