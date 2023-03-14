<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 2</title>
    </head>
    <style>
        form{
            border: 2px solid green;
            width: 400px;
            height: 300px;
            margin-top: 200px;
            margin-left: 500px;
        }
        
        h1{
            margin-top: 0;
            color: orange;
            text-align: center;
        }
        p{
            font-size: 20px;
        }     
        div{        
            text-align: center;
            font-size: 20px;
        }
        
        #box_input{
            width: 90px;
            margin-right: 5px;
            word-wrap:break-word;
        }
        #button_submit{
            width: 50px;
            font-weight: bold;
            color: red;
        }
        #button_reset{
            color: red;
            font-weight: bold;
        }
        #box_output{
            width: 300px;
            background-color: #d9d9d9;
        }
    </style>
    <body>
        <%
                String n = "";
                if(request.getAttribute("n") != null)
                n = (String)request.getAttribute("n");
                String result = "";
                if(request.getAttribute("result") != null)
                result = (String)request.getAttribute("result");
        %>
        <form action="test2" method="post">

            <h1>PRIME NUMBER</h1>
            <p><i><b>Enter an integer n:</b></i></p>
            <div>    
                <br><input id="box_input"  type="text" value="<%=n%>" name="n">
                <a href="Test2.jsp" target="_parent"><input id="button_reset" name="reset" type="button" value="RESET"></a>
                <br><br><b>Show n prime number >= n</b>
                <br><input id="button_submit" name="submit" type="submit" value="--V--">
                <br><br><input id="box_output" name="output" type="text" value="<%=result%>" readonly>
            </div>
        </form>
    </body>
</html>
