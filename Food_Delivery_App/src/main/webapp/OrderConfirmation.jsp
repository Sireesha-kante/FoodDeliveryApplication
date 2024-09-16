<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.foodAppModule.OrderHistory,com.foodAppModule.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    img {
        max-width: 100px;
        margin-top: 20px;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }

    h1 {
        color: #333;
        margin-top: 20px;
        font-size: 2em;
    }

    h2 {
        color: #666;
        margin: 10px 0;
        font-size: 1.5em;
    }

    p {
        font-size: 1.1em;
        color: #444;
        margin: 10px 0;
    }

    .confirmation-container {
        max-width: 600px;
        margin: 40px auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    button {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 20px;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<%  OrderHistory OrderHistory=(OrderHistory)session.getAttribute("orderHistory");%>
<% User user=(User)session.getAttribute("LoggedinUser");%>
    <div class="confirmation-container">
        <img src="Images/checkmark.jpg" alt="Order Confirmed">
        <h1>Thank You for Your Order</h1>
        <h2>Order Placed Successfully</h2>
        <p>Order Id: <% OrderHistory.getOrderId(); %></p>
        <p>Order Amount: <% OrderHistory.getTotalAmount(); %></p>
        <h3>A Confirmation email has been sent to:</h3>
        <p>Email: <% user.getEmail(); %></p>
        <form action="OrderHistoryServlet">
            <input type="hidden" name="action" value="proceed">
            <button type="submit">Go to Orders</button>
        </form>
    </div>
</body>
</html>
