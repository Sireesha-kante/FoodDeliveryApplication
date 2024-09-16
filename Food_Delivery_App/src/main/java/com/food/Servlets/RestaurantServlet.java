package com.food.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.RestaurantDao;
import com.foodAppDOC_Impl.RestaurantDaoImpl;
import com.foodAppModule.Restaurant;

/**
 * Servlet implementation class RestaurantServlet
 */
@SuppressWarnings("serial")
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String RestaurantName= req.getParameter("Restaurantname");
		int DeliveryTime = Integer.parseInt(req.getParameter("DeliveryTime"));
		String CuisineType= req.getParameter("CuisineType");
		String Address= req.getParameter("Address");
		float Rating= Float.parseFloat(req.getParameter("Rating"));
		String isActive= req.getParameter("isActive");
		int AdminId=Integer.parseInt(req.getParameter("AdminId"));
		String imgPath= req.getParameter("imgPath");
		RestaurantDao restaurantDao= new RestaurantDaoImpl();
		 Restaurant restaurant=new Restaurant(RestaurantName,DeliveryTime,CuisineType,Address,Rating,isActive, AdminId,imgPath);
		int status =restaurantDao.addRestaurant(restaurant);
		
		if(status>=1)
		{
			System.out.println("sucess");
		    resp.getWriter().println("Sucessful");
			HttpSession session=req.getSession();
			session.setAttribute("RestaurantRegistered", restaurant);
			resp.sendRedirect("RestaurantAdded.jsp");
			
		}
		else
		{
			req.setAttribute("errorMessage","Invalid Email/Password");
			req.getRequestDispatcher("CreateRestaurant.jsp").forward(req, resp);
		}
		
	
	}

}
