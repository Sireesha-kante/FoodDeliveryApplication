<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
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
        .register-container {
            background-color: white;
            color: #ff6347; /* Consistent with login page */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
            flex-direction: column;
            align-items: center;
        }
        .register-container h1 {
            font-size: 24px; /* Consistent with login page */
            margin-bottom: 12px;
            color: #ff6347; /* Same as login page */
        }
        .register-container input {
            width: 70%;
            padding: 5px; /* Consistent padding */
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 2px;
            font-size: 16px;
            
        }
        .register-container input:focus {
            border-color: #ff6347; /* Tomato color for focus */
             outline: none;
        }
        .register-container input[type="submit"] {
            background-color: #ff6347; /* Tomato color for submit button */
    color: white;
    border: none;
    cursor: pointer;
    width: 70%;
    padding: 10px;
    border-radius: 5px;
    font-size: 16px;
    transition: background-color 0.3s;
        }
        .register-container input[type="submit"]:hover {
             background-color: #e55347;/* Hover effect consistent with login page */
        }
        .register-container a {
            color: #ff6347; /* Tomato color for links */
    text-decoration: none;
    
    font-size: 14px;
        }
        .register-container a:hover {
            text-decoration: underline;
        }
        .terms {
            font-size: 14px;
            color: #666;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="flex-container">
    <div class="register-container">
        <h1>Sign Up</h1>
        <form action="RegisterServlet" method="post">
            <label>Username</label><br>
            <input type="text" name="Username" placeholder="Enter your Name" required><br>
            <label>Create Password</label><br>
            <input type="password" name="password" placeholder="Create a Unique Password" required><br>
            <label>Confirm Password</label><br>
            <input type="password" name="cpassword" placeholder="Confirm Password" required><br>
            <label>Email</label><br>
            <input type="email" name="email" placeholder="Enter your Email" required><br>
            <label>Mobile Number</label><br>
            <input type="number" name="number" placeholder="Enter your Mobile Number" required><br>
            <label>Address</label><br>
            <input type="text" name="address" placeholder="Enter your Address" required><br><br>
            <input type="submit" value="Continue"><br>
            <div class="terms">By creating an account, I accept the Terms & Conditions & Privacy Policy</div>
            <a href="Login.jsp">Already have an account? Log in</a><br>
            <a href="Index.jsp">Go to Home</a>
        </form>
    </div>
</div>
</body>
</html>
