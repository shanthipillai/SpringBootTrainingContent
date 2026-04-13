<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            margin: 0;
            height: 100vh;
            background: linear-gradient(135deg, #1f2a44, #0f172a);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Card */
        .card {
            width: 380px;
            background: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }

        .card h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #1f2a44;
        }

        /* Inputs */
        .form-group {
            margin-bottom: 18px;
        }

        label {
            font-size: 14px;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 11px;
            border: 1px solid #ccc;
            border-radius: 6px;
            transition: 0.3s;
        }

        input:focus {
            border-color: #1f2a44;
            outline: none;
        }

        /* Button */
        .btn {
            width: 100%;
            padding: 12px;
            background: #1f2a44;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn:hover {
            background: #0f172a;
        }

        /* Footer link */
        .footer {
            text-align: center;
            margin-top: 15px;
            font-size: 13px;
        }

        .footer a {
            color: #1f2a44;
            text-decoration: none;
            font-weight: 500;
        }

        .footer a:hover {
            text-decoration: underline;
        }

        /* Error */
        .error {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }

        .success {
            color: green;
            text-align: center;
            margin-bottom: 10px;
        }

    </style>
</head>

<body>

<div class="card">

    <h2>Create Account</h2>

    <!-- Messages -->
    <%
        String error = (String) request.getAttribute("error");
        String success = (String) request.getAttribute("success");

        if (error != null) {
    %>
        <div class="error"><%= error %></div>
    <%
        }

        if (success != null) {
    %>
        <div class="success"><%= success %></div>
    <%
        }
    %>

    <form action="register" method="post">

        <div class="form-group">
            <label>User ID</label>
            <input type="text" name="userId" required />
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required />
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required />
        </div>

        <button class="btn">Register</button>

    </form>

    <div class="footer">
        Already have an account?
        <a href="login.jsp">Login</a>
    </div>

</div>

</body>
</html>