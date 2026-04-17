package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/updateUser")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String userId = request.getParameter("userId");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");

    	// ✅ Create model
    	User user = new User();

    	user.setUserId(userId);
    	user.setPassword(password);
    	user.setEmail(email);

    	// ✅ Call correct DAO method
    	UserDAO dao = new UserDAO();
    	boolean status = dao.updateUser(user);   // ✅ FIXED

    	// ✅ Set message
    	if (status) {
    	    request.setAttribute("success", "User updated successfully!");
    	} else {
    	    request.setAttribute("error", "Update failed!");
    		   throw new ServletException("User update failed!");
    	}

    	// ✅ Go back to update page
    	request.setAttribute("pageContent", "update.jsp");

    	request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}