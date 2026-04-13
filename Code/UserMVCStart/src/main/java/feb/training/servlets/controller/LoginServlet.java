package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import javax.servlet.annotation.WebInitParam;

@WebServlet(urlPatterns = "/testlogin", initParams = { @WebInitParam(name = "username", value = "admin"),
		@WebInitParam(name = "password", value = "1234") })
public class LoginServlet extends HttpServlet {

	
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
		  
		  
		  
	  //userId=admin
	  String userId = request.getParameter("userId");
	  
	  String password =request.getParameter("password");
	  
	  //validation
	  if (userId.equals("admin") && password.equals("123")) {
	  
	  // ✅ Create session 
      HttpSession session = request.getSession();
	  session.setAttribute("user", userId); 
	 // session.setAttribute("role", password);
	  
	  
	  
	  request.setAttribute("reqid","worksonforward"); 
	  
	  
	  
	  getServletContext().setAttribute("Course", "Spring Boot Training"); 
	  
	  
	  RequestDispatcher rd =request.getRequestDispatcher("load"); rd.forward(request, response);
	  
	 
	
	 
	  
	  }
	  
	  }
	 
	
	
		/*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException {
		 * 
		 * String userId = request.getParameter("userId"); String password =
		 * request.getParameter("password");
		 * 
		 * if ("admin".equals(userId) && "123".equals(password)) {
		 * 
		 * // ✅ Session HttpSession session = request.getSession();
		 * session.setAttribute("user", userId);
		 * 
		 * // ✅ Cookie Cookie cookie = new Cookie("userId", userId); cookie.setMaxAge(60
		 * * 1); // 5 min (or keep 1 day) response.addCookie(cookie);
		 * request.setAttribute("reqid", "worksonforward");
		 * getServletContext().setAttribute("Course", "Spring Boot Training");
		 * 
		 * // ✅ Redirect to next servlet (VERY IMPORTANT)
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("load");
		 * rd.forward(request, response);
		 * 
		 * } else { response.sendRedirect("testlogin"); } }
		 */
}