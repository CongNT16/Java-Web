
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
public class calculation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Calculation";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            try {
                int n = Integer.parseInt(req.getParameter("n"));

                if (n <= 1 || n >= 100) {
                    out.println("Nhập n trong khoảng 1 < n < 100");

                } else {

                    String op = req.getParameter("op");

                    if (op.equals("Tổng n số liên tiếp")) {

                        int sum = n * (n + 1) / 2;

                        out.println("Tổng các số liên tiếp từ 1 đến " + n + " là: " + sum);
                    }

                    if (op.equals("Tính n!")) {

                        long giaithua = 1;
                        if (n == 0) {
                            giaithua = 1;
                        } else {
                            for (int i = 1; i <= n; i++) {
                                giaithua *= i;
                            }
                        }

                        out.println(n + "! = " + giaithua);
                    }

                    if (op.equals("In dãy lẻ")) {

                        out.println("Dãy số lẻ từ 1 đến " + n + " là: ");
                        for (int i = 1; i <= n; i++) {
                            if (i % 2 == 1) {
                                out.print(i);
                                if (i <= n - 1) {
                                    out.print(", ");
                                }
                            }
                        }

                    }

                    if (op.equals("In dãy chẵn")) {

                        out.println("Dãy số chẵn từ 1 đến " + n + " là: ");
                        for (int i = 1; i <= n; i++) {
                            if (i % 2 == 0) {
                                out.print(i);
                                if (i <= n - 1) {
                                    out.print(", ");
                                }
                            }
                        }
                    }

                    if (op.equals("Kiểm tra số nguyên tố")) {

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
                            out.println(" " + n + " là số nguyên tố");
                        } else {
                            out.println(" " + n + " không là số nguyên tố");
                        }

                    }
                }

            } catch (NumberFormatException e) {
                out.println(" n Invalid");

            }

        } catch (Exception e) {

        }
    }

}
