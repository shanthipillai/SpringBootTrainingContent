<%@ page language="java" %>

<style>
    * {
        box-sizing: border-box;
    }

    .update-wrapper {
        width: 100%;
        display: flex;
        justify-content: center;
        padding-top: 50px;
    }

    .update-card {
        width: 420px;
        background: #ffffff;
        border-radius: 14px;
        padding: 30px 35px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
    }

    .update-card h2 {
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

    .form-group label {
        font-size: 14px;
        color: #333;
        display: block;
        margin-bottom: 6px;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        border-radius: 8px;
        border: 1px solid #ccc;
        font-size: 14px;
        transition: 0.2s;
    }

    .form-group input:focus {
        outline: none;
        border-color: #1f2a44;
        box-shadow: 0 0 6px rgba(31,42,68,0.2);
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #1f2a44;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 15px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        background: #0f172a;
    }

    .msg {
        text-align: center;
        margin-bottom: 12px;
        padding: 8px;
        border-radius: 6px;
        font-size: 14px;
    }

    .error {
        background: #ffe6e6;
        color: red;
    }
</style>

<div class="update-wrapper">

    <div class="update-card">

        <h2>Update User</h2>
        <p class="subtitle">Enter User ID to fetch details</p>

        <!-- ✅ ERROR MESSAGE -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="msg error"><%= error %></div>
        <%
            }
        %>

        <!-- ✅ FORM -->
        <form action="<%= request.getContextPath() %>/fetchUser" method="post">

            <div class="form-group">
                <label>User ID</label>
                <input type="text" name="userId" placeholder="Enter User ID" required>
            </div>

            <button type="submit" class="btn">Fetch User</button>

        </form>

    </div>

</div>