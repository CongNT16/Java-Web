<%-- 
    Document   : login_client
    Created on : Oct 13, 2022, 10:30:56 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <br>
    <form>
        <h1>Login</h1>
        <table>
            <tr>
                <td>Account</td>
                <td><input type="text" name="account"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass"></td>
            </tr>
        </table>
        <input type="submit" name="login" value="LOGIN">
    </form>
</body>
</html>
