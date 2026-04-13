package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;

@WebServlet("/deleteUser")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Session check
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("home.jsp");
            return;
        }

        // ✅ Get userId
        String userId = request.getParameter("userId");

        UserDAO dao = new UserDAO();
        boolean status = dao.deleteUser(userId);

        if (status) {
            request.setAttribute("success", "User deleted successfully!");
        } else {
            request.setAttribute("error", "User not found or delete failed!");
        }

        request.setAttribute("pageContent", "delete.jsp");

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    
    
    
}