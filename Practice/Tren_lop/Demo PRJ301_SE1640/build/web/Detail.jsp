<%-- 
    Document   : Detail
    Created on : Oct 27, 2022, 3:04:24 PM
    Author     : nguye
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="order" method="post">
            Code: <input type="text" name="codeproduct" value="${p.getCode()}">
            <br>Name:  <input type="text" name="nameproduct" value="${p.getName()}">
            <br>Price:  <input type="text" name="priceproduct" value="${p.getPrice()}">
            <br>UnitInStock:  <input type="text" name="íntockproduct" value="${p.getStock()}">
            <br>Customer ID: 

            <select name="customerId">
                <c:forEach items="${listcustomer}" var="customer">
                    <option value="${customer.getCustomerID()}">${customer.getCustomerID()}</option>
                </c:forEach>

            </select>
            <br>
            <input type="submit" value="ORDER">

        </form>
    </body>
</html>
