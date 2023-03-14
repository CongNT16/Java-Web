<%-- 
    Document   : Exercise2
    Created on : Sep 29, 2022, 9:28:02 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 2</title>
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
                margin-right: 550px;
                border: 2px solid blue;
                padding: 5px 10px 15px 10px;
                background-color: white;
            }
            form.td{
                padding: 5px;
            }

        </style>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String c2="";
            if(request.getAttribute("c2")!=null)
            c2=(String)request.getAttribute("c2");
            
            String a2="";
            if(request.getAttribute("a2")!=null)
            a2=(String)request.getAttribute("a2");
            
            String b2="";
            if(request.getAttribute("b2")!=null)
            b2=(String)request.getAttribute("b2");
            
            String d2="";
            if(request.getAttribute("d2")!=null)
            d2=(String)request.getAttribute("d2");
            
            String err1="";
            if(request.getAttribute("err1")!=null)
            err1=(String)request.getAttribute("err1");
            
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
                    <form action="ex2" method="POST" >
                        <h3 style="color: blue; text-align: center">TÌM MAX VÀ TÌM MIN</h3>
                        <table>
                            <tr>
                                <td>Nhập a: </td>
                                <td><input type="text" name="a2" value="<%=a2%>" style="background-color: #CCFFFF" ></td>
                            </tr>
                            <tr>
                                <td>Nhập b: </td>
                                <td><input type="text" name="b2" value="<%=b2%>" style="background-color: #CCFFFF"></td>
                            </tr>
                            <tr>
                                <td>Nhập c: </td>
                                <td><input type="text" name="c2" value="<%=c2%>" style="background-color: #CCFFFF"></td>
                            </tr>
                            <tr>
                                <td>Kết quả: </td>
                                <td><input type="text" name="ketqua" value="<%=d2%>" style="background-color: #CCFFFF" readonly></td>
                            </tr>
                            <tr>
                                <td></td>   
                                <td><%=err1%><br><%=err2%></td>
                            </tr>
                        </table><br>   

                        <input name="find" type="radio" value="max" />Tìm số lớn nhất 
                        <input name="find" type="radio" value="min" />Tìm số nhỏ nhất <br><br>

                        &emsp;&emsp;&emsp;&emsp;&emsp;
                        <button type="submit" name="click" value="tim">Tìm</button> 
                        &emsp;<button type="submit" name="click" value="xoa">Xoá</button>

                    </form>
                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
