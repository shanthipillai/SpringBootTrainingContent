<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Registration Success</title>

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
    background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),
                url('images/bg.jpg');
    background-size: cover;
}

/* SUCCESS BOX */
.success-box {
    width: 400px;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 3px 3px 15px gray;
    background-color: rgba(255,255,255,0.95);
    text-align: center;
}

/* BUTTON */
.success-box a {
    display: block;
    margin-top: 15px;
    padding: 10px;
    background-color: #2c3e50;
    color: white;
    text-decoration: none;
    border-radius: 5px;
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

    <div class="success-box">
        <h2 style="color:green;">Registration Successful 🎉</h2>

        <p>Your account has been created successfully.</p>

       
        <a href="home.jsp">Go to Home</a>
    </div>

</div>

<!-- FOOTER -->
<div class="footer">
    SpringMVCProject
</div>

</body>
</html>