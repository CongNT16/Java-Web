<%-- 
    Document   : Example
    Created on : Sep 27, 2022, 4:42:24 PM
    Author     : nguye
--%>

<%@page import="java.io.IOException" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
           //Scriptlet
           String message="Scriptlet <br>";
           out.println(message);
           //khởi tạo 2 số nguyên a và b sau đó tính tổng hiệu tíhc thương chia dư của a và b
           
           int a =100;
           int b =50;
           
           int c=a+b;
           out.println("a+b = " + c + "<br>");
           
           c=a-b;
           out.println("a-b = " + c + "<br>");
           
           c=a*b;
           out.println("a*b = " + c + "<br>");
           
           c=a/b;
           out.println("a/b = " + c + "<br>");
           
           c=a%b;
           out.println("a%b = " + c + "<br>");
           
           //xây dựng hàm tìm ước chưng lớn nhất, tìm UCLN của a và b
           
           int ucln =1;
           for(int i = 1; i <= a && i <= b; i++){
            if(a%i==0 && b%i==0){
                ucln = i;
            }}
            
           out.println("<br>UCLN: " + (ucln));
           //Xây dựng hàm kiểm tra snt sau đó hiện thị n só nguyên tố đầu tiên vs n là UCLN của a và b
           

                out.println("<br><br>Cấc số nguyên tố từ 2 đến " + ucln);
                out.println("<br>");

                for (int n = 0; n < ucln; n++){
                       boolean check_nguyento = true;

                        if (n <= 1) {
                            check_nguyento = false;
                        }

                        if (n == 2 || n == 3) {
                            check_nguyento = true;
                        }

                        for (int i = 2; i <= Math.sqrt(n); i++) {

                            if (n % i == 0) {
                                check_nguyento = false;
                                break;
                            }
                        }

                        if (check_nguyento == true) {
                            out.println(n + ", ");
                        } 
                        }
        
        %>

        <%!
            String message="Java";
            
        %>
        <br>
        <br>a=<%=a%>
        <br>b=<%=b%>
        <br>a+b=<%=a+b%>
        <br>a-b=<%=a-b%>
        <br>a*b=<%=a*b%>
        <br>a/b=<%=a/b%>
        <br>a%b=<%=a%b%>
        
 
     
        
    </body>
</html>
