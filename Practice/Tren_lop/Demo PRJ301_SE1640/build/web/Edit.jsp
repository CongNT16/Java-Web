<%-- 
    Document   : Edit
    Created on : Oct 25, 2022, 5:04:46 PM
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
        <form action="edit" method="post">
            Code: <input type="text" value="${product.getCode()}" readonly name="productid">
        <br>Name<input type="text" value="${product.getName()}" name="productname">
        <br>Price<input type="text" value="${product.getPrice()}" name="unitprice">
        <br>
        <input type="submit" name="click" value="Update"> 
        <input type="submit" name="click" value="Delete"> 
        
        </form>
    </body>
</html>
