/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhan du lieu tu View
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name, mail, address, birthofdate, role;
        //Xu ly           
        User u = new User(account, password);
        Boolean OK = u.checklogin();
        //Tra ket qua ve cho View
        if (OK) {
            HttpSession session = req.getSession();
            User p = new User();
           
            req.setAttribute("user", p);
            name = p.getFullname();
            mail = p.getEmail();
            address = p.getAddress();
            birthofdate = p.getDateofbirth();
            role = p.getRole();

            session.setAttribute("account", account);
            session.setAttribute("password", password);
            session.setAttribute("name", name);
            session.setAttribute("mail", mail);
            session.setAttribute("address", address);
            session.setAttribute("birthofdate", birthofdate);
            session.setAttribute("role", role);

            User n = new User();

            if (account.equals("admin")) {
                movie m = new movie();
                ArrayList<movie> list = m.getAll();
                req.setAttribute("list", list);

                req.getRequestDispatcher("addfilm.jsp").forward(req, resp);
            } else {
                 movie m = new movie();
                ArrayList<movie> list = m.getAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("sucess.jsp").forward(req, resp);
               // req.getRequestDispatcher("book1.jsp").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("acc");
        String sdt = req.getParameter("sdt");

        User u = new User();

        if (u.checkUser(account, sdt)) {
            //Cos ton tai
            //Tao 1 pass moi
            String newpass = "";
            Random r = new Random();
            newpass = r.nextInt(100) + "";
            //Update pass moi cho account tuong ung
            u.update(account, newpass);

            //Tra pass moi ve cho view
            req.setAttribute("account", account);
            req.setAttribute("password", newpass);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {

            req.getRequestDispatcher("Forgotpass.jsp").forward(req, resp);
        }

    }
}
