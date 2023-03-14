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
        <title>Exercise 1</title>
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
                /*margin:auto;*/
                border: 2px solid blue;
                margin-left: 400px; 
                padding-left: 20px;
                margin-right: 550px; 
                background-color: white;
            }



        </style>
        
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String c1="";
            if(request.getAttribute("c1")!=null)
            c1=(String)request.getAttribute("c1");
            
            String a1="";
            if(request.getAttribute("a1")!=null)
            a1=(String)request.getAttribute("a1");
            
            String b1="";
            if(request.getAttribute("b1")!=null)
            b1=(String)request.getAttribute("b1");
            
            String err1="";
            if(request.getAttribute("err1")!=null)
            err1=(String)request.getAttribute("err1");
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
                    <form action="ex1" method="post"  >

                        <h3 style="color: blue; text-align: center">THỰC HIỆN PHÉP TOÁN</h3>
                        Nhập a: <input type="text" name="a1" style="background-color: #CCFFFF" value="<%=a1%>"> <br><br>
                        Nhập b: <input type="text" name="b1" style="background-color: #CCFFFF" value="<%=b1%>"> <br><br> 
                        &emsp;&emsp;&emsp;
                        <button type="submit" name="cal" value="+">a+b</button>
                        <button type="submit" name="cal" value="-">a-b</button>
                        <button type="submit" name="cal" value="*">a*b</button>
                        <button type="submit" name="cal" value="/">a/b</button><br><br>
                        &emsp;&emsp;&emsp;
                        <label style="color: blue; font-weight: bold;">KẾT QUẢ </label>
                        <input type="text" name="showans" readonly style="background-color: #FFCCFF" size="2" value="<%=c1%>">
                        <br><br><%=err1%>
                        <br>


                    </form>
                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
