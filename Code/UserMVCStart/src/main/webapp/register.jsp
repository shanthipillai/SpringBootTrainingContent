<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

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

/* CONTAINER */
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
	background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url('images/bg.jpg');
	background-size: cover;
}

/* REGISTER BOX */
.register-box {
	width: 400px;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 3px 3px 15px gray;
	background-color: rgba(255, 255, 255, 0.95);
}

/* FORM */
.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-group input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

/* BUTTON */
.register-box input[type="submit"] {
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
		<span>My Application</span>

		<div class="nav-right">
			<a href="home.html">Home</a>
		</div>
	</div>

	<!-- BODY -->
	<div class="container">

		<div class="register-box">
			<h2>Register</h2>

			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<p style="color: red; text-align: center;"><%=error%></p>
			<%
			}
			%>
			<form action="register" method="post">

				<div class="form-group">
					<label>UserId</label> <input type="text" name="userId" />
				</div>

				<div class="form-group">
					<label>Password</label> <input type="password" name="password" />
				</div>

				<div class="form-group">
					<label>Email</label> <input type="email" name="email" />
				</div>

				<input type="submit" value="Register" />

			</form>
		</div>

	</div>

	<!-- FOOTER -->
	<div class="footer">SpringMVCProject</div>

</body>
</html>