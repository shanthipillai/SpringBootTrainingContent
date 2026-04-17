<%@ page contentType="text/html;charset=UTF-8" %>
<%
    // Set attribute in request scope
    request.setAttribute("name", "admin");

    // Forward to admin.jsp
    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
    rd.forward(request, response);
%>