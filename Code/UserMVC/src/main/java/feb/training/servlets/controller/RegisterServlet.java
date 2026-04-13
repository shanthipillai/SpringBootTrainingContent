package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

import java.io.IOException;




@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // DEBUG (remove later)
        System.out.println(userId + " | " + password + " | " + email);

        // 1. VALIDATION
        if (userId == null || userId.isEmpty() ||
            password == null || password.isEmpty() ||
            email == null || email.isEmpty()) {

            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);
            return;
        }

        // 2. DAO CALL
        UserDAO dao = new UserDAO();
        boolean status = dao.registerUser(
                new feb.training.servlets.model.User(userId, password, email)
        );

        // 3. RESULT
        if (status) {

            // ✅ SUCCESS → REDIRECT (VERY IMPORTANT)
            //response.sendRedirect("register.jsp?msg=registered");
        	request.setAttribute("success", "Registration successful!");
        	request.getRequestDispatcher("register.jsp").forward(request, response);

        } else {

            // ❌ FAILURE → FORWARD
            request.setAttribute("error", "Registration failed! Try again.");
            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);
        }
    }
}