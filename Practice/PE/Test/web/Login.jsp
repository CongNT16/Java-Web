<%-- 
    Document   : Login
    Created on : Nov 6, 2022, 11:40:11 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <form action="login" method="post">
                Username: <input type="text" name="username"/>
                <br>Password: <input type="password" name="password"/>
                <br><input type="submit" value="Login"/>
            </form>
            <c:if test="${requestScope.loginMsg != null}">
                <h4 style="color: red;">${requestScope.loginMsg}</h4>
            </c:if>
            
        </div>
    </body>
</html>
