<%-- 
    Document   : contac
    Created on : Oct 18, 2022, 11:34:12 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact</title>
        <link rel="stylesheet" type="text/css" href="./assets/css/layout.css">
        <link rel="stylesheet" type="text/css" href="./assets/css/contact.css">
        <link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    </head>
    <body>
        
        <jsp:include page="layout/header.jsp" />
        
        <div class="container-contact">
            <div class="contact-box">
                <div class="left"></div>
                <div class="right">
                    <h2>Contact Laputa</h2>
                    <input type="text" class="field" placeholder="Your Name" value="nguyen thanh cong" readonly="">
                    <input type="text" class="field" placeholder="Your Email" value="nguyencongno55@gmail.com" readonly="">
                    <!--<input type="text" class="field" placeholder="Phone" value="0857689020" readonly="">-->
                    <textarea placeholder="Message" class="field"></textarea>
                    <button class="btn">Send</button>
                    <br>
                    <div class="social-media">
                        <ul>
                            <li><a href="https://www.facebook.com/nguyencong.1606/"><img src="assets/images/contact/facebook.png"></a></li>
                            <li><a href="https://www.linkedin.com/in/nguyencong1606/"><img src="assets/images/contact/linkedin.png"></a></li>
                            <li><a href="https://github.com/Laputa16"><img src="assets/images/contact/github.png"></a></li>
                            <li><a href="https://twitter.com/Laputa_1606"><img src="assets/images/contact/twitter.png"></a></li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="layout/footer.jsp" />
        
        
    </body>
    <script src="./assets/js/datetime.js"></script>   
    <script src="./assets/js/layout.js"></script>
</html>