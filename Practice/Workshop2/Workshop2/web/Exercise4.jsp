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
        <title>Exercise 4</title>
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
                margin-right: 450px;
                border: 2px solid black;
                padding: 5px 10px 15px 20px;
                background-color: white;
            }

        </style>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String input="";
            if(request.getAttribute("input")!=null)
            input=(String)request.getAttribute("input");
            
            String output="";
            if(request.getAttribute("output")!=null)
            output=(String)request.getAttribute("output");
            
            String err="";
            if(request.getAttribute("err")!=null)
            err=(String)request.getAttribute("err");
            
            String err2="";
            if(request.getAttribute("err2")!=null)
            err2=(String)request.getAttribute("err2");
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
                    <form action="ex4" method="POST" >
                        <h3 style="text-align: center">Các thao tác với mảng</h3>
                        Nhập mảng  <input type="text" name="input" value="<%=input%>">
                        <br>                       
                        &emsp;&emsp;&emsp;&emsp;&emsp;<span style="font-size: 10pt">(nhập các số cách nhau bởi dấu ',')</span><br><br>
                        Kết quả &emsp; <input type="text" name="output" readonly value="<%=output%>">
                        <br><br> 
                        &emsp;&emsp;&emsp;&emsp;&emsp;<%=err2%><br>
                        &emsp;&emsp;&emsp;&emsp;&emsp;<%=err%><br><br>

                        Chọn <input name="op" type="radio" value="enter-arr"> Nhập mảng   
                        <input name="op" type="radio" value="print-arr"> In mảng <br>
                        <input name="op" type="radio" value="tong-le"> Tổng lẻ 
                        <input name="op" type="radio" value="tich-chan"> Tích chẵn 
                        <input name="op" type="radio" value="sort"> Sắp xếp <br><br>

                        &emsp;&emsp;&emsp;&emsp;&emsp;
                        <button type="submit" name="click" value="thuchien">Thực Hiện</button>
                        <a href="Ex_Servlet.jsp"><button type="submit" name="click" value="thoat">Thoát</button></a>

                    </form>

                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
