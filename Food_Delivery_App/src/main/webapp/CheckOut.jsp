<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.foodAppModule.CartItem, com.foodAppModule.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<style>
body {
    font-family: 'Okra', Helvetica, sans-serif;
    background-color: #f4f4f4;
    padding: 20px;
}

h1 {
    text-align: center;
    color: #ff6347; /* Tomato color */
    margin-top: 20px;
}

.checkout-container {
    max-width: 900px;
    margin: auto;
    padding: 20px;
    background: #fff;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

.cart-item {
    border-bottom: 1px solid #ddd;
    padding: 10px 0;
    display: flex;
    justify-content: space-between;
    color: #333;
}

.cart-item p {
    margin: 0;
    font-size: 14px;
}

.item-details {
    text-align: right;
}

.item-details p {
    color: #666;
    font-size: 14px;
}

.price {
    font-weight: bold;
    color: #ff6347; /* Tomato color */
}

.address-payment-container {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

.address-container,
.payment-container {
    width: 48%;
}

.address-container label,
.payment-container label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    font-size: 14px;
}

.address-container input,
.address-container textarea,
.payment-container select {
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ddd;
    margin-bottom: 10px;
}

textarea {
    height: 50px;
}

.checkout-button {
    text-align: center;
    margin-top: 20px;
}

.checkout-button button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #28a745; /* Green */
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.checkout-button button:hover {
    background-color: #218838; /* Darker green */
}

img {
    width: 120px;
    height: 120px;
    border-radius: 7px;
    margin-right: 20px;
    display: block;
    margin: 0 auto 20px; /* Center the image */
}

/* Styling for Grand Total */
.total {
    font-weight: bold;
    color: #333;
    margin-top: 20px;
}

.item-details {
    text-align: right;
    margin-top: 5px;
}
</style>
</head>
<body>
<h1>Checkout</h1>
<div class="checkout-container">
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        double deliveryCharge = 50.0; // Example delivery charge
        double gstRate = 0.18; // 18% GST
        double subTotal = 0.0;
        double gstAmount = 0.0;
        double total = 0.0;

        if (cart != null && !cart.getItems().isEmpty()) {
        	%> <img src="Images/foodOrder.jpg"><%
          
            for (Map.Entry<String, CartItem> entry : cart.getItems().entrySet()) {
                CartItem cartItem = entry.getValue();
                subTotal += cartItem.getSubTotal();
            
            // Calculate GST and total
            gstAmount = subTotal * gstRate;
            total = subTotal + deliveryCharge + gstAmount;
    %>
    <div class="cart-item">
        <div>
            <p><%= cartItem.getItemName() %></p>
        </div>
        <div class="item-details">
            <p>Quantity: <%= cartItem.getQuantity() %></p>
            <p class="price">Price: Rs <%= cartItem.getPrice() %></p>
            <p class="price">SubTotal: Rs <%= cartItem.getSubTotal() %></p>
        </div>
    </div>
    <% } %>
    <form action="OrderItemTable" method="post">
        <div class="address-payment-container">
            <div class="address-container">
                <label for="door-number">Door/Plot Number:</label>
                <input type="text" id="door-number" name="doorNumber" required>

                <label for="area">Area:</label>
                <input type="text" id="area" name="area" required>

                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>

                <label for="pin">PIN Code:</label>
                <input type="text" id="pin" name="pin" required>
            </div>
            
            <div class="payment-container">
                <label for="payment-method">Payment Method:</label>
                <input type="hidden" value="paymentMethod">
                <select id="payment-method" name="paymentMethod" required>
                    <option value="credit_card">Credit Card</option>
                    <option value="debit_card">Debit Card</option>
                    <option value="paypal">PayPal</option>
                    <option value="net_banking">Net Banking</option>
                    <option value="cash_on_delivery">Cash on Delivery</option>
                </select>
            </div>
        </div>

        <p class="total">SubTotal: <div class="item-details">Rs <%= subTotal %></div></p>
        <p class="total">GST: <div class="item-details">Rs <%= gstAmount %></div></p>
        <p class="total">Delivery Charge: <div class="item-details">Rs <%= deliveryCharge %></div></p>
        <p class="total">Grand Total: <div class="item-details">Rs <%= total %></div></p>
        <input type="hidden" name="GrandTotal" value="<%= total %>">
        
        <div class="checkout-button">
            <input type="hidden" name="action" value="confirm">
            <button type="submit">Confirm Order</button>
        </div>
    </form>
    <% } else { %>
        <p>Your cart is empty. <a href="Menu.jsp">Add items to your cart</a></p>
    <% } %>
</div>
</body>
</html>
