
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
public class ex2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Find min max";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {
            
            

            double a2 = 0;
            double b2 = 0;
            double c2 = 0;
            double d2 = 0;
            String at = "";
            String bt = "";
            String ct = "";
            String err2 = "";
            String err1 = "";
            String find = null;
            find = req.getParameter("find");
            String click= req.getParameter("click");
            
            if(click.equals("tim")){

            if (find == null) {
                out.print("choose submid<br>");
                at = req.getParameter("a2");
                bt = req.getParameter("b2");
                ct = req.getParameter("c2");
                req.setAttribute("a2", String.valueOf(at));
                req.setAttribute("b2", String.valueOf(bt));
                req.setAttribute("c2", String.valueOf(ct));
                err1 += "choose submid<br>";
                req.setAttribute("err1", err1);
                req.getRequestDispatcher("Exercise2.jsp").forward(req, resp);

            }
            {

                try {
                    a2 = Double.parseDouble(req.getParameter("a2"));
                    req.setAttribute("a2", String.valueOf(a2));

                } catch (NumberFormatException e) {
                    err2 += "a is Invalid <br>";
                }

                try {
                    b2 = Double.parseDouble(req.getParameter("b2"));
                    req.setAttribute("b2", String.valueOf(b2));

                } catch (NumberFormatException e) {
                    err2 += "b is Invalid <br>";

                }

                try {
                    c2 = Double.parseDouble(req.getParameter("c2"));
                    req.setAttribute("c2", String.valueOf(c2));

                } catch (NumberFormatException e) {
                    err2 += "c is Invalid <br>";

                }

                if (!err2.equals("")) {
                    out.print(err2);
                    req.setAttribute("err2", err2);
                    req.getRequestDispatcher("Exercise2.jsp").forward(req, resp);

                }
                {

                    if (find.equals("max")) {
                        double max = a2;
                        if (max < b2) {
                            max = b2;
                        }
                        if (max < c2) {
                            max = c2;
                        }

                        out.println("Số lớn nhất là: " + max);
                        d2 = max;
                    }

                    if (find.equals("min")) {
                        double min = a2;
                        if (min > b2) {
                            min = b2;
                        }
                        if (min > c2) {
                            min = c2;
                        }

                        out.println("Số nhỏ nhất là: " + min);
                        d2 = min;
                    }

                    req.setAttribute("d2", String.valueOf(d2));
                    req.getRequestDispatcher("Exercise2.jsp").forward(req, resp);

                }

            }}
            if(click.equals("xoa")){
                req.getRequestDispatcher("Exercise2.jsp").forward(req, resp);
                  
            }
        } catch (Exception e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
