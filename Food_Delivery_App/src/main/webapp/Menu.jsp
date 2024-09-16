<%@page import="com.foodAppDOC.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodAppModule.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
            font-family: 'Okra', Helvetica, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }

        .header {
            background-color: #ffffff;
            padding: 10px 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .header h1 {
            font-size: 24px;
            color: #ff6347;
            margin: 0;
        }

        .header a {
            text-decoration: none;
            color: #ff6347;
            font-weight: bold;
            font-size: 18px;
            margin-left: 20px;
            transition: color 0.3s ease;
        }

        .header a:hover {
            color: #ff4500;
        }

        .menu-container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        .menu-item {
            display: flex;
            align-items: flex-start;
            margin-bottom: 30px;
            padding: 20px;
            border-bottom: 1px solid #ddd;
            transition: background-color 0.3s ease;
        }

        .menu-item:hover {
            background-color: #f7f7f7;
        }

        .menu-item img {
            width: 120px;
            height: 120px;
            object-fit: cover;
            border-radius: 10px;
            margin-right: 20px;
        }

        .item-details {
            flex-grow: 1;
        }

        .item-details h3 {
            font-size: 20px;
            color: #ff6347;
            margin: 0;
            margin-bottom: 8px;
        }

        .item-details p {
            font-size: 14px;
            color: #555;
            margin: 5px 0;
        }

        .item-details .price {
            font-size: 18px;
            color: #333;
            margin-top: 10px;
            font-weight: bold;
        }

        .item-actions {
            display: flex;
            align-items: center;
            margin-left: auto;
        }

        .item-actions input[type="number"] {
            width: 60px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-right: 15px;
        }

        .item-actions input[type="submit"] {
            background-color: #4CAF50 ;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .item-actions input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>The Food Hub</h1>
        <div>
            <a href="CartServlet"> Cart</a>
            <a href="OrderHistoryServlet">Order History</a>
            <a href="Logout.jsp">Logout</a>
        </div>
    </header>

    <div class="menu-container">
        <% List<Menu> menuItems = (List<Menu>) session.getAttribute("menuItems"); 
           if (menuItems != null) { 
               for (Menu menuItem : menuItems) { 
        %>
        <div class="menu-item">
            <img src="<%= request.getContextPath() %>/Images/<%= menuItem.getImgPath() %>" alt="<%= menuItem.getMenuName() %>">
            <div class="item-details">
                <h3><%= menuItem.getMenuName() %></h3>
                <p><%= menuItem.getDescription() %></p>
                <div class="price">₹<%= menuItem.getPrice() %></div>
            </div>
            <div class="item-actions">
                <form action="CartServlet" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="itemId" value="<%= menuItem.getMenuId() %>">
                    <input type="hidden" name="restaurantId" value="<%= menuItem.getRestaurantId() %>">
                    <input type="hidden" name="itemName" value="<%= menuItem.getMenuName() %>">
                    <input type="hidden" name="itemPrice" value="<%= menuItem.getPrice() %>">
                    Quantity
                    <input type="number" name="quantity" value="1" min="1">
                    <input type="submit" value="Add to Cart">
                </form>
            </div>
        </div>
        <% } } %>
    </div>
</body>
</html>
