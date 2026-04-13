package feb.training.servlets.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/fetchAll")
public class FetchAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Session check
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("home.jsp");
            return;
        }

        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();

        request.setAttribute("users", users);
        request.setAttribute("pageContent", "fetch.jsp");

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}