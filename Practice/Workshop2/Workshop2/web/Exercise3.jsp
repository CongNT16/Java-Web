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
        <title>Exercise 3</title>
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
                margin-right: 400px;
                border: 2px solid red;
                padding: 5px 10px 15px 10px;
                background-color: white;
            }
            form.td{
                padding: 5px;
            }

        </style>
        <script>
            function change(){
                document.getElementById("f").submit();
            }
        </script>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String n3="";
            if(request.getAttribute("n3")!=null)
            n3=(String)request.getAttribute("n3");
            
            String c3="";
            if(request.getAttribute("c3")!=null)
            c3=(String)request.getAttribute("c3");
            
            String err3="";
            if(request.getAttribute("err3")!=null)
            err3=(String)request.getAttribute("err3");
            
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
                    <form action="ex3" method="POST" id="f">
                        <h3 style="color: blue; text-align: center;" >THỰC HIỆN PHÉP TOÁN</h3>
                        <table>
                            <tr>
                                <td><span style="color: blue;font-weight: bold;" >Nhập n </span></td>
                                <td><input type="text" name="n3" value="<%=n3%>">  <span style="font-weight: bold;" >(1 &lt; n &lt;100)</span></td>
                            </tr> 
                            <tr>
                                <td><span style="color: blue;font-weight: bold;">Chọn phép toán </span></td>
                                <td>
                                    <select name="op" onchange="change(this)" id="chon">
                                        <!--<option value=""></option>-->
                                        <option value="" disabled selected hidden>Tổng n số liên tiếp</option>
                                        <option >Tổng n số liên tiếp</option>
                                        <option >Tính n!</option>
                                        <option >In dãy lẻ</option>
                                        <option >In dãy chẵn</option>
                                        <option >Kiểm tra số nguyên tố</option>

                                    </select></td>
                            </tr> 
                            <tr>
                                <td><span style="color: blue; font-weight: bold;">Kết quả </span></td>
                                <td><input type="text" name="result" value="<%=c3%>" readonly>
                            </tr>
                            <tr>
                                <td></td>
                                <td><%=err3%><br><%=err%></td>
                            </tr>
                                
                                    <!--&emsp;<button type="submit" name="cal">Cal</button></td><tr>-->
                        </table>

                    </form>
                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
