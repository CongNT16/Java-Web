<%-- 
    Document   : display
    Created on : Dec 11, 2019, 8:42:50 AM
    Author     : sonnt
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

        <main>
            <form>
                <c:forEach items="${data}" var="data">
                    ${data.getContent()}
                    <ul style="list-style-type: none;"> 
                        <c:forEach items="${data.getAnswers()}" var="ans">
                            <li>${ans.getContent()}</li>
                            </c:forEach>
                    </ul>
                </c:forEach>

            </form>

        </main>

    </body>
</html>
