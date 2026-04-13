package feb.training.servlets.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	    urlPatterns = "/genservlet2",
	    initParams = {
	      @WebInitParam(name = "course", value = "Microservices"),
	        @WebInitParam(name = "trainer", value = "Dev")
	    }
	   ) 
public class GenericServlet2 extends GenericServlet {
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("👉 init() method called - Servlet Created by 2");
		 ServletConfig config = getServletConfig();
			ServletContext appcontext=getServletContext();
	       
	        System.out.println(config.getInitParameter("course"));
	        System.out.println(config.getInitParameter("trainer"));
	        
	        System.out.println(appcontext.getInitParameter("company"));
	        System.out.println(appcontext.getInitParameter("client"));
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        System.out.println("👉 service() method called - Handling Request 2");

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Servlet Lifecycle Demo</h2>");
        resp.getWriter().println("<p>Check console for lifecycle logs</p>");
		
	}
	
	@Override
	public void destroy() {
		 System.out.println("👉 destroy() method called - Servlet Destroyed 2");
	        try{
	            Thread.sleep(3000); // 3 seconds delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("👉 destroy() called - end");
	}
	   
}
