package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.OrderHistoryDao;
import com.foodAppDOC_Impl.OrderHistoryDaoImpl;
import com.foodAppModule.OrderHistory;
import com.foodAppModule.User;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	
OrderHistoryDao orderhistoryDao;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  resp.getWriter().println("Sucessful");
	  HttpSession session=req.getSession();
	  User user=(User) session.getAttribute("LoggedinUser");
	  int userId = user.getUserId();
	  System.out.println(userId);
	  orderhistoryDao=new OrderHistoryDaoImpl();
		List<OrderHistory> orderHistoryList= orderhistoryDao.getOrderHistory(userId);
		System.out.println(orderHistoryList);
		session.setAttribute("orderHistoryList", orderHistoryList);
		resp.sendRedirect("OrderHistory.jsp");
}
}
