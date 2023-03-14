
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
public class DemoServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //đây là nơi viết code cho sevlet phần method post

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //đây là nơi viết code cho sevlet phần method get hoặc không ns gì
        resp.setContentType("text/html;charset = UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
//           out.println("Hello Servlet");
//           out.println("<form>");
//           out.println("Enter a:<input type='text' name='a'>");
//           out.println("<br> Enter b:<input type='text' name='b'>");
//           out.println("<br> <input type='submit' name='OKt' value='OK'>");
//           out.println("</form>");

            //nhận thông tin từ client
            double a = 0;
            double b = 0;
            String err = null;

            try {
                a = Double.parseDouble(req.getParameter("a"));

            } catch (NumberFormatException e) {
                err += "a is Invalid " + "<br>";
            }

            try {
                b = Double.parseDouble(req.getParameter("b"));

            } catch (NumberFormatException e) {
                err += "b is Invalid "  + "<br>";

            }
            
            
//            
//            double a  = Double.parseDouble(req.getParameter("a"));
//            double b  = Double.parseDouble(req.getParameter("b"));
            
            if(err == null){

            String op = req.getParameter("op");

            String c = "";

            if (op.equals("+")) {

                c = String.valueOf(a + b);

            }

            if (op.equals("-")) {
                c = String.valueOf(a - b);

            }

            if (op.equals("*")) {
                c = String.valueOf(a * b);

            }

            if (op.equals("/")) {
                c = String.valueOf(a / b);

            }

            out.print("a " + op + " b = " + c);}
            else{
                out.print(err);
            }

//       req.getRequestDispatcher("index.hmtl").forward(req, resp);
        } catch (Exception e) {

        }
    }
}
