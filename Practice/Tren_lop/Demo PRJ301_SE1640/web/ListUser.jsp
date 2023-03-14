<%-- 
    Document   : ListUser
    Created on : Oct 13, 2022, 3:32:55 PM
    Author     : nguye
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login successful!</h1>
        <%
            ArrayList<User> list = new ArrayList<>();
            if(request.getAttribute("list") != null){
                list = (ArrayList<User>)request.getAttribute("list");
            }
        %>
        <table border="1">
            <tr>
                <td>Account</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Birthdate</td>
                <td>Address</td>
            </tr>
            <%
                for(User item:list){
                    out.print("<tr>");
                    out.print("<td>" +item.getAccount()+ "</td>");
                    out.print("<td>" +item.getName()+ "</td>");
                    out.print("<td>" +item.getGender()+ "</td>");
                    out.print("<td>" +item.getDob()+ "</td>");
                    out.print("<td>" +item.getAddress()+ "</td>");
                    out.print("</tr>");
                }
            %>
        </table>

        <br><br>List User-Using JSTL-EL
        <table border = "1">
            <tr>
                <td>Account</td>    
                <td>Name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>Birthdate</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.getAccount()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getDob()}</td>
                    <td>${item.getAddress()}</td>
                </tr> 
            </c:forEach>
        </table>

    </body>
</html>