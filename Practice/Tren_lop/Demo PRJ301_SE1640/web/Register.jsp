<%-- 
    Document   : Register
    Created on : Oct 13, 2022, 4:25:17 PM
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
        <form action="regis" method="post">
            Account<input type="text" name="acc">
            <br>Password<input type="text" name="pass">
            <br>Name<input type="text" name="name">
            <br>Gender<input type="radio" name="gender" value="1">Male 
                      <input type="radio" name="gender" value="2">Female
            
            <br>Birthdate<input type="text" name="dob">
            <br>Address<input type="text" name="address">
            
            <br><input type="submit" value="REGISTER" name="register">
            <br><br>${mess}
            
        </form>
    </body>
</html>
