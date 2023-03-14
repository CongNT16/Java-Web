<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 01</title>
    </head>
    <style>
        body{
            border: 2px solid green;
            width: 400px;
            height: 300px;
            margin: auto;
            font-size: 20px;
        }
        h3{
            margin-top: 0;
            color: blue;
            text-align: center;
        }
        .input{
            width: 150px;
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
        .output1{
            width: 155px;
            height: 144px;
        }
        .output{
            width: 155px;
        }
    </style>
    <body>
        <form action="test3">
            <%
                String a = "";
                if(request.getAttribute("a") != null)
                a = (String)request.getAttribute("a");
                String result1 = "";
                if(request.getAttribute("result1") != null)
                result1 = (String)request.getAttribute("result1");
                String result2 = "";
                if(request.getAttribute("result2") != null)
                result2 = (String)request.getAttribute("result2");
                String err = "";
                if(request.getAttribute("err") != null)
                err = (String)request.getAttribute("err");
            %>
            <h3>INPUT AND CALCULATE</h3>
            <table border="0">
                <tr>
                    <td><b><i>Enter an integer n:</i></b></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input class="input" type="text" value="<%=a%>" name="a">
                        <input class="submit" type="submit" value=">>">
                    </td>
                    <td rowspan="6" align="center"><input style="border: 1px solid blue" class="output1" type="text" value="<%=result1%>" readonly></td>
                </tr>
                <tr>
                    <td rowspan="3" align="center"><a href="Test3.jsp" target="_parent"><input class="reset" type="button" value="RESET"></a></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><b>Sum of number in list:</b></td>
                    <td><input class="output" type="text" value="<%=result2%>" readonly></td>
                </tr>
            </table>
        </form>
    </body>
</html>
