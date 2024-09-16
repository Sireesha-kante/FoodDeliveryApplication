<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.foodAppModule.Restaurant,com.foodAppDOC_Impl.RestaurantDaoImpl,com.foodAppDOC.RestaurantDao" %>
<!DOCTYPE html>
<html>

<body>
    <div class="container">
        <div class="header-right">
            <a href="Register.jsp">Sign Up</a>
            <a href="Login.jsp">Login</a>
            <a href="CreateRestaurant.jsp">Add Restaurant</a>
        </div>
    </div>
    <div class="hero-section">
        <div class="centered-text">
            <h3>The</h3>
            <h1>Food Hub!</h1>
            <p>Discover the best food & drinks in Bengaluru</p>
            <div class="search-container">
     <input placeholder="Search for restaurant, cuisine or a dish" class="search-input" value="">
            </div>
        </div>
    </div>
    <div class="restaurant-section">
        <h2>What's on your mind?</h2>
        <div class="restaurant-container">
            <!-- First row -->
            <div class="restaurant-item">
                <img src="Images/italian.jpeg" alt="Italian">
                <p>Italian</p>
                 </div>
            <div class="restaurant-item">
                <img src="Images/biriyani.jpeg" alt="Biriyani">
                <p>Biriyani</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/chinese.jpeg" alt="Chinese">
                <p>Chinese</p>
            </div>
            <!-- Second row -->
            <div class="restaurant-item">
                <img src="Images/pizza.jpeg" alt="Mexican">
                <p>Mexican</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/tandori.jpeg" alt="Thai">
                <p>Thai</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/indian.jpeg" alt="Indian">
                <p>Indian</p>
            </div>
            <!-- Third row -->
            <div class="restaurant-item">
                <img src="Images/american.jpeg" alt="American">
                <p>American</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/french.jpeg" alt="French">
                <p>French</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/moctails.jpeg" alt="Japanese">
                <p>Japanese</p>
            </div>
            <div class="restaurant-item">
                <img src="Images/bakery.jpeg" alt="Turkish">
                <p>Turkish</p>
            </div>
        </div>
        <h2>Top Visited Restaurants in Banglore</h2>
    </div>
<section class="Restaurant-list">
   <section class="Restaurant-list">
        <% 
        RestaurantDao   restaurantDao=new RestaurantDaoImpl();
    	List<Restaurant> restaurantList= restaurantDao.getAllRestaurants();
        if (restaurantList != null) {
            for (Restaurant restaurant : restaurantList) { %>
                <div class="restaurant">
                    <img src="<%= request.getContextPath() %>/Images/<%= restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName()%>">
                    <h3><%= restaurant.getRestaurantName()%></h3>
                        <p><img src="Images/resRating.jpeg"style="width: 20px; height: 20px;" alt="Rating" > <%= restaurant.getRating() %></p>
                    <p><%= restaurant.getAddress()%></p>
                    <a href="Menu?restaurantId=<%= restaurant.getRestaurantId() %>">View Menu</a>
                </div>
            <% } 
        } %>
    </section>
    </section>
</body>
<head>
    <meta charset="UTF-8">
    <title>Index</title>
 <style>
       body {
    font-family:'Okra', 'Helvetica', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #ffffff;
    color: #000000;
}


        .container {
            display: flex;
            justify-content: flex-end;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .header-right a {
            text-decoration: none;
            color: #ff6347; /* Tomato color for contrast */
            font-weight: bold;
            margin: 0 15px;
            padding: 10px 15px;
            background-color: #fff;
            border: 2px solid #ff6347;
            border-radius: 30px;
            transition: background-color 0.3s, color 0.3s;
        }

        .header-right a:hover {
            background-color: #ff6347;
            color: #fff;
        }
.hero-section {
    background-image: url('Images/login_BGImage.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    height: 55vh; /* Keep this at 0.5 times the viewport height */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    color: #ffffff; /* White text for contrast */
    position: relative;
    z-index: 1;
    overflow: hidden;
}

.hero-section::after {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5); /* Dark overlay for text readability */
    z-index: -1;
}

.centered-text h1 {
    font-size: 80px; /* Adjusted size for better balance */
    font-weight: 900;
    margin: 10px 0;
    text-transform: uppercase; /* Uppercase for a bold look */
}

.centered-text h3 {
    font-size: 40px;
    margin: 5px 0;
    font-weight: 700;
}

.centered-text p {
    font-size: 24px;
    margin: 10px 0;
    font-weight: 500;
    color: #ff6347; /* Tomato color to match theme */
}

.search-container {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    width: 100%;
}

.search-container input {
    padding: 15px;
    font-size: 18px;
    width: 500px;
    border: none;
    border-radius: 30px;
    outline: none;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transition: box-shadow 0.3s;
}

.search-container input::placeholder {
    color: #aaaaaa;
}

.search-container input:focus {
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
}

.restaurant-section {
    padding: 50px 0;
    background-color: #ffffff;
    text-align: center;
}

.restaurant-section h2 {
    font-size: 36px;
    margin-bottom: 30px;
    color: #333;
    font-weight: 700;
    text-align: center;
}

.restaurant-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center; /* Center the restaurant items */
    gap: 30px;
}

.restaurant-item {
    width: 250px;
    background-color: #ffffff;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    overflow: hidden;
    text-align: center;
    transition: transform 0.3s, box-shadow 0.3s;
}

.restaurant-item:hover {
    transform: translateY(-10px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.restaurant-item img {
    width: 100%;
    height: 150px;
    object-fit: cover;
}

.restaurant-item p {
    font-size: 18px;
    margin: 15px 0;
    color: #555;
}

.Restaurant-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    padding: 20px;
}



.restaurant {
    width: 250px; /* Adjust width as needed */
    background-color: #orange;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    overflow: hidden;
    text-align: center;
    margin-bottom: 20px; /* Add some space between the items */
}

.restaurant img {
    width: 100%;
    height: 150px;
    object-fit: cover;
}

.restaurant h3, .restaurant p {
    margin: 10px 0;
    color: #333;
}
 .restaurant a {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

     .restaurant a:hover {
            background-color: #218838;
        }
    </style>
     <script>
        function filterRestaurants() {
            var input, filter, restaurants, restaurantName, i;
            input = document.getElementById("searchInput");
            filter = input.value.toLowerCase();
            restaurants = document.querySelectorAll('.restaurant');

            for (i = 0; i < restaurants.length; i++) {
                restaurantName = restaurants[i].dataset.name;
                if (restaurantName.includes(filter)) {
                    restaurants[i].style.display = "";
                } else {
                    restaurants[i].style.display = "none";
                }
            }
        }
    </script>
</head>
</html>
