<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodAppModule.OrderHistory" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<style>
    body {
        font-family: 'Okra', Helvetica, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #ff6347; /* Tomato color */
        margin-top: 20px;
    }

    nav {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #333;
        padding: 10px 20px;
    }

    nav .right-section {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    nav .right-section a {
        text-decoration: none;
        color: white;
        font-weight: bold;
        padding: 10px 15px;
        border: 2px solid #ff6347;
        border-radius: 30px;
        transition: background-color 0.3s, color 0.3s;
    }

    nav .right-section a:hover {
        background-color: #ff6347;
        color: white;
    }

    .OrderHistory-list {
        max-width: 1000px;
        margin: 40px auto;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
    }

    .orderHistory-table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    .orderHistory-table th, .orderHistory-table td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    .orderHistory-table th {
        background-color: #ff6347; /* Tomato color */
        color: white;
    }

    .orderHistory-table td {
        color: #333;
    }

    .orderHistory-table tr:hover {
        background-color: #f1f1f1;
    }

    button {
        background-color: #28a745; /* Green button */
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #218838;
    }

    /* Footer styling */
    footer {
        text-align: center;
        padding: 20px;
        background-color: #333;
        color: white;
        margin-top: 20px;
        font-size: 14px;
    }
</style>
</head>
<body>

<h1>Order History</h1>
<nav>
    <div class="right-section">
        <a href="Home.jsp">Home</a>
        <a href="Cart.jsp">View Cart</a>
        <a href="Logout.jsp">Logout</a>
    </div>
</nav>

<section class="OrderHistory-list">
    <% List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderHistoryList");
       if (orderHistoryList != null) { %>
    
    <table class="orderHistory-table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Order_Id</th>
                <th>TotalAmount</th>
                <th>Status</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <% for (OrderHistory orderHistory : orderHistoryList) { %>
            <tr>
                <td><%= orderHistory.getOrderHistoryId() %></td>
                <td><%= orderHistory.getOrderId() %></td>
                <td>Rs. <%= orderHistory.getTotalAmount() %></td>
                <td><%= orderHistory.getStatus() %></td>
                <td><%= orderHistory.getOrderDate() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <form action="OrderHistoryServlet" method="post">
        <input type="hidden" name="action" value="clear">
        <button type="submit">Clear History</button>
    </form>
    
    <% } else { %>
    <p>No Order History to Display. <a href="Menu.jsp" style="color: #ff6347;">Add items to your cart.</a></p>
    <% } %>
</section>

<footer>
    <p>© 2024 FoodHub. All rights reserved.</p>
</footer>

</body>
</html>
