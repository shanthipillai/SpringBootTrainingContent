package feb.training.servlets.controller;

import java.io.IOException;
import javax.servlet.annotation.WebInitParam;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/httpservice") 
public class HttpServletVsService extends HttpServlet{
	
	

    @Override
    public void init() throws ServletException {
        System.out.println("👉 init() method called - Servlet Created");
        
       
        
    }

    // 2. service() → called for every request
	
    
    
	  @Override protected void service(HttpServletRequest req, HttpServletResponse
	  resp) throws ServletException, IOException {
	  
	  System.out.println("👉 service() method called - Handling Request");
	  
	  resp.setContentType("text/html");
	  resp.getWriter().println("<h2>Service Called</h2>");
	  resp.getWriter().println("<p>Check console for lifecycle logs</p>"); 
	  doGet(req, resp);
	  }
	  
	 
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
  
    	 resp.setContentType("text/html");
         resp.getWriter().println("<h2>Do Post Method Called</h2>");
        
    }

    // 3. destroy() → called once before servlet removal
    @Override
    public void destroy() {
        System.out.println("👉 destroy() method called - Servlet Destroyed");
        try{
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("👉 destroy() called - end");
    }
}
