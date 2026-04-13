package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//Get User Details
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // Validation
        if (userId == null || userId.isEmpty() ||
            password == null || password.isEmpty()) {

            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();
        
        boolean isValidUser = dao.validateUser(userId, password);

        if (isValidUser) {

            // ✅ Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", userId);

            // ✅ IMPORTANT: REDIRECT (NOT FORWARD) /load
            response.sendRedirect("load");

        } else {
            request.setAttribute("error", "Invalid UserId or Password!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}