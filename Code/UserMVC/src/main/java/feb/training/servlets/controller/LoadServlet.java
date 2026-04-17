package feb.training.servlets.controller;

import java.io.IOException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ 1. Check session
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("home.jsp");   // ✅ FIXED
            return;
        }

        // ✅ 2. Get view parameter
        String view = request.getParameter("view");

        // ✅ 3. Decide page
        String page = null;

        if (view != null) {
            switch (view) {
                case "insert":
                    page = "insert.jsp";
                    break;

                case "update":
                    page = "update.jsp";
                    break;

                case "delete":
                    page = "delete.jsp";
                    break;

                case "fetch":
                    UserDAO dao = new UserDAO();
                    List<User> users = dao.getAllUsers();

                    request.setAttribute("users", users);   // ✅ VERY IMPORTANT
                    page = "fetch.jsp";
                    break;

                default:
                    page = null;
            }
        }

        // ✅ 4. Set attribute
        //pagecontent=insert.jsp
        request.setAttribute("pageContent", page);

        // ✅ 5. FORWARD (NOT REDIRECT)
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}