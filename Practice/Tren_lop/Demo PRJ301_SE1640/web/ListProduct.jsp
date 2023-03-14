<%-- 
    Document   : ListProduct
    Created on : Oct 20, 2022, 4:47:14 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
    </head>
    <body>
        <table border = "1">
            <tr>
                <td>Product ID</td>    
                <td>Product Name</td>
                <td>Unit Price</td>
                <td>Unit In Stock</td>
                <td>Image</td>
            </tr>
            <a href="productcontroller">Show list product</a>
            <br>
            <a href="AddProduct.jsp">Add new product</a>
            <c:forEach items="${list}" var="item">

                <tr>

                    <td><a href="detail?id=${item.getCode()}">${item.getCode()}</a></td>
                    <td>${item.getName()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getStock()}</td>
                    <!--<td>${item.getImage()}</td>-->
                    <td><img style="width: 90px; height: 70px;" src="images/${item.getImage()}"></td>

                    <td><a href="edit?id=${item.getCode()}">Edit</a></td>

                </tr> 
            </c:forEach>
        </table>
    </body>
</html>
