<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.foodAppModule.Restaurant," %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
    <div class="nav-left">
        <h1>The Food Hub</h1>
        <% 
       Restaurant RestaurantRegistered = (Restaurant) session.getAttribute("RestaurantRegistered");
        if (RestaurantRegistered != null) { %>
            <h3 class="welcome-message">Welcome to The Food Hub , <%= RestaurantRegistered.getRestaurantName() %> is Sucessfully Added</h3>
        <% } %>
        
    </div>
</header>
</body>
</html>