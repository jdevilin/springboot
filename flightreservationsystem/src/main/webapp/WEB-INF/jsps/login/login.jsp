<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>

</head>
<body>
<form action="login" method="post">
<h1>Login :</h1>
<pre>
User : <input type="text" name="email">
password : <input type="password" name="password"> 
<input type="submit" value="Login">
${msg}
</pre>
</form>
</body>
</html>