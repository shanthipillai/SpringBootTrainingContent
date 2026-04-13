package feb.training.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/loadUpdate")
public class LoadUpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String view = request.getParameter("view");
    	if ("update".equals(view)) {

    	    String action = request.getParameter("action");

    	    if ("fetch".equals(action)) {

    	        String userId = request.getParameter("userId");
    	        System.out.println("LOAD SERVLET USERID: " + userId);

    	        UserDAO dao = new UserDAO();
    	        User user = dao.getUserById(userId);

    	        request.setAttribute("user", user);
    	    }

    	    request.getRequestDispatcher("update.jsp").forward(request, response);
    	}
    }
}