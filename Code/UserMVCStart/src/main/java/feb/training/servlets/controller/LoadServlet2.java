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




	@WebServlet("/load2")
	public class LoadServlet2 extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);

	        if (session == null || session.getAttribute("user") == null) {
	            response.sendRedirect(request.getContextPath() + "/testlogin2");
	            return;
	        }

	        request.getRequestDispatcher("test1.jsp").forward(request, response);
	    }
	}
