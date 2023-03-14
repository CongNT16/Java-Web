
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
public class giaiphuongtrinh extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Giai phuong trinh";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            double a = 0;
            double b = 0;
            String err = "";

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
            if (err == "") {

                if (a != 0) {

                    out.print("Phương trình có một nghiệm x = ");
                    out.format("%.3f", -b / a);
                    out.print("<br><br><a href='./index.html' >return</a>");

                } else {
                    if (b == 0) {
                        out.print("Phương trình có vô số nghiệm.");
                    } else {
                        out.print("Phương trình vô nghiệm.");
                    }
                }
            } else {
                out.print(err);
            }

        } catch (Exception e) {

        }
    }

}
