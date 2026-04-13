<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="feb.training.servlets.model.User" %>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<style>
.fetch-wrapper {
    width: 100%;
    display: flex;
    justify-content: center;
    padding-top: 40px;
}

.fetch-card {
    width: 600px;
    background: white;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.fetch-card h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #1f2a44;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background: #1f2a44;
    color: white;
}

tr:hover {
    background: #f2f2f2;
}

.no-data {
    text-align: center;
    color: #888;
    margin-top: 20px;
}
</style>

<div class="fetch-wrapper">

    <div class="fetch-card">

        <h2>User List</h2>

        <%
            if (users != null && !users.isEmpty()) {
        %>

        <table>
            <tr>
                <th>User ID</th>
                <th>Email</th>
            </tr>

            <%
                for (User u : users) {
            %>
            <tr>
                <td><%= u.getUserId() %></td>
                <td><%= u.getEmail() %></td>
            </tr>
            <%
                }
            %>

        </table>

        <%
            } else {
        %>
            <div class="no-data">No users found</div>
        <%
            }
        %>

    </div>

</div>