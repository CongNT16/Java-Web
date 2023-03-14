<%-- 
    Document   : input
    Created on : Sep 8, 2022, 9:42:34 PM
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
        <script language = "JavaScript">
	var Ten, Tuoi;		// Khai bao 2 bien de luu ten va tuoi
	Ten  = prompt("Bạn hãy nhập vào tên ", "");
	Tuoi = prompt("Bạn hãy nhập vào Tuổi : ", 20);		
	document.write("Chào bạn : <B> " + Ten + "</B>");
	document.write("<BR>");  // Xuống dòng
	document.write("Tuổi của bạn là : <U> " + Tuoi + "</U>");
</script>

    </body>
</html>
