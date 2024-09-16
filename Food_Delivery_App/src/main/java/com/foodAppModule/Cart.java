package com.foodAppModule;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items = new HashMap<>();

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        String key = item.getItemId() + "_" + item.getItemName();
        if (items.containsKey(key)) {
            CartItem existingItem = items.get(key);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(key, item);
        }
    }

    @Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	public void updateItem(String key, int quantity) {
        if (items.containsKey(key)) {
            CartItem item = items.get(key);
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                items.remove(key); // Remove the item if the quantity is set to 0 or less
            }
        }
    }


    public void removeItem(String key) {
        items.remove(key);
    }

    public void clear() {
        items.clear();
    }

}
