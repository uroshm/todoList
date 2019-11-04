<html>
<head>
<title>Login Page</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/Login" method="POST">
        Name : <input name="login" type="text" /> Password : <input name="pw" type="password" /> <input type="submit" />
    </form>
</body>
</html>