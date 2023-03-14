<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : List
    Created on : Dec 15, 2022, 2:15:48 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Page</title>
    </head>
    <body>
        <h1>Session of ${displayName}</h1>
        
        <table boder="1">
            <tr>
                <th>id</th> 
                <th>title</th> 
                <th>create_date</th> 
                <th>create_by</th> 
            </tr>
            <c:forEach items="${list}" var="article">
            <tr>
                
                <td>${article.getId()}</td>
                <td>${article.getTitle()}</td>
                <td>${article.getCreated_date()}</td>
                <td>${article.getCreated_by()}</td>
                
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
