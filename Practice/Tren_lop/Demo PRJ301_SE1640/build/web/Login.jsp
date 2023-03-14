<%-- 
    Document   : Login
    Created on : Oct 11, 2022, 4:57:33 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            Account<input type="text" name="acc" value="${account}">
            <br>Password<input type="text" name="pass" value="${pass}">
            <br><input type="submit" name="LOGIN" value="LOGIN">
            <br><a href="Register.jsp"> Create an account</a>
            <br><a href="ForgotPass.jsp"> Forgot password</a>
            <br><a href="ResetPassword.jsp"> Reset Password</a>
        </form>
    </body>
</html>
