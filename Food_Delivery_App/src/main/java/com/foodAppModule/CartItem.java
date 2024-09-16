package com.foodAppModule;

public class CartItem {
    private String itemId;
    private String restaurantId;
    private String itemName;
    private int quantity;
    private double price;
    private double subTotal;

    public CartItem(String itemId, String restaurantId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
    
  
    public CartItem() {
		super();
	}


	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName
				+ ", quantity=" + quantity + ", price=" + price + ", subTotal=" + subTotal + "]";
	}

	public String getItemId() {
        return itemId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSubTotal() {
        subTotal= (quantity * price);
        return subTotal;
    }

}
