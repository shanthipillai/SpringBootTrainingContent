<%@ page language="java" %>

<style>
.delete-wrapper {
    width: 100%;
    display: flex;
    justify-content: center;
    padding-top: 50px;
}

.delete-card {
    width: 420px;
    background: white;
    border-radius: 14px;
    padding: 30px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.delete-card h2 {
    text-align: center;
    color: #1f2a44;
    margin-bottom: 10px;
}

.subtitle {
    text-align: center;
    font-size: 13px;
    color: #666;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 18px;
}

input {
    width: 100%;
    padding: 10px;
    border-radius: 8px;
    border: 1px solid #ccc;
}

.btn {
    width: 100%;
    padding: 12px;
    background: #e74c3c;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
}

.btn:hover {
    background: #c0392b;
}

.msg {
    text-align: center;
    margin-bottom: 12px;
    padding: 8px;
    border-radius: 6px;
    font-size: 14px;
}

.success {
    background: #e6ffe6;
    color: green;
}

.error {
    background: #ffe6e6;
    color: red;
}
</style>

<div class="delete-wrapper">

    <div class="delete-card">

        <h2>Delete User</h2>
        <p class="subtitle">Enter User ID to delete user</p>

        <!-- ✅ MESSAGE -->
        <%
            String success = (String) request.getAttribute("success");
            String error = (String) request.getAttribute("error");

            if (success != null) {
        %>
            <div class="msg success"><%= success %></div>
        <%
            } else if (error != null) {
        %>
            <div class="msg error"><%= error %></div>
        <%
            }
        %>

        <!-- ✅ FORM -->
        <form action="<%= request.getContextPath() %>/deleteUser" method="post">

            <div class="form-group">
                <input type="text" name="userId" placeholder="Enter User ID" required>
            </div>

            <button type="submit" class="btn">Delete User</button>

        </form>

    </div>

</div>