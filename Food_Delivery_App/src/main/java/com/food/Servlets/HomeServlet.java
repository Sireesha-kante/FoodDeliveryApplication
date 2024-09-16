package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.RestaurantDao;
import com.foodAppDOC_Impl.RestaurantDaoImpl;
import com.foodAppModule.Restaurant;
import com.foodAppModule.User;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	RestaurantDao restaurantDao;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  resp.getWriter().println("Sucessful");
	  
	restaurantDao=new RestaurantDaoImpl();
	List<Restaurant> restaurantList= restaurantDao.getAllRestaurants();
	HttpSession session=req.getSession();
	User us=(User)session.getAttribute("LoggedinUser");
	System.out.println(us);
	
	session.setAttribute("restaurantList", restaurantList);
	resp.sendRedirect("Home.jsp");
	
}

}
