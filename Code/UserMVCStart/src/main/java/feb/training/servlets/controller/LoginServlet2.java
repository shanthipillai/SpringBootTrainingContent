package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/testlogin2")
public class LoginServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // ✅ Check session first
	    HttpSession session = request.getSession(false);

	    if (session != null && session.getAttribute("user") != null) {
	        response.sendRedirect(request.getContextPath() + "/load2");
	        return;
	    }

	    // ✅ Then check cookie
	    Cookie[] cookies = request.getCookies();
	    String userFromCookie = null;

	    if (cookies != null) {
	        for (Cookie c : cookies) {
	            if ("userId".equals(c.getName())) {
	                userFromCookie = c.getValue();
	            }
	        }
	    }

	    if (userFromCookie != null) {
	        session = request.getSession();
	        session.setAttribute("user", userFromCookie);

	        response.sendRedirect(request.getContextPath() + "/load2");
	    } else {
	        request.getRequestDispatcher("home2.jsp").forward(request, response);
	    }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");

	    //Validate
	    if ("admin".equals(userId) && "123".equals(password)) {

	        HttpSession session = request.getSession();
	        session.setAttribute("user", userId);

	        Cookie cookie = new Cookie("userId", userId);
	        
	        cookie.setMaxAge(60 * 60);
	        cookie.setPath("/");
	        response.addCookie(cookie);

	        response.sendRedirect(request.getContextPath() + "/load2");

	    } else {
	        request.setAttribute("error", "Invalid credentials!");
	        request.getRequestDispatcher("home2.jsp").forward(request, response);
	    }
	}
	
	
	
}