<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

<style>
h3{
font-family:Calibri;
font-size:25pt;
font-style:normal;
font-weight:bold;
color:SlateBlue;
text-align:center;
text-decoration:underline
}
</style>
</head>
<body>

<h3>Login Page</h3>

${error}
<form method="post"action="${PageContext.request.contextPath}/login">
<table border="0" cellpadding="2" cellpacing="2">
<tr>
<td>UserName(E-mail)</td>
<td><input type="text"name="username"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password"name="password"></td>
</tr>

<tr>
<td>&nbsp;</td>
<td><input type="submit"value="Login"></td>
</tr>
</table>
</form>


</body>
</html>