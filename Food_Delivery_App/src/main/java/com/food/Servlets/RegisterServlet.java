package com.food.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.UserDao;
import com.foodAppDOC_Impl.UserDaoImpl;
import com.foodAppModule.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String UserName= req.getParameter("Username");
	String Password= req.getParameter("password");
	String Email= req.getParameter("email");
	Long PhoneNumber= Long.parseLong(req.getParameter("number"));
	String Address= req.getParameter("address");
	UserDao userDao= new UserDaoImpl();
	User user=new User(UserName,Password,Email,PhoneNumber,Address);
	int status =userDao.addUser(user);
	
	if(status>=1)
	{
		//System.out.println("sucess");
	    //resp.getWriter().println("Sucessful");
		HttpSession session=req.getSession();
		session.setAttribute("LoggedinUser", user);
		resp.sendRedirect("Login.jsp");
		
	}
	else
	{
		req.setAttribute("errorMessage","Invalid Email/Password");
		req.getRequestDispatcher("Register.jsp").forward(req, resp);
	}
}

}
