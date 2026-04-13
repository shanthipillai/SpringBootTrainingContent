<%@ page language="java" %>
<%@ page import="feb.training.servlets.model.User" %>

<%
    User user = (User) request.getAttribute("user");
%>

<style>
.update-wrapper {
    width: 100%;
    display: flex;
    justify-content: center;
    padding-top: 40px;
}

.update-card {
    width: 420px;
    background: white;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.update-card h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #1f2a44;
}

.form-group {
    margin-bottom: 15px;
}

.form-group input {
    width: 100%;
    padding: 10px;
    border-radius: 6px;
    border: 1px solid #ccc;
}

.btn {
    width: 100%;
    padding: 12px;
    background: #1f2a44;
    color: white;
    border: none;
    border-radius: 6px;
}
</style>

<div class="update-wrapper">

    <div class="update-card">

        <h2>Edit User</h2>

        <form action="<%= request.getContextPath() %>/updateUser" method="post">

            <!-- UserId readonly -->
            <div class="form-group">
                <input type="text" name="userId"
                       value="<%= user.getUserId() %>" readonly>
            </div>

            <!-- Password -->
            <div class="form-group">
                <input type="text" name="password"
                       value="<%= user.getPassword() %>">
            </div>

            <!-- Email -->
            <div class="form-group">
                <input type="email" name="email"
                       value="<%= user.getEmail() %>">
            </div>

            <button type="submit" class="btn">Update User</button>

        </form>

    </div>

</div>