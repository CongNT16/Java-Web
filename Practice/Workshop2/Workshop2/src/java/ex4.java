
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
public class ex4 extends HttpServlet {

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
            String err = "";
            String err2 = "";
            String output = "";
            String input2="";
            String click= req.getParameter("click");
            
            if(click.equals("thuchien")){
            

            if (op == null) {
//                out.print("choose submid<br>");
                input2 += req.getParameter("input");
                err2 += "choose submid";
                req.setAttribute("input", input2);
                req.setAttribute("err2", err2);
                req.getRequestDispatcher("Exercise4.jsp").forward(req, resp);

            }
            {

                boolean check_array = true;

                for (int x = 0; x < array.length; x++) {

                    try {
                        int n = Integer.parseInt(array[x]);
                        req.setAttribute("input", input);
                    } catch (NumberFormatException e) {

                        check_array = false;

                    }

                }

                if (check_array == false) {
//                out.print("Nhập lại mảng là các số nguyên.");
                    err += "Nhập lại mảng là các số nguyên.";
                    req.setAttribute("err", err);
                    req.getRequestDispatcher("Exercise4.jsp").forward(req, resp);
                } else {

                    if (op.equals("enter-arr")) {
//                    mang = input;
                        out.print("đã nhập<br>");
                        output += "Đã nhập";
                    }

                    if (op.equals("print-arr")) {

                        out.print("Mảng đã nhập là: ");

                        for (int i = 0; i < array.length; i++) {
                            out.print(array[i]);
                            output += array[i];
                            if (i < array.length - 1) {
                                out.print(", ");
                                output += ", ";
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
                        output += sum;
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
                        output += tich;
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
                            output += array[i];
                            if (i < array.length - 1) {
                                out.print(", ");
                                output += ", ";
                            }
                        }

                    }
                }

                req.setAttribute("output", output);

                req.getRequestDispatcher("Exercise4.jsp").forward(req, resp);

            }}
            if(click.equals("thoat")){
                req.getRequestDispatcher("Ex_Servlet.jsp").forward(req, resp);
                  
            }
        } catch (Exception e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }

}
