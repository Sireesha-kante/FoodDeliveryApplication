<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.foodAppModule.CartItem, com.foodAppModule.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>
<style>
body {
    font-family: Okra, Helvetica, sans-serif;
  
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    color: #ff6347; /* Tomato color for headings */
    margin-top: 20px;
}

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: white;
    padding: 10px 20px;
    color: #ff6347;
}

nav .left-section {
    display: flex;
    align-items: center;
}

nav .left-section h2 {
    margin: 0;
    font-size: 30px;
}

nav .right-section {
      display: flex;
            align-items: center;
            gap: 15px;
}

nav .right-section a {
       text-decoration: none;
            color: #ff6347;
            font-weight: bold;
            padding: 10px 15px;
            border: 2px solid #ff6347;
            border-radius: 30px;
            transition: background-color 0.3s, color 0.3s;
}
nav .right-section button{
   text-decoration: none;
            color: #ff6347;
            font-weight: bold;
            padding: 10px 15px;
            border: 2px solid #ff6347;
            border-radius: 30px;
            transition: background-color 0.3s, color 0.3s;
}

nav .right-section button:hover {
    background-color: #ff6347;
            color: #fff;
}


nav .right-section a:hover {
    background-color: #ff6347;
            color: #fff;
}

.menu-container {
    width: 80%;
    margin: 20px auto;
    background-color: white;
    padding: 20px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

.cart-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #ddd;
    padding: 15px 0;
}

.cart-item img {
    width: 120px;
    height: 120px;
    border-radius: 7px;
    margin-right: 20px;
}

.item-details {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
}

.item-details h3 {
    font-size: 18px;
    color: #333;
    margin: 0;
}

.item-details p {
    font-size: 14px;
    color: #888;
    margin: 5px 0;
}

.price {
    font-size: 16px;
    color: #ff6347;
    font-weight: bold;
}

.cart-item form {
    display: inline-block;
    margin-left: 20px;
}

.cart-item button.update {
    background-color: #4CAF50; /* Green for 'Update' */
    color: #fff;
    border: none;
    padding: 8px 12px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
}

.cart-item button.update:hover {
    background-color: #45a049;
}

.cart-item button.remove {
    background-color: red; /* Opposite color for 'Remove' */
    color: #fff;
    border: none;
    padding: 8px 12px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
}

.cart-item button.remove:hover {
    background-color: darkred;
}

.action-buttons {
    text-align: center;
    margin-top: 30px;
}

.action-buttons button {
    background-color: #4CAF50; /* Green for 'Proceed to Pay' */
    color: white;
    border: none;
    padding: 12px 24px;
    font-size: 18px;
    font-weight: bold;
    border-radius: 5px;
    cursor: pointer;
    margin: 0 10px; /* Add space between buttons */
}

.action-buttons button.add-more:hover {
     background-color: #45a049;
}

.action-buttons button.proceed-pay:hover {
    background-color: #45a049;
}

.total-amount {
    font-weight: bold;
    font-size: 18px;
    color: #ff6347;
    text-align: center;
    margin-top: 10px;
}
</style>
</head>
<body>

<!-- Navbar section -->
<nav>
    <div class="left-section">
        <h2>The Food Hub</h2>
    </div>
    <div class="right-section">
        <a href="OrderHistory.jsp">Order History</a>
         <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="clear">   
                <button type="submit">Clear Cart</button>   
            </form>
        <a href="Logout.jsp">Logout</a>
        
    </div>
</nav>

<!-- Cart Section -->
<h1>My Cart</h1>
<div class="menu-container">
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        double grandTotal = 0.0;
        if (cart != null && !cart.getItems().isEmpty()) {
            CartItem cartItem = null;
            for (Map.Entry<String, CartItem> entry : cart.getItems().entrySet()) {
                cartItem = entry.getValue();
                grandTotal += cartItem.getSubTotal();
    %>
    <div class="cart-item">
        <img src="Images/foodOrder.jpg" alt="<%= cartItem.getItemName() %>">
        <div class="item-details">
            <h3><%= cartItem.getItemName() %></h3>
            <p>Quantity: <%= cartItem.getQuantity() %></p>
            <p class="price">Price: Rs<%= cartItem.getPrice() %></p>
            <p class="price">SubTotal: Rs<%= cartItem.getSubTotal() %></p>
        </div>
        <form action="CartServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
            <input type="hidden" name="itemName" value="<%= cartItem.getItemName() %>">
            Quantity: <input type="number" name="quantity" value="<%= cartItem.getQuantity() %>" min="1">
            <button class="update" type="submit">Update</button>
        </form>
        <form action="CartServlet" method="post">
            <input type="hidden" name="action" value="remove">
            <input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
            <input type="hidden" name="itemName" value="<%= cartItem.getItemName() %>">
            <button class="remove" type="submit">Remove</button>
        </form>
    </div>
    <%
            }
    %>

    <!-- Action Buttons -->
    <div class="action-buttons">

        <!-- Display total amount -->
        <div class="total-amount">
            <p>Total: Rs<%= grandTotal %></p>
        </div>

        <!-- Proceed to Pay Section -->
       <p> <form action="Menu.jsp" method="post">
            <button class="add-more" type="submit">Add More Items</button>
        </form> &nbsp  &nbsp &nbsp  &nbsp 
        <form action="CheckOut.jsp" method="post">
            <input type="hidden" name="totalamount" value="Total: Rs<%= grandTotal %>">
            <input type="hidden" name="action" value="proceed">
            <button class="proceed-pay" type="submit">Proceed to Pay</button>
        </form> </p>
    </div>

    <%
        } else {
    %>

    <!-- Message when cart is empty -->
    <p>Your Cart is Empty</p>

    <!-- Action Buttons for Empty Cart -->
    <div class="action-buttons">
        <form action="Menu.jsp" method="post">
            <button class="add-more" type="submit">Add Items</button>
        </form>
    </div>

    <%
        }
    %>
</div>

</body>
</html>
