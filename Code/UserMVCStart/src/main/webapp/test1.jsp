<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String userid = (String) session.getAttribute("user");
	%>

	<h1>
		Welcome to Spring Boot Training
	Session Attribute=	<%=userid%><br>
		
	Request Attribute=	<%=request.getAttribute("reqid")%></h1><br>
	Context Attribute=<%=application.getInitParameter("company")%>
	Context Attributes=<%=application.getAttribute("Course")%>
     ConfigAttribute <%=config.getInitParameter("username") %>
	<a href="logout">Logout</a>
</body>
</html>