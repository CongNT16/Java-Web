<%-- 
    Document   : logout
    Created on : Oct 21, 2022, 10:41:45 AM
    Author     : nguye
--%>

<%
session.invalidate();
response.sendRedirect("home.jsp");
%>
