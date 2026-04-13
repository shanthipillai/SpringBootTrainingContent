<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
body {
	margin: 0;
	font-family: Arial;
}

/* NAVBAR */
.navbar {
	background-color: #2c3e50;
	color: white;
	padding: 15px;
}

.navbar a {
	color: white;
	text-decoration: none;
	margin-left: 15px;
}

.nav-right {
	float: right;
}

/* MAIN CONTAINER */
.container {
	display: flex;
	height: 80vh;
}

/* LEFT IMAGE */
.left-side {
	width: 50%;
	background: url('images/mvc.png') no-repeat center;
	background-size: cover;
}

/* RIGHT LOGIN */
.right-side {
	width: 50%;
	display: flex;
	justify-content: center;
	align-items: center;
}

/* LOGIN BOX */
.login-box {
	width: 400px;
	padding: 30px;
	border: 1px solid #ccc;
	border-radius: 12px;
	box-shadow: 3px 3px 15px gray;
	background-color: rgba(255, 255, 255, 0.95);
}

/* FORM */
.form-group {
	text-align: left;
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-group input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

/* BUTTON */
.login-box input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #2c3e50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

/* FOOTER */
.footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #2c3e50;
	color: white;
	text-align: center;
	padding: 10px;
}
</style>

</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
	<span>Model View Controller (MVC)</span>

	<div class="nav-right">
		<a href="register.jsp">Register</a>
	</div>
</div>

<!-- BODY -->
<div class="container">

	<!-- LEFT IMAGE -->
	<div class="left-side"></div>

	<!-- RIGHT LOGIN -->
	<div class="right-side">

		<div class="login-box">

			<!-- ✅ SUCCESS MESSAGE -->
			<%
			String msg = request.getParameter("msg");
			if ("registered".equals(msg)) {
			%>
				<p style="color: green; text-align: center;">
					Registration successful! Please login.
				</p>
			<%
			}
			%>

			<!-- ❌ ERROR MESSAGE -->
			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
				<p style="color: red; text-align: center; margin-bottom: 15px;">
					<%= error %>
				</p>
			<%
			}
			%>

			<h3>Login</h3>

			<form action="login" method="post">

				<div class="form-group">
					<label>UserId</label>
					<input type="text" name="userId" />
				</div>

				<div class="form-group">
					<label>Password</label>
					<input type="password" name="password" />
				</div>

				<input type="submit" value="Login" />

			</form>

		</div>

	</div>

</div>

<!-- FOOTER -->
<div class="footer">
    <div class="footer-content">
        <span>© 2026 SpringBoot Training</span>
        <span class="divider">|</span>
        <span>Designed & Developed by <b>Shanthi Pillai</b></span>

        <div class="footer-icons">
            <i class="fa-brands fa-java"></i>
            <i class="fa-solid fa-database"></i>
            <i class="fa-solid fa-code"></i>
        </div>
    </div>
</div>

</body>
</html>