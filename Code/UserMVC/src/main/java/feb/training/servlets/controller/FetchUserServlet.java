package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import feb.training.servlets.dao.UserDAO;
import feb.training.servlets.model.User;

@WebServlet("/fetchUser")
public class FetchUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Get userId from form
        String userId = request.getParameter("userId");

        // ✅ Call DAO
        UserDAO dao = new UserDAO();
        User user = dao.getUserById(userId);

        if (user != null) {

            // ✅ Send user object
            request.setAttribute("user", user);

            // ✅ Load update form (prefilled)
            request.setAttribute("pageContent", "updateForm.jsp");

        } else {

            request.setAttribute("error", "User not found!");
            request.setAttribute("pageContent", "update.jsp");
        }

        // ✅ Go back to dashboard
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}