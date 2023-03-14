
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
public class insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Thao tac doan van";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String click = req.getParameter("click");
            String input = req.getParameter("text-input");

//            if (click.equals("tongkytu")) {

                int a = input.length();

                out.println("Tổng số ký tự:  " + a);
                out.print("<br>");
//            }

//            if (click.equals("kytutuongung")) {
                try {

                    int indexkytu = Integer.parseInt(req.getParameter("index-input"));

                    boolean checknhap = true;

                    if (indexkytu <= 0 || indexkytu > input.length()) {
                        out.print("<br>");
                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        checknhap = false;

                    }

                    if (checknhap == true) {
                        out.print("<br>");
                        out.print("Ký tự tương ứng là: ");

                        for (int i = 0; i < input.length(); i++) {

                            if (i == indexkytu) {
                                out.print(input.charAt(i - 1) + " ");
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    out.print("<br>");
                    out.print("Phải nhập vị trí là số nguyên");

                }

//            }

//            if (click.equals("vitrituongung")) {
                String strfind = req.getParameter("str-find");
                out.print("<br>");
                out.print("Vị trí tương ứng là:  ");

                input = input.trim().toLowerCase();

                boolean check = false;

                for (int i = 0; i < input.length(); i++) {

                    if (i == input.indexOf(strfind, i)) {
                        out.println(i + 1);
                        if (i < input.length() - 1) {
                            out.print(", ");
                        }
                        check = true;

                    }
                }

                if (check != true) {
                    out.print("<br>");
                    out.print("Không tìm thấy");
                }

//            }

//            if (click.equals("ketqua")) {

                try {

                    int start = Integer.parseInt(req.getParameter("start"));
                    int end = Integer.parseInt(req.getParameter("end"));

                    boolean checkvitri = true;

                    if (start <= 0 || end <= 0 || start > input.length() || end > input.length()) {
                        out.print("<br>");

                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        checkvitri = false;

                    }

                    if (start > end) {
                        out.print("<br>");
                        out.print("Nhập lại, start phải nhỏ hơn end. <br>");
                        checkvitri = false;

                    }

                    if (checkvitri == true) {
                        out.print("<br>");

                        String[] slice = new String[end - start + 1];

                        for (int i = 0; i < slice.length; i++) {

                            out.print(input.charAt(start + i - 1));

                        }
                    }
                } catch (NumberFormatException e) {
                    out.print("<br>");
                    out.print("Phải nhập vị trí là số nguyên");
                    out.print("<br>");

                }

//            }

        } catch (Exception e) {

        }
    

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        String title = "Thao tac doan van";
        resp.getWriter().print("<head><title>" + title + "</title></head>");

        try ( PrintWriter out = resp.getWriter()) {

            String click = req.getParameter("click");
            String input = req.getParameter("text-input");
            
            if(input.length()==0){
                out.print("hãy nhập mảng");
            }else{

            if (click.equals("tongkytu")) {

                int a = input.length();

                out.print("Tổng số ký tự:  " + a);
            }

            if (click.equals("kytutuongung")) {
                try {

                    int indexkytu = Integer.parseInt(req.getParameter("index-input"));

                    boolean checknhap = true;

                    if (indexkytu <= 0 || indexkytu > input.length()) {

                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        checknhap = false;

                    }

                    if (checknhap == true) {

                        out.print("Ký tự tương ứng là: ");

                        for (int i = 0; i < input.length(); i++) {

                            if (i == indexkytu) {
                                out.print(input.charAt(i - 1) + " ");
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    out.print("Phải nhập vị trí là số nguyên");

                }

            }

            if (click.equals("vitrituongung")) {
                String strfind = req.getParameter("str-find");
                out.print("Vị trí tương ứng là:  ");

                input = input.trim().toLowerCase();

                boolean check = false;

                for (int i = 0; i < input.length(); i++) {

                    if (i == input.indexOf(strfind, i)) {
                        out.println(i + 1);
                        if (i < input.length() - 1) {
                            out.print(", ");
                        }
                        check = true;

                    }
                }

                if (check != true) {
                    out.print("Không tìm thấy");
                }

            }

            if (click.equals("ketqua")) {

                try {

                    int start = Integer.parseInt(req.getParameter("start"));
                    int end = Integer.parseInt(req.getParameter("end"));

                    boolean checkvitri = true;

                    if (start <= 0 || end <= 0 || start > input.length() || end > input.length()) {

                        out.print("Nhập vị trí trong khoảng từ 1 đến " + input.length() + "<br>");
                        checkvitri = false;

                    }

//                    if (start > end) {
//                        out.print("Nhập lại, start phải nhỏ hơn end. <br>");
//                        checkvitri = false;
//
//                    }

                    if (checkvitri == true) {
                        
                        if(end>start){

                        String[] slice = new String[end - start + 1];

                        for (int i = 0; i < slice.length; i++) {

                            out.print(input.charAt(start + i - 1));

                        }}
                        else{
                            
                            String[] slice = new String[start - end + 1];

                        for (int i = 0; i < slice.length; i++) {

                            out.print(input.charAt(end + i - 1));

                        }
                                
                                }
                    }
                } catch (NumberFormatException e) {
                    out.print("Phải nhập vị trí là số nguyên");

                }

            }}

        } catch (Exception e) {

        }
    }

}
