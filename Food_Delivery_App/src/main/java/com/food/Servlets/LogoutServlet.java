package com.food.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
HttpSession session = ((HttpServletRequest) req).getSession(false);
        
        // If a session exists, invalidate it
        if (session != null) {
            session.invalidate();
        }
        
        // Redirect to the index page (homepage)
        ((HttpServletResponse) res).sendRedirect("Index.jsp");
	       
	}

}
