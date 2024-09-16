package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.foodAppDOC.MenuDao;
import com.foodAppDOC_Impl.MenuDaoImpl;
import com.foodAppDOC_Impl.RestaurantDaoImpl;
import com.foodAppModule.Menu;
import com.foodAppModule.Restaurant;


/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
	
	MenuDao menuDao;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Sucessful");
		
		int RestaurantId= Integer.parseInt(req.getParameter("restaurantId"));
		System.out.println(RestaurantId);
			menuDao=new MenuDaoImpl();
			List<Menu> menuItems= menuDao.getMenu(RestaurantId);
			HttpSession session=req.getSession();
			session.setAttribute("menuItems", menuItems);
			resp.sendRedirect("Menu.jsp");
	}
	}
