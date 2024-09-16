package com.food.Servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.OrderHistoryDao;
import com.foodAppDOC.OrderitemDao;
import com.foodAppDOC.OrdertableDao;
import com.foodAppDOC_Impl.OrderHistoryDaoImpl;
import com.foodAppDOC_Impl.OrderitemDaoImpl;
import com.foodAppDOC_Impl.OrdertableDaoImpl;
import com.foodAppModule.Cart;
import com.foodAppModule.CartItem;
import com.foodAppModule.OrderHistory;
import com.foodAppModule.Orderitem;
import com.foodAppModule.Ordertable;
import com.foodAppModule.User;

/**
 * Servlet implementation class OrderItemTable
 */
@WebServlet("/OrderItemTable")
public class OrderItemTable extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession();
		  Cart cart = (Cart) session.getAttribute("cart");
		  
		 User user=(User) session.getAttribute("LoggedinUser");
		 if (user == null) {
		        // Redirect to login page or error page
		        resp.sendRedirect("Login.jsp?message=Please log in to continue.");
		        return;
		    }
	        System.out.println(cart);
	        System.out.println("Suser not available");
	       int restaurantId =Integer.parseInt(cart.getItems().values().iterator().next().getRestaurantId());
	      String Items = cart.getItems().values().iterator().next().getItemName();
	        int userId = user.getUserId();
	        float grandTotal=Float.parseFloat(req.getParameter("GrandTotal"));
	        String Status="pending";
	        String PaymentMode=req.getParameter("paymentMethod");

	        if(cart!=null && !cart.getItems().isEmpty())
	        {
	        	OrdertableDao ordertableDao = new OrdertableDaoImpl();
	            Ordertable order = new Ordertable(restaurantId, userId,grandTotal, Status, PaymentMode);
	            System.out.println(order);
	          int orderid= ordertableDao.addOrder(order);
	            System.out.println("ordertable added");
	            if (orderid > 0) {
	            for (Map.Entry<String, CartItem> entry : cart.getItems().entrySet()) {
	                CartItem cartItem = entry.getValue();
	                int menuId = Integer.parseInt(cartItem.getItemId());
	                int quantity = cartItem.getQuantity();
	                float subTotal = (float)cartItem.getSubTotal();
	                OrderitemDao orderitemDao = new OrderitemDaoImpl();
	                Orderitem orderItem = new Orderitem(orderid,menuId, quantity, subTotal);
	                System.out.println(orderItem);
	                orderitemDao.addOrderitem(orderItem);
	                System.out.println("order item table added");
	            }
		           
	            OrderHistoryDao orderhistoryDao=new OrderHistoryDaoImpl();
		         OrderHistory orderhistory=new OrderHistory(orderid,userId,grandTotal,Status);
	           orderhistoryDao.addOrderHistory(orderhistory);
	           System.out.println(orderhistory);
	            System.out.println("Order, OrderItems, OrderHistory added successfully");
	            session.setAttribute("orderHistory", orderhistory);
	            resp.sendRedirect("OrderConfirmation.jsp");
	            } else {
	                System.out.println("Failed to add order");
	                resp.sendRedirect("Menu.jsp");
	        }
	        }
	       
	        else
	        {
	        	resp.sendRedirect("Menu.jsp");
	        }
	        cart.clear();
	        
	        
	}
}
