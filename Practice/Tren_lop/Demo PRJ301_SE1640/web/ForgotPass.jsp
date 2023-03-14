<%-- 
    Document   : ForgotPass
    Created on : Oct 13, 2022, 4:28:18 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="get">
            Account<input type="text" name="acc">
            <br>Birthdate<input type="text" name="dob">
            <br>New Password<input type="text" name="pass" >
            
            
            <br><input type="submit" value="Reset Pass" name="reset">
            
        </form>
    </body>
</html>
