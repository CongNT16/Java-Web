<%-- 
    Document   : Caculation
    Created on : Sep 29, 2022, 2:52:39 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caculation</title>
        <script>
            function change(){
                document.getElementById("f").submit();
            }
        </script>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String c="";
            if(request.getAttribute("c")!=null)
            c=(String)request.getAttribute("c");
            
            String a="";
            if(request.getAttribute("a")!=null)
            a=(String)request.getAttribute("a");
            
            String b="";
            if(request.getAttribute("b")!=null)
            b=(String)request.getAttribute("b");
            
            String err="";
            if(request.getAttribute("err")!=null)
            err=(String)request.getAttribute("err");
        %>
        <form action='ca' method='get' id="f">
            Enter a:<input type='text' name='a' value="<%=a%>">
            <br> Enter b:<input type='text' name='b' value="<%=b%>">
        
        <br>Operator:
        <select name="op" onchange="change()">
            <option value="">All Operator</option>
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        
        <br> <input type='submit' name='OK' value='OK'>
        <br><br>Result: <input type="text" naem="result" readonly value="<%=c%>">
        
        <br><%=err%>
    </body>
</html>
