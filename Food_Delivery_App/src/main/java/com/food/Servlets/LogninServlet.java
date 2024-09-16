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

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LogninServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("un");
		String Password= req.getParameter("pwd");
		UserDao userDao= new UserDaoImpl();
		User user=userDao.getUser(email);
		if(Password.equals(user.getPassword()) && email!=null)
		{
			System.out.println("sucess");
		   //resp.getWriter().println("Sucessful");
			HttpSession session=req.getSession();
			session.setAttribute("LoggedinUser", user);
			
			resp.sendRedirect("HomeServlet");
		}
		else
		{
			req.setAttribute("errorMessage","Invalid Email/Password Please Enter the Correct Details");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
}
