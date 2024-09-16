package com.food.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodAppDOC.UserDao;
import com.foodAppDOC_Impl.UserDaoImpl;
import com.foodAppModule.Cart;
import com.foodAppModule.CartItem;
import com.foodAppModule.User;

import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            
        }

        String itemId = request.getParameter("itemId");
        System.out.println(itemId);
        String itemName = request.getParameter("itemName");

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String restaurantId = request.getParameter("restaurantId");
            double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            CartItem cartItem = new CartItem(itemId, restaurantId, itemName, quantity, itemPrice);
            System.out.println(cartItem);
            cart.addItem(cartItem);
            session.setAttribute("cart", cart);

        
        }
        else if ("update".equals(action)) {
            String key = itemId + "_" + itemName;
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            cart.updateItem(key, quantity);

        } else if ("remove".equals(action)) {
            String key = itemId + "_" + itemName;
            cart.removeItem(key);

        } else if ("clear".equals(action)) {
            cart.clear();
        }

        response.sendRedirect("Cart.jsp");
    }
}
