<%@ page language="java" %>

<style>
    * {
        box-sizing: border-box;
    }

    .insert-wrapper {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        padding-top: 40px;
    }

    .form-container {
        background: white;
        padding: 30px 35px;
        border-radius: 12px;
        width: 380px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
    }

    .form-container h2 {
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
        font-size: 14px;
        transition: 0.2s;
    }

    .form-group input:focus {
        outline: none;
        border-color: #1f2a44;
        box-shadow: 0 0 5px rgba(31,42,68,0.2);
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #1f2a44;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
    }

    .btn:hover {
        background: #0f172a;
    }

    .msg {
        text-align: center;
        margin-bottom: 12px;
        font-size: 14px;
        font-weight: 500;
        padding: 8px;
        border-radius: 6px;
    }

    .success {
        color: green;
        background: #e6ffe6;
    }

    .error {
        color: red;
        background: #ffe6e6;
    }
</style>

<%
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");

    // ✅ Clear values after success
    String userIdVal = (success != null) ? "" : request.getParameter("userId");
    String emailVal  = (success != null) ? "" : request.getParameter("email");

    if (userIdVal == null) userIdVal = "";
    if (emailVal == null) emailVal = "";
%>

<div class="insert-wrapper">

    <div class="form-container">

        <h2>Insert User</h2>

        <!-- ✅ MESSAGE DISPLAY -->
        <% if (success != null) { %>
            <div class="msg success"><%= success %></div>
        <% } else if (error != null) { %>
            <div class="msg error"><%= error %></div>
        <% } %>

        <!-- ✅ FORM -->
        <form action="<%= request.getContextPath() %>/insert" method="post">

            <div class="form-group">
                <input type="text" name="userId" placeholder="User ID"
                       value="<%= userIdVal %>" required>
            </div>

            <div class="form-group">
                <input type="password" name="password" placeholder="Password" required>
            </div>

            <div class="form-group">
                <input type="email" name="email" placeholder="Email"
                       value="<%= emailVal %>" required>
            </div>

            <button type="submit" class="btn">Insert User</button>

        </form>

    </div>

</div>

<!-- ✅ AUTO HIDE MESSAGE -->
<script>
    setTimeout(() => {
        let msg = document.querySelector('.msg');
        if (msg) msg.style.display = 'none';
    }, 3000);
</script>