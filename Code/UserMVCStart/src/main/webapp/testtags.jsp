<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert titles here</title>
</head>
<body>
<%--  <jsp:include page="header.jsp"/>   
 --%>	
 
 <%@ include file="header.jsp"%>
	
	
	<%!
	public void jspInit() {
		System.out.println("JSP INIT called");
	}

	public void jspDestroy() {
		System.out.println("JSP DESTROY called");
	}
	
	%>

	<%
	System.out.println("JSP SERVICE called");
	%>

	<%
	int count = 10;
	%>


	<%!
	int count1 = 10;
	%>
	
	
	<h1>
		Hello JSP Lifecycle
		count=<%=count++%>
		count1=<%=count1++%></h1>
</body>
</html>