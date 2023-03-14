<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 01</title>
    </head>
    <style>
        body{
            border: 2px solid orange;
            width: 300px;
            height: 300px;
            margin: auto;
            text-align: center;
        }
        h2{
            margin-top: 0;
            color: blue;
        }
        div{
            float: left;
            margin-left: 2px;
            text-align: center;
        }
        .nhap{
            float: left;
        }
        .input{
            width: 90px;
            margin-right: 5px;
            word-wrap:break-word;
        }
        .submit{
            width: 50px;
            font-weight: bold;
        }
        .reset{
            color: red;
            font-weight: bold;
        }
        .output{
            height: 150px;
            width: 135px;
        }
    </style>
    <body>
        <form action="test1">
            <%
                String a = "";
                if(request.getAttribute("a") != null)
                a = (String)request.getAttribute("a");
                String result = "";
                if(request.getAttribute("result") != null)
                result = (String)request.getAttribute("result");
            %>
            <h2>PRIME DIVISOR</h2>
            <div>    
                <p class="nhap"><i><b>Enter an integer n:</b></i></p>
                <p><br><input class="input" type="text" value="<%=a%>" name="a"><input class="submit" type="submit" value=">>"></p>
                <p><br><a href="Test1.jsp" target="_parent"><input class="reset" type="button" value="RESET"></a></p>
            </div>
                <br><br><input class="output" type="text" value="<%=result%>" readonly>
        </form>
    </body>
</html>
