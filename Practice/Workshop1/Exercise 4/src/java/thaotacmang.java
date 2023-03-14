
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
public class thaotacmang extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Thao tac mang";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String input = req.getParameter("input");
            String op = null;
                    op = req.getParameter("op");
            String mang = "";
            String[] array = input.split(",");

            boolean check_array = true;

            for (int x = 0; x < array.length; x++) {

                try {
                    int n = Integer.parseInt(array[x]);

                } catch (NumberFormatException e) {

                    check_array = false;

                }

            }

            if (check_array == false) {
                out.print("Nhập lại mảng là các số nguyên.");

            } else {
                
                if(op == null ){
                out.print("choose submid<br>");

               }

                if (op.equals("enter-arr")) {
                    mang = input;
                    out.print("đã nhập<br>");

                }

                if (op.equals("print-arr")) {

                    out.print("Mảng đã nhập là: ");

                    for (int i = 0; i < array.length; i++) {
                        out.print(array[i]);
                        if (i < array.length - 1) {
                            out.print(", ");
                        }
                    }

                }

                if (op.equals("tong-le")) {
                    int sum = 0;
                    for (int i = 0; i < array.length; i++) {
                        int a = Integer.parseInt(array[i]);
                        if (a % 2 == 1) {
                            sum = a + sum;
                        }
                    }
                    out.print("Tổng các số lẻ trong mảng là: " + sum);
                }

                if (op.equals("tich-chan")) {
                    int tich = 1;
                    for (int i = 0; i < array.length; i++) {
                        int b = Integer.parseInt(array[i]);
                        if (b % 2 == 0) {
                            tich *= b;
                        }
                    }
                    out.print("Tích các số chẵn trong mảng là: " + tich);
                }

                if (op.equals("sort")) {

                    for (int j = 0; j < array.length; j++) {
                        for (int i = j + 1; i < array.length; i++) {

                            if (array[i].compareTo(array[j]) < 0) {
                                String temp = array[j];
                                array[j] = array[i];
                                array[i] = temp;
                            }
                        }

                    }
                    out.print("Mảng sau khi đã sắp xếp là: ");
                    for (int i = 0; i < array.length; ++i) {
                        out.print(array[i]);
                        if (i < array.length - 1) {
                            out.print(", ");
                        }
                    }

                }
            }

        } catch (Exception e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }

}
