<%-- 
    Document   : Detail
    Created on : Oct 30, 2022, 4:59:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="row">
           <div class ="col-md-2"></div>
            <div class="col-md-6">

                <h1><span>FPT University Academic Portal</span>
                </h1>

            </div>
            <div class="col-md-4">
                <table>
                    <tbody><tr>
                        <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>

                    </tr>
                    <tr>
                        <td><a href="https://apps.apple.com/app/id1527723314">
                             <img src='img/appStore.jpg' style="width: 120px; height: 40px" alt="apple store"></a></td>
                        <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                            <img src='img/GoogleStore.jpg' style="width: 120px; height: 40px" alt="google store"></a></td>

                    </tr>
                </tbody></table>
            </div>
        </div>
        
         <div class="row">
           <div class ="col-md-2"></div>
            <div class="col-md-6">
<table>
<tbody><tr style="border-bottom: 0 none">
<td>
<div>
<h2>User detail</h2>

<table><tbody>
<tr><td><b>Login</b></td><td><span id="ctl00_mainContent_lblLogin">   ${studentId}</span></td></tr>

<tr><td><b>Full name</b></td><td><span id="ctl00_mainContent_lblFullname"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">   ${name}</font></font></span></td></tr>
<tr><td><b>Image</b></td><td><img id="ctl00_mainContent_imgUser" src='img/profile.jpg' style="height:150px;width:120px;border-width:0px;"></td></tr>
<tr><td><b>Email</b></td><td><span id="ctl00_mainContent_lblEmail"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${email}</font></font></span></td></tr>
</tbody></table>
<input name="ctl00$mainContent$txtError" type="hidden" id="ctl00_mainContent_txtError">
</div>
</td>
</tr>
<tr style="border-bottom: 0 none">
<td>
<br>
<table width="100%" style="border: 1px solid transparent;" id="cssTable">
<tbody><tr>
<td>
<div id="ctl00_divSupport">
<br>
<b><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">For any comments or questions, please contact: </font></font></b><span style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Student Service Department</font></font></span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> : Email: </font></font><a href="mailto:dichvusinhvien@fe.edu.vn"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">dichvusinhvien@fe.edu.vn</font></font></a><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> . </font><font style="vertical-align: inherit;">Phone: </font></font><span class="style1" style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">(024)7308.13.13</font></font></span>
<br>
</div>
</td>
</tr>
<tr>
<td>
<p style="text-align: center">
 © Powered by <a href="" target="_blank">FPT University</a>&nbsp;|&nbsp;
<a href="" target="_blank">CMS</a>&nbsp;|&nbsp; <a href="" target="_blank">library</a>&nbsp;|&nbsp; <a href="" target="_blank">books24x7</a>
<span id="ctl00_lblHelpdesk"></span>
</p>
</td>
</tr>
</tbody></table>

</div>

    </body>
</html>
