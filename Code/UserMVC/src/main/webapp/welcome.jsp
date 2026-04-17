<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>

    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f4f6f9;
        }

        .wrapper {
            display: flex;
            height: 100vh;
        }

        .sidebar {
            width: 250px;
            background: linear-gradient(180deg, #1f2a44, #0f172a);
            color: white;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            padding: 25px 20px;
        }

        .sidebar h2 {
            font-size: 22px;
        }

        .menu a {
            display: flex;
            align-items: center;
            gap: 15px;
            padding: 14px;
            margin: 8px 0;
            color: #cbd5e1;
            text-decoration: none;
            border-radius: 8px;
        }

        .menu a:hover {
            background: rgba(255,255,255,0.1);
            color: white;
        }

        .menu span {
            font-size: 26px;
        }

        .logout button {
            width: 100%;
            padding: 12px;
            background: #e74c3c;
            border: none;
            border-radius: 6px;
            color: white;
            cursor: pointer;
        }

        .content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .welcome-box {
            text-align: center;
        }
    </style>
</head>

<body>

<%
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj == null || sessionObj.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="wrapper">

    <div class="sidebar">

        <div>
            <h2>My Dashboard</h2>

            <div class="menu">
                <a href="load?view=insert">
                    <span class="material-symbols-outlined">add_circle</span>
                    Insert
                </a>

                <a href="load?view=update">
                    <span class="material-symbols-outlined">edit</span>
                    Update
                </a>

                <a href="load?view=delete">
                    <span class="material-symbols-outlined">delete</span>
                    Delete
                </a>

                <a href="load?view=fetch">
                    <span class="material-symbols-outlined">search</span>
                    Fetch
                </a>
            </div>
        </div>

        <div class="logout">
            <form action="logout" method="post">
                <button>Logout</button>
            </form>
        </div>

    </div>

    <div class="content">

       <%--  <%
            String pageContent = (String) request.getAttribute("pageContent");

            if (pageContent != null && !pageContent.trim().isEmpty()) {
        %>

            <jsp:include page="<%= pageContent %>" />

        <%
            } else {
        %>

            <div class="welcome-box">
                <h1>Welcome to Dashboard</h1>
                <p>Select an option from the left menu</p>
            </div>

        <%
            }
        %> --%>
        
        <c:choose>

    <c:when test="${not empty pageContent}">
        <jsp:include page="${pageContent}" />
    </c:when>

    <c:otherwise>
        <div class="welcome-box">
            <h1>Welcome to Dashboard</h1>
            <p>Select an option from the left menu</p>
        </div>
    </c:otherwise>

</c:choose>

    </div>

</div>

</body>
</html>