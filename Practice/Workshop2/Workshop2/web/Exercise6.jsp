<%-- 
    Document   : Exercise 1
    Created on : Sep 29, 2022, 9:16:12 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 6</title>
        <style>
            table.main {
                width:100%;
                height:750px;
                border:1px solid black;
            }

            table.main #logo{
                background:Blue;
                width:15%;
                height:15%;
            }
            table.main #banner{
                width:85%;
                height:15%;
            }
            table.main #menu1{
                background:Red;
                width:15%;
                height:70%;
                font-size:22;
                text-align:top;
            }
            table.main #content1{
                background:yellow;
                width:85%;
                height:70%;
            }
            table.main #footer1{
                background:green;
                width:100%;
                height:15%;
                font-size:25;
            }
            form{
                /*margin-top: 200px;*/
                margin-left: 400px;
                margin-right: 500px;
                border: 2px solid blue;
                padding: 5px 10px 15px 10px;
                background-color: white;
            }

        </style>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String a="";
            if(request.getAttribute("a")!=null)
            a=(String)request.getAttribute("a");
            
            String b="";
            if(request.getAttribute("b")!=null)
            b=(String)request.getAttribute("b");
            
            String c="";
            if(request.getAttribute("c")!=null)
            c=(String)request.getAttribute("c");
            
            String err="";
            if(request.getAttribute("err")!=null)
            err=(String)request.getAttribute("err");
        %>
        <table class='main'>
            <tr>
                <td id='logo'><img src='images/logo.jpg' width='150px'></td>
                <td id='banner' background='images/banner2.jpg'></td>
            </tr>

            <tr>
                <td id='menu1'>
                    <ul>
                        <li><a href="Exercise1.jsp">Exercise 1</a></li>
                        <li><a href="Exercise2.jsp">Exercise 2</a></li>
                        <li><a href="Exercise3.jsp">Exercise 3</a></li>
                        <li><a href="Exercise4.jsp">Exercise 4</a></li>
                        <li><a href="Exercise5.jsp">Exercise 5</a></li>
                        <li><a href="Exercise6.jsp">Exercise 6</a></li>
                    </ul>
                </td>
                <td id='content1'>
                    <form action="ex6" method="POST" >
                        <h3 style="color: blue; text-align: center; font-size: 20pt;">Giải phương trình bậc nhất</h3>
                        <!--a x + b = 0 <br><br>-->
                        <span style="font-weight: bold">Nhập a: </span><input type="text" name="a" value="<%=a%>"><br><br>
                        <span style="font-weight: bold">Nhập b: </span><input type="text" name="b" value="<%=b%>"><br><br>

                        &emsp;&emsp;&emsp;&emsp;&emsp;
                        <button type="submit" name="click" value="giaipt">Giải PT</button>
                        <a href="Ex_Servlet.jsp"><button type="submit"  name="click" value="thoat">Thoát</button></a>
                        <br><br>

                        <span style="font-weight: bold">Kết luận nghiệm</span><br><br>
                        &emsp;&emsp;<input type="text" name="results" value="<%=c%>" readonly size="40"><br><br>
                        <%=err%>

                    </form>
                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
