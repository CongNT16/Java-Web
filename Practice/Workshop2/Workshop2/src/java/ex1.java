
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
public class ex1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Calculation";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            double a1 = 0;
            double b1 = 0;
            double c1 = 0;
            String err1 = "";

            try {
                a1 = Double.parseDouble(req.getParameter("a1"));
                req.setAttribute("a1", String.valueOf(a1));

            } catch (NumberFormatException e) {
                err1 += "&emsp;&emsp;&emsp;a is Invalid <br>";
            }

            try {
                b1 = Double.parseDouble(req.getParameter("b1"));
                req.setAttribute("b1", String.valueOf(b1));

            } catch (NumberFormatException e) {
                err1 += "&emsp;&emsp;&emsp;b is Invalid <br>";

            }
            
            if(!err1.equals("")){
            out.print(err1);
            req.setAttribute("err1", err1);
            req.getRequestDispatcher("Exercise1.jsp").forward(req, resp);

            }{



                String cal = req.getParameter("cal");

                if (cal.equals("+")) {
                    c1 = a1 + b1;

                }

                if (cal.equals("-")) {
                    c1 = a1 - b1;
                }

                if (cal.equals("*")) {
                    c1 = a1 * b1;
                }

                if (cal.equals("/")) {
                    c1 = a1 / b1;
                }

//                out.print("a " + cal + " b = ");
//                out.format("%.3f", c);

                
                
                
                req.setAttribute("c1", String.valueOf(c1));
                req.getRequestDispatcher("Exercise1.jsp").forward(req, resp);

}

        } catch (Exception e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
