<%@ page isErrorPage="true" %>

<html>
<body>

<h2>Something went wrong ❌</h2>

<p>Error Message: <%= exception.getMessage() %></p>

<p>Exception Type: <%= exception.getClass().getName() %></p>

<a href="test.jsp">Go Back</a>

</body>
</html>