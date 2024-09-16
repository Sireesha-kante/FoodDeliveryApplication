<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.foodAppModule.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: Okra, Helvetica, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('Images/login_BGImage.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
        .flex-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100%;
        }
        .update-container {
            background-color: white;
            color: #ff6347;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
            flex-direction: column;
            align-items: center;
            padding: 20px; /* Padding added for consistency */
        }
        .update-container h1 {
            font-size: 24px;
            margin-bottom: 12px;
            color: #ff6347;
        }
        .update-container input {
            width: 70%;
            padding: 5px;
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 2px;
            font-size: 16px;
        }
        .update-container input:focus {
            border-color: #ff6347;
            outline: none;
        }
        .update-container input[type="submit"] {
            background-color: #ff6347;
            color: white;
            border: none;
            cursor: pointer;
            width: 70%;
            padding: 10px;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .update-container input[type="submit"]:hover {
            background-color: #e55347;
        }
        .update-container a {
            color: #ff6347;
            text-decoration: none;
            font-size: 14px;
        }
        .update-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<% User user = (User) session.getAttribute("LoggedinUser"); %>
<div class="flex-container">
    <div class="update-container">
        <h1>Update Profile</h1>
        <form action="UpdateServlet" method="post">
            <label>Username</label><br>
            <input type="text" name="Username" value="<%=user.getUserName()%>" required><br>
            <label>Password</label><br>
            <input type="password" name="password" value="<%=user.getPassword()%>" required><br>
            <label>Email</label><br>
            <input type="email" name="email" value="<%=user.getEmail()%>" required><br>
            <label>Mobile Number</label><br>
            <input type="number" name="number" value="<%=user.getPhoneNumber()%>" required><br>
            <label>Address</label><br>
            <input type="text" name="address" value="<%=user.getAddress()%>" required><br><br>
            <input type="submit" value="Update"><br>
            <a href="Home.jsp">Go to Home</a>
        </form>
    </div>
</div>
</body>
</html>
