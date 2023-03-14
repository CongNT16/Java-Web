
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
public class ex3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Calculation";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String c3 = "";
            String err3 = "";
            String err = "";
            int n3 = 0;
            try {
                n3 = Integer.parseInt(req.getParameter("n3"));

                if (n3 <= 1 || n3 >= 100) {
                    err3 += "Nhập n trong khoảng 1 < n < 100";
                }
                req.setAttribute("n3", String.valueOf(n3));

            } catch (NumberFormatException e) {
                err3 += " n Invalid";

            }

            String op = req.getParameter("op");
            if (op.isEmpty()) {
                //nếu para đặt trong context para(web.xml)
                //thì tất cả servlet đều có thể gọi theo cú phép sau
//                    err=getServletContext().getInitParameter("err");

                //nếu param đặt tỏng innit-param trong 1 servlet 
                //thì chỉ servelet có thể gọi
                err = getInitParameter("err");
                req.setAttribute("err", err);

                req.getRequestDispatcher("Exercise3.jsp").forward(req, resp);

            }

            if (!err3.equals("")) {
                out.print(err3);
                req.setAttribute("err3", err3);
                req.getRequestDispatcher("Exercise3.jsp").forward(req, resp);

            }
            {

                if (op.equals("Tổng n số liên tiếp")) {

                    int sum = n3 * (n3 + 1) / 2;

                    out.println("Tổng các số liên tiếp từ 1 đến " + n3 + " là: " + sum);
                    c3 += sum;
                }

                if (op.equals("Tính n!")) {

                    long giaithua = 1;
                    if (n3 == 0) {
                        giaithua = 1;
                    } else {
                        for (int i = 1; i <= n3; i++) {
                            giaithua *= i;
                        }
                    }

                    out.println(n3 + "! = " + giaithua);
                    c3 += giaithua;
                }

                if (op.equals("In dãy lẻ")) {

                    out.println("Dãy số lẻ từ 1 đến " + n3 + " là: ");
                    for (int i = 1; i <= n3; i++) {
                        if (i % 2 == 1) {
                            out.print(i);
                            c3 += i;
                            if (i <= n3 - 1) {
                                out.print(", ");
                                c3 += ", ";
                            }
                        }
                    }

                }

                if (op.equals("In dãy chẵn")) {

                    out.println("Dãy số chẵn từ 1 đến " + n3 + " là: ");
                    for (int i = 1; i <= n3; i++) {
                        if (i % 2 == 0) {
                            out.print(i);
                            c3 += i;
                            if (i <= n3 - 1) {
                                out.print(", ");
                                c3 += ", ";
                            }
                        }
                    }
                }

                if (op.equals("Kiểm tra số nguyên tố")) {

                    boolean check_nguyento = true;

                    if (n3 <= 1) {
                        check_nguyento = false;
                    }

                    if (n3 == 2 || n3 == 3) {
                        check_nguyento = true;
                    }

                    for (int i = 2; i <= Math.sqrt(n3); i++) {

                        if (n3 % i == 0) {
                            check_nguyento = false;
                            break;
                        }
                    }

                    if (check_nguyento == true) {
                        out.println(" " + n3 + " là số nguyên tố");
                        c3 += "true";
                    } else {
                        out.println(" " + n3 + " không là số nguyên tố");
                        c3 += "false";
                    }

                }

                req.setAttribute("c3", c3);
                req.getRequestDispatcher("Exercise3.jsp").forward(req, resp);

            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
