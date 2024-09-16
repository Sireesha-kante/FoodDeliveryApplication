<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodAppModule.Restaurant, com.foodAppModule.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        /* General Styling */
        body {
            font-family: 'Okra', 'Helvetica', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
            color: #333;
        }

        /* Header Styling */
        header {
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

        .nav-left {
            flex: 1;
        }

        .nav-left h1 {
            font-size: 30px;
            color: #ff6347; /* Tomato color */
            margin: 0;
            font-weight: bolder;
        }
        .nav-left h3 {
            font-size: 22px;
            color:#333; 
            margin: 0;
            font-weight:bold;
        }

        .welcome-message {
            font-size: 16px;
            color: #555;
        }

        /* Search Bar Styling */
        .search-bar {
            flex: 2;
            margin: 0 20px;
        }

        .search-bar input {
            width: 100%;
            max-width: 600px;
            padding: 12px;
            border-radius: 30px;
            border: 1px solid #ddd;
            font-size: 16px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            outline: none;
        }

        .search-bar input:focus {
            border-color: #ff6347;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }

        /* Navigation Right Styling */
        .nav-right {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .nav-right a {
            text-decoration: none;
            color: #ff6347;
            font-weight: bold;
            padding: 10px 15px;
            border: 2px solid #ff6347;
            border-radius: 30px;
            transition: background-color 0.3s, color 0.3s;
        }

        .nav-right a:hover {
            background-color: #ff6347;
            color: #fff;
        }

        .profile-dropdown {
            position: relative;
        }

        .profile-dropdown-content {
            display: none;
            position: absolute;
            right: 0;
            background-color: #ffffff;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            min-width: 150px;
            z-index: 100;
            color: #333;
            
        }

        .profile-dropdown-content a {
            display: block;
            padding: 10px 15px;
            color: #333;
            font-weight: bold;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .profile-dropdown-content a:hover {
             background-color: #ff6347;
            color: #fff;
        }

        .profile-dropdown:hover .profile-dropdown-content {
            display: block;
        }

        /* Restaurant Section Styling */
        .restaurant-section {
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px;
        }

        .restaurant-section h2 {
            text-align: center;
            color: #333;
            font-size: 28px;
            margin-bottom: 20px;
        }

        .restaurant-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .restaurant {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 280px;
            padding: 15px;
            text-align: center;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .restaurant:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .restaurant img {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .restaurant h3 {
            margin: 15px 0 10px;
            font-size: 22px;
            color: #333;
        }

        .restaurant p {
            font-size: 14px;
            color: #666;
            margin: 0;
        }

        .restaurant .details {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 15px;
        }

        .restaurant .details img {
            width: 20px;
            height: 15px;
            vertical-align: middle;
            margin-right: 5px;
        }

        .restaurant .details .rating {
            display: flex;
            align-items: center;
            font-size: 17px;
            color:#333;
        }

        .restaurant .details .address {
            font-size: 17px;
            color: #666;
            margin: 5px 0;
        }

        .restaurant .details .delivery-time {
            font-size: 14px;
            color: #666;
        }

        .restaurant a {
            display: inline-block;
            margin-top: 15px;
            padding: 8px 15px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            font-size: 14px;
        }

        .restaurant a:hover {
            background-color: #218838;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .search-bar input {
                width: 90%;
            }

            .restaurant-list {
                flex-direction: column;
                align-items: center;
            }

            .restaurant {
                width: 90%;
            }
        }
    </style>
</head>
<body>
    <header>
        <div class="nav-left">
            <h1>The Food Hub</h1>
            <% 
            User LoggedinUser = (User) session.getAttribute("LoggedinUser");
            if (LoggedinUser != null) { %>
                <h3 class="welcome-message">Welcome, <%= LoggedinUser.getUserName() %>!</h3>
            <% } %>
        </div>
        <div class="search-bar">
            <input type="text" placeholder="Search for restaurants...">
        </div>
        <div class="nav-right">
            <a href="CartServlet">View Cart</a>
            <div class="profile-dropdown">
                <a href="#" class="dropdown-toggle">Profile</a>
                <div class="profile-dropdown-content">
                 <a href="update.jsp">Update Profile</a>
                    <a href="OrderHistoryServlet">View History</a>
                    <a href="Logout.jsp">Logout</a>
                </div>
            </div>
        </div>
    </header>

    <!-- Restaurant List -->
    <section class="restaurant-section">
        <h2>Featured Restaurants</h2>
        <div class="restaurant-list">
            <% 
            List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
            if (restaurantList != null) {
                for (Restaurant restaurant : restaurantList) { %>
                    <div class="restaurant">
                        <img src="<%= request.getContextPath() %>/Images/<%= restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName() %>">
                        <h3><%= restaurant.getRestaurantName() %></h3>
                        <div class="details">
                            <div class="rating">
                                <img src="Images/resRating.jpeg" alt="Rating"> <%= restaurant.getRating() %>
                            </div>
                            <div class="address"><%= restaurant.getAddress() %></div>
                            <div class="delivery-time"><%= restaurant.getDeliveryTime() %> mins</div>
                        </div>
                        <a href="Menu?restaurantId=<%= restaurant.getRestaurantId()%>">View Menu</a>
                    </div>
            <% }
            } else { %>
                <p>No Restaurants Available at the moment</p>
            <% } %>
            <% if (LoggedinUser == null) {
                response.sendRedirect("Login.jsp");
            } %> 
        </div>
    </section>
</body>
</html>
