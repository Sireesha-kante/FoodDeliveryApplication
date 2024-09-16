<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
         body, html {
            font-family: Okra, Helvetica, sans-serif;
            color: orange;
            background-color: transparent;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('Images/login_BGImage.jpg');
            background-size: cover;
            background-position: top;
            background-repeat: no-repeat;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            color: Orange;
            background-color: rgba(255, 255, 255, 0.9); /* Slightly transparent background */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align:left;
            display: flex;
            flex-direction: column; /* Align elements vertically */
            gap: 10px; /* Space between elements */
            text-align: center;
        }

        .login-container h1 {
            font-size: 25px; /* Adjust font size */
            margin-bottom: 15px;
            color: orange;
            text-align: center; /* Center the heading */
        }

        .login-container label {
            font-size: 16px; /* Smaller font size for labels */
            color:Orange; /* Darker color for labels */
            text-align: center;
        }

        .login-container input {
            width: 100%; /* Full width for inputs */
            padding: 10px;
            margin: 4px 0; /* Adjusted margin for spacing */
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px; /* Adjusted font size */
        }

        .login-container input:focus {
            border-color: #ed600e;
            outline: none; /* Remove default outline */
        }

        .login-container input[type="submit"] {
            background-color: orange;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            padding: 10px;
            margin-top: 10px;
            border-radius: 4px;
        }

        .login-container input[type="submit"]:hover {
            background-color: darkorange;
        }

        .login-container h6 {
            font-size: 14px; /* Smaller font size for terms */
            color: #666;
            text-align: center; /* Center-align terms */
            margin-top: 10px;
        }
        
        .login-container a {
        color: Orange;
        text-decoration: none;
    }
    .login-container a:hover {
        text-decoration: underline;
    }

        .login-container a:hover {
            text-decoration: underline;
        }
         .forgot-password {
        display: block;
        margin-top: 10px;
        font-size: 14px;
    }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Add Restaurant</h1>
        <form action="RestaurantServlet" method="post">
            <label> Restaurant Name</label><br>
            <input type="text" name="Restaurantname" placeholder="Enter RestaurantName" required><br>
            <label>Max-DeliveryTime of Any Item(Min)</label><br>
            <input type="number" name="DeliveryTime" placeholder="00" required><br>
            <label>Cuisine Type of your Restaurant</label><br>
            <input type="text" name="CuisineType" placeholder="Cuisine" required><br>
            <label>Address of Restaurant</label><br>
            <input type="text" name="Address" placeholder="" required><br>
            <label>Rate Your Restaurant </label><br>
            <input type="number" name="Rating" placeholder="Based on Customer Feedbacks" required><br>
            <label>isActive</label><br>
            <input type="text" name="isActive" placeholder="Yes/No" required><br>
            <label>Restaurant-Govt.Id</label><br>
            <input type="number" name="AdminId" placeholder="Govt-iD" required><br>
            <label>Restaurant_Image</label><br>
            <input type="text" name="imgPath" placeholder="imgpath"><br>
            <input type="submit" value="Continue" required><br>
            <h6>By creating an Restaurant Account, I accept the Terms & Conditions & Privacy Policy</h6>
             <a href="Cancle.jsp" class="forgot-password">Cancel</a>
            <a href="Index.jsp" class="forgot-password"> go to Home</a>
        </form>
    </div>
</body>
</html>