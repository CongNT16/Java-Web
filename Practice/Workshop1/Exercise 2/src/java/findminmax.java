
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
public class findminmax extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Find min max";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            double a = 0;
            double b = 0;
            double c = 0;
            String err = "";
            String find = null;
             find = req.getParameter("find");

            try {
                a = Double.parseDouble(req.getParameter("a"));

            } catch (NumberFormatException e) {
                err += "a is Invalid <br>";
            }

            try {
                b = Double.parseDouble(req.getParameter("b"));

            } catch (NumberFormatException e) {
                err += "b is Invalid <br>";

            }

            try {
                c = Double.parseDouble(req.getParameter("c"));

            } catch (NumberFormatException e) {
                err += "c is Invalid <br>";

            }
            
            

            if (err == "") {

                if(find == null){
                
                out.print("choose submid"); 
                
            }else

                if (find.equals("max")) {
                    double max = a;
                    if (max < b) {
                        max = b;
                    }
                    if (max < c) {
                        max = c;
                    }

                    out.println("Số lớn nhất là: " + max);
                }

                if (find.equals("min")) {
                    double min = a;
                    if (min > b) {
                        min = b;
                    }
                    if (min > c) {
                        min = c;
                    }

                    out.println("Số nhỏ nhất là: " + min);
                }

            } else {
                out.print(err);
            }

        } catch (Exception e) {

        }
    }

}
