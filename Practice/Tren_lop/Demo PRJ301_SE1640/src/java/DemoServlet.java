
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nguye
 */
public class DemoServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //đây là nơi viết code cho sevlet phần method post
      resp.setContentType("text/html;charset = UTF-8");
      try(PrintWriter out = resp.getWriter()){
           out.println("Hello Servlet");
           out.println("<form action='demo2' method='get'>");
           out.println("Enter a:<input type='text' name='a'>");
           out.println("<br> Enter b:<input type='text' name='b'>");
           out.println("<br> <input type='submit' name='OKt' value='OK'>");
           out.println("</form>");
           
           //nhận thông tin từ client
           int a= Integer.parseInt(req.getParameter("a"));
           int b= Integer.parseInt(req.getParameter("b"));
           
           //xử lý thoong tin
           int c=a-b;
           
           //trả về kết uqar cho client
           out.println("<br>a-b="+c);
           
       }catch(Exception e){
           
       }
    }
      
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //đây là nơi viết code cho sevlet phần method get hoặc không ns gì
       resp.setContentType("text/html;charset = UTF-8");
       try(PrintWriter out = resp.getWriter()){
           out.println("Hello Servlet");
           out.println("<form  method='post'>");
           out.println("Enter a:<input type='text' name='a'>");
           out.println("<br> Enter b:<input type='text' name='b'>");
           out.println("<br> <input type='submit' name='OKt' value='OK'>");
           out.println("</form>");
           
           //nhận thông tin từ client
           int a= Integer.parseInt(req.getParameter("a"));
           int b= Integer.parseInt(req.getParameter("b"));
           
           //xử lý thoong tin
           int c=a+b;
           
           //trả về kết uqar cho client
           out.println("<br>a+b="+c);
           
       }catch(Exception e){
           
       }
    }
    
}
