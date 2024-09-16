<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<style>
    body, html {
        height: 100%;
        margin: 0;
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
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
    .login-container {
        background-color: white;
        color: #333;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        max-width: 400px;
        width: 100%;
        text-align: center;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .login-container h1 {
        font-size: 28px;
        margin-bottom: 20px;
        color: #ff6347;
        font-weight: 700;
    }
    .login-container label {
        font-size: 16px;
        margin: 10px 0;
        color: #333;
        display: block;
    }
    .login-container input {
        width: 90%;
        padding: 12px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 16px;
        transition: border-color 0.3s ease;
    }
    .login-container input:focus {
        border-color: #ff6347;
        outline: none;
    }
    .login-container input[type="submit"] {
        background-color: #ff6347;
        color: white;
        border: none;
        cursor: pointer;
        width: 100%;
        padding: 12px;
        border-radius: 8px;
        font-size: 16px;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }
    .login-container input[type="button"] {
        background-color: #ff6347;
        color: white;
        border: none;
        cursor: pointer;
        width: 100%;
        padding: 12px;
        border-radius: 8px;
        font-size: 16px;
        transition: background-color 0.3s ease, transform 0.3s ease;
    }
    .login-container input[type="submit"]:hover {
        background-color: #e55347;
        transform: scale(1.05);
    }
     .login-container input[type="button"]:hover {
        background-color: #e55347;
        transform: scale(1.05);
    }
    .login-container a {
        color: #ff6347;
        text-decoration: none;
        display: block;
        margin-top: 10px;
        font-size: 14px;
    }
    .login-container a:hover {
        text-decoration: underline;
    }
    .error-message {
        color: red;
        font-size: 14px;
        margin-bottom: 15px;
    }
    .forgot-password {
        display: block;
        margin-top: 10px;
        font-size: 14px;
    }
</style>
</head>
<body>
<div class="flex-container">
    <div class="login-container">
        <h1>Logout</h1>
        <form action="LogoutServlet" method="post">
            <label>Are you sure you want to Logout?</label>
            <input type="submit" value="Yes, Logout">
        </form>
        <form>
            <input type="button" value="No, go back" onclick="history.back()">
        </form>
    </div>
</div>
</body>
</html>
