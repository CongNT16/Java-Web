<%-- 
    Document   : Discusion
    Created on : Nov 1, 2022, 5:20:22 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discusion Page</title>
    </head>
    <body>
        <c:if test="${requestScope.data != null}">
            <c:forEach items="${requestScope.data}" var="i">
                <p style="margin: 0;">Thread: ${i.getContent()}</p>
                <c:forEach items="${i.getList()}" var="j">
                    <p style="margin: 0;">${j.getName()}: ${j.getContext()}</p>
                </c:forEach>
                <form action="comment" method="get">
                    <input type="hidden" name="tId" value="${i.getId()}" />
                    <input type="text" name="input"/><input type="submit" value="Save"/>
                </form>
            </c:forEach>
        </c:if>
    </body>
</html>
