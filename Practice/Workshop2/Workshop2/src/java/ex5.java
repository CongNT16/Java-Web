
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
public class ex5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Thao tac doan van";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String click = req.getParameter("click");
            String input = req.getParameter("input");
            String err1 = "";
            String length = "";

            int index = 0;
            String indext ="";
            String valueIndex = "";
            String err2 = "";

            String strFind = "";
            String rsFind = "";
            String err3 = "";

            int start = 0;
            String startt = "";
            int end = 0;
            String endt ="";
            String result = "";
            String err4 = "";
            
            String nop= req.getParameter("nop");
            
            if(nop.equals("submit")){

            if (input.length() == 0) {
                out.print("hãy nhập mảng");
                err1 += "hãy nhập mảng" ;
            } else {

//                if (click.equals("tongkytu")) {
                int a = input.length();

                out.print("Tổng số ký tự:  " + a);
                length += a;

//                }
//                if (click.equals("kytutuongung")) {
                try {

                    index = Integer.parseInt(req.getParameter("index"));
                    indext += index;

                    boolean checknhap = true;

                    if (index <= 0 || index > input.length()-1) {

                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        err2 += "Nhập vị trí trong khoảng từ 1 đến " + input.length() ;
                        checknhap = false;

                    }

                    if (checknhap == true) {

                        out.print("Ký tự tương ứng là: ");

                        for (int i = 0; i < input.length(); i++) {

                            if (i == index) {
                                out.print(input.charAt(i - 1) + " ");
                                valueIndex += input.charAt(i - 1) + " ";
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    out.print("Phải nhập vị trí là số nguyên");
                    err2 += "Phải nhập vị trí là số nguyên";

                }

//                }
//                if (click.equals("vitrituongung")) {
                strFind = req.getParameter("strFind");
                if (strFind != "") {
                    out.print("Vị trí tương ứng là:  ");

                    input = input.trim().toLowerCase();

                    boolean check = false;

                    for (int i = 0; i < input.length(); i++) {

                        if (i == input.indexOf(strFind, i)) {
                            out.println(i + 1);
                            rsFind += i + 1;
                            if (i < input.length() -2) {
                                out.print(", ");
                                rsFind += ", ";
                            }
                            
                            check = true;

                        }
                    }

                    if (check != true) {
                        out.print("Không tìm thấy");
                        rsFind += "Không tìm thấy";
                    }
                } else {
                    err3 += "Hãy nhập một ký tự";
                }

//                }
//                if (click.equals("ketqua")) {
                try {

                    start = Integer.parseInt(req.getParameter("start"));
                    startt += start;
                    end = Integer.parseInt(req.getParameter("end"));
                    endt += end;

                    boolean checkvitri = true;

                    if (start <= 0 || end <= 0 || start > input.length() || end > input.length()) {

                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        err4 += "Nhập vị trí trong khoảng từ 1 đến " + input.length() ;
                        checkvitri = false;

                    }

                    if (start > end) {
                        out.print("Nhập lại, start phải nhỏ hơn end. <br>");
                        err4 += "<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Nhập lại, start phải nhỏ hơn end.";
                        checkvitri = false;

                    }
                    if (checkvitri == true) {

//                            if (end > start) {
                        String[] slice = new String[end - start + 1];

                        for (int i = 0; i < slice.length; i++) {

                            out.print(input.charAt(start + i - 1));
                            result += input.charAt(start + i - 1);

                        }
//                            } else {
//
//                                String[] slice = new String[start - end + 1];
//
//                                for (int i = 0; i < slice.length; i++) {
//
//                                    out.print(input.charAt(end + i - 1));
//
//                                }
//
//                            }
                    }
                } catch (NumberFormatException e) {
                    out.print("Phải nhập vị trí là số nguyên");
                    err4 += "Phải nhập vị trí là số nguyên";

                }

//                }
            }
            req.setAttribute("input", input);
            req.setAttribute("length", length);
            req.setAttribute("index", indext);
            req.setAttribute("valueIndex", valueIndex);
            req.setAttribute("strFind", strFind);
            req.setAttribute("rsFind", rsFind);
            req.setAttribute("start", startt);
            req.setAttribute("end", endt);
            req.setAttribute("result", result);
            req.setAttribute("err1", err1);
            req.setAttribute("err2", err2);
            req.setAttribute("err3", err3);
            req.setAttribute("err4", err4);
            req.getRequestDispatcher("Exercise5.jsp").forward(req, resp);

        }if(nop.equals("nhaplai")){
        req.getRequestDispatcher("Exercise5.jsp").forward(req, resp);}
        
        if(nop.equals("thoat")){
        req.getRequestDispatcher("Ex_Servlet.jsp").forward(req, resp);}
        
        
        }catch (Exception e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Thao tac doan van";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String click = req.getParameter("click");
            String input = req.getParameter("input");
            String err = "";
            String length = "";

            int index = 0;
            String valueIndex = "";

            String strFind = "";
            String rsFind = "";

            int start = 0;
            int end = 0;
            String result = "";

            if (input.length() == 0) {
                out.print("hãy nhập mảng");
                err += "hãy nhập mảng" + "<br>";
            } else {

                if (click.equals("tongkytu")) {

                    int a = input.length();

                    out.print("Tổng số ký tự:  " + a);
                    length += a;

                }

                if (click.equals("kytutuongung")) {
                    try {

                        index = Integer.parseInt(req.getParameter("index"));

                        boolean checknhap = true;

                        if (index <= 0 || index > input.length()) {

                            out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                            err += "Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>";
                            checknhap = false;

                        }

                        if (checknhap == true) {

                            out.print("Ký tự tương ứng là: ");

                            for (int i = 0; i < input.length(); i++) {

                                if (i == index) {
                                    out.print(input.charAt(i - 1) + " ");
                                    valueIndex += input.charAt(i - 1) + " ";
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        out.print("Phải nhập vị trí là số nguyên");
                        err += "Phải nhập vị trí là số nguyên <br>";

                    }

                }

                if (click.equals("vitrituongung")) {
                    strFind = req.getParameter("strFind");
                    out.print("Vị trí tương ứng là:  ");

                    input = input.trim().toLowerCase();

                    boolean check = false;

                    for (int i = 0; i < input.length(); i++) {

                        if (i == input.indexOf(strFind, i)) {
                            out.println(i + 1);
                            rsFind += i + 1;
                            if (i < input.length() - 1) {
                                out.print(", ");
                                rsFind += ", ";
                            }
                            check = true;

                        }
                    }

                    if (check != true) {
                        out.print("Không tìm thấy");
                        rsFind += "Không tìm thấy";
                    }

                }

                if (click.equals("ketqua")) {

                    try {

                        start = Integer.parseInt(req.getParameter("start"));
                        end = Integer.parseInt(req.getParameter("end"));

                        boolean checkvitri = true;

                        if (start <= 0 || end <= 0 || start > input.length() || end > input.length()) {

                            out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                            err += "Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>";
                            checkvitri = false;

                        }

                        if (start > end) {
                            out.print("Nhập lại, start phải nhỏ hơn end. <br>");
                            err += "Nhập lại, start phải nhỏ hơn end. <br>";
                            checkvitri = false;

                        }
                        if (checkvitri == true) {

//                            if (end > start) {
                            String[] slice = new String[end - start + 1];

                            for (int i = 0; i < slice.length; i++) {

                                out.print(input.charAt(start + i - 1));
                                result += input.charAt(start + i - 1);

                            }
//                            } else {
//
//                                String[] slice = new String[start - end + 1];
//
//                                for (int i = 0; i < slice.length; i++) {
//
//                                    out.print(input.charAt(end + i - 1));
//
//                                }
//
//                            }
                        }
                    } catch (NumberFormatException e) {
                        out.print("Phải nhập vị trí là số nguyên");
                        err += "Phải nhập vị trí là số nguyên";

                    }

                }
            }
            req.setAttribute("input", input);
            req.setAttribute("length", length);
            req.setAttribute("index", String.valueOf(index));
            req.setAttribute("valueIndex", valueIndex);
            req.setAttribute("strFind", strFind);
            req.setAttribute("rsFind", rsFind);
            req.setAttribute("start", String.valueOf(start));
            req.setAttribute("end", String.valueOf(end));
            req.setAttribute("result", result);
            req.setAttribute("err", err);
            req.getRequestDispatcher("Exercise5.jsp").forward(req, resp);

        } catch (Exception e) {

        }
    }

}
