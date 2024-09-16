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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String UserName= req.getParameter("Username");
	String Password= req.getParameter("password");
	String Email= req.getParameter("email");
	Long PhoneNumber= Long.parseLong(req.getParameter("number"));
	String Address= req.getParameter("address");
	HttpSession session=req.getSession();
	User currentuser=(User)session.getAttribute("LoggedinUser");
	
	if(currentuser==null)
	{
		req.setAttribute("errorMessage", "User not logged in.");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        return;
	}
	int userid=currentuser.getUserId();
		User user=new User(UserName,Password,Email,PhoneNumber,Address,userid);
		UserDao userDao= new UserDaoImpl();
		int status =userDao.updateUser(user);
		
		if(status>=1)
		{
		System.out.println("sucess");
	    //resp.getWriter().println("Sucessful");
		session.setAttribute("LoggedinUser", user);
		resp.sendRedirect("HomeServlet");
		}
		else
		{
			req.setAttribute("errorMessage", "Update failed. Please try again.");
	        req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
}
}


