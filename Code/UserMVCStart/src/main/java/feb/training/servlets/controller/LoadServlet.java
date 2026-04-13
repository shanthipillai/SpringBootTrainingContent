package feb.training.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/load")
public class LoadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ✅ 1. Check session
		HttpSession session = request.getSession(false);
		// session.invalidate();
		//request.setAttribute(getServletName(), session);
 
		/*
		 * String requestattr=(String) request.getAttribute("reqid"); PrintWriter out =
		 * response.getWriter(); out.println(requestattr);
		 */
		 // response.flushBuffer();
		 
			
			  RequestDispatcher rd = request.getRequestDispatcher("test1.jsp");
			  
			  rd.forward(request, response);
			 

		//response.sendRedirect("test1.jsp");

	}
}