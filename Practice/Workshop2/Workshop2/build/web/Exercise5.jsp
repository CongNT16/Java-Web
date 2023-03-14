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
        <title>Exercise 5</title>
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
                /*margin-top: 100px;*/
                margin-left: 350px;
                margin-right: 200px;
                border: 2px solid violet;
                padding: 5px 10px 15px 20px;
                background-color: white;
            }
            .underline{
                padding-top: 2px;
                background-color: gray;
            }

        </style>
    </head>
    <body>
        <%
            //nhận giá trị attribute c truyền từ servlet
            String input="";
            if(request.getAttribute("input")!=null)
            input=(String)request.getAttribute("input");
            
            String length="";
            if(request.getAttribute("length")!=null)
            length=(String)request.getAttribute("length");
            
            String index="";
            if(request.getAttribute("index")!=null)
            index=(String)request.getAttribute("index");
            
            String valueIndex="";
            if(request.getAttribute("valueIndex")!=null)
            valueIndex=(String)request.getAttribute("valueIndex");
            
            String strFind="";
            if(request.getAttribute("strFind")!=null)
            strFind=(String)request.getAttribute("strFind");
            
            String rsFind="";
            if(request.getAttribute("rsFind")!=null)
            rsFind=(String)request.getAttribute("rsFind");
            
            String start="";
            if(request.getAttribute("start")!=null)
            start=(String)request.getAttribute("start");
            
            String end="";
            if(request.getAttribute("end")!=null)
            end=(String)request.getAttribute("end");
            
            String result="";
            if(request.getAttribute("result")!=null)
            result=(String)request.getAttribute("result");
            
            String err1="";
            if(request.getAttribute("err1")!=null)
            err1=(String)request.getAttribute("err1");
            
            String err2="";
            if(request.getAttribute("err2")!=null)
            err2=(String)request.getAttribute("err2");
            
            String err3="";
            if(request.getAttribute("err3")!=null)
            err3=(String)request.getAttribute("err3");
            
            String err4="";
            if(request.getAttribute("err4")!=null)
            err4=(String)request.getAttribute("err4");
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
                    <form action="ex5" method="post" >
                        <h3 style="text-align: center; font-size: 20pt;"> Đối tượng String</h3><br>
                        Nhập đoạn văn :  <input type="text" name="input" style="margin-left: 40px;" value="<%=input%>"> <br><br>

                        Tổng số ký tự <input name="length" type="text" value="<%=length%>" readonly size="10" style="background-color: #CCFFFF"> &emsp;
                        <!--<button type="submit" name="click" value="tongkytu">click</button>-->
                        &ensp; <%=err1%>
                        <br><br>

                        <div class="underline"></div><br><br>

                        Nhập vị trí <input type="text" name="index" value="<%=index%>" size="1"> &ensp;

                        Ký tự tương ứng <input type="text" name="valueIndex" value="<%=valueIndex%>" readonly size="20" style="background-color: #CCFFFF">&emsp;
                        <!--<button type="submit" name="click" value="kytutuongung">click</button>--> 
                        &ensp; <%=err2%>
                        <br><br>

                        <div class="underline"></div><br><br>

                        Nhập chuỗi <input type="text" name="strFind" value="<%=strFind%>" size="1"> &ensp;

                        Vị trí tương ứng <input type="text" name="rsFind" value="<%=rsFind%>" readonly size="20" style="background-color: #CCFFFF">&emsp;
                        <!--<button type="submit" name="click" value="vitrituongung">click</button>--> 
                        &ensp; <%=err3%><br><br> 

                        <div class="underline"></div><br><br>

                        Nhập vị trí cần tách Từ <input type="text" name="start" value="<%=start%>" size="1" >
                        Đến <input type="text" name="end" value="<%=end%>" size="1"> <br><br>
                        Kết quả <input type="text" name="result" value="<%=result%>" readonly style="background-color: #CCFFFF">&emsp;
                        <!--<button type="submit" name="click" value="ketqua">click</button>--> 
                        &ensp; <%=err4%><br><br> 
                        
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        <button type="submit" name="nop" value="submit">submid</button>
                        <button type="submit" name="nop" value="nhaplai">Nhập lại</button>                       
                        <button type="submit" name="nop" value="thoat">Thoát</button><br>

                    </form>
                </td>
            </tr>

            <tr id='footer1'>
                <td colspan='2' align='center'>@Copyright by Nguyễn Thành Công</td>	
            </tr>
        </table>
    </body>
</html>
