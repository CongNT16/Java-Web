<%-- 
    Document   : ResetPassword
    Created on : Oct 18, 2022, 4:51:44 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <form action="regis" method="get">
            Account<input type="text" name="acc" value="${account}">
            <br>Password<input type="text" name="pass" value="${pass}">
            <br>New Password<input type="text" name="newpass1" value="${newpass1}">
            <br>Renew Password<input type="text" name="newpass2" value="${newpass2}">
            <br><input type="submit" name="UPDATE" value="UPDATE">
            <br>${mess}
        </form>
    </body>
</html>
