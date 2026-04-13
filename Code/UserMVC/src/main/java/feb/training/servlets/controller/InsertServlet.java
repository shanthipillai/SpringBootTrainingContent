package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Session check
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("home.jsp");   // ✅ login page
            return;
        }

        // ✅ Get data
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // ✅ Validation
        if (userId == null || userId.isEmpty() ||
            password == null || password.isEmpty() ||
            email == null || email.isEmpty()) {

            request.setAttribute("error", "All fields are required!");
            request.setAttribute("pageContent", "insert.jsp");

            request.getRequestDispatcher("welcome.jsp").forward(request, response);
            return;
        }

        // ✅ Model
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setEmail(email);

        // ✅ DAO
        UserDAO dao = new UserDAO();
        boolean status = dao.registerUser(user);

        if (status) {
            request.setAttribute("success", "User inserted successfully!");
        } else {
            request.setAttribute("error", "Failed to insert user!");
        }

        // ✅ Stay on insert page inside dashboard
        request.setAttribute("pageContent", "insert.jsp");

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}