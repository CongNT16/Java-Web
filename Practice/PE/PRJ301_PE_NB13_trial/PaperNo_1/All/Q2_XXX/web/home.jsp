<%-- 
    Document   : home
    Created on : Nov 1, 2022, 4:48:11 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                border: 1px solid #000;
            }

            table th,
            table td {
                border: 1px solid #000;
            }

            .action {
                display: flex;
                justify-content: space-around;
            }
        </style>
    </head>
    <body>
        <form action="search" method="get">
            Name <input type="text" name="name"/>
            <input type="submit" value="Search"/>
            <br/>
        </form>
        <c:if test="${requestScope.data != null}">
            <table>
                <tr>
                    <th>sid</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>dob</th>
                </tr>
                <c:forEach items="${requestScope.data}" var="p">
                    <tr>
                        <td>${p.getSid()}</td>
                        <td>${p.getName()}</td>
                        <td>${p.getGender()}</td>
                        <td>${p.getDob()}</td>
                    </tr>
                </c:forEach>
            </table>
            </c:if>
    </body>
</html>
