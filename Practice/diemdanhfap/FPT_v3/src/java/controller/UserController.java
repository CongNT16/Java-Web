/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import model.User;

/**
 *
 * @author Admin
 */
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin tu view
        String studentId = req.getParameter("studentId");
        String password = req.getParameter("password");
        String campus = req.getParameter("campus");

        String name, email;
        //Xu li thong tin
//        boolean Ok=false;
        User u = new User(studentId, password, campus);
        boolean OK = u.checklogin();
        if (OK) {
            ArrayList<User> list = u.getAll();
            req.setAttribute("list", list);

            HttpSession session = req.getSession();
            User p = new User();
            p.getDetail(studentId);
            name = p.getName();
            email = p.getEmail();

            session.setAttribute("studentId", studentId);
            session.setAttribute("campus", campus);
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            System.out.println(name);
            System.out.println(email);
            req.getRequestDispatcher("FPTpages.jsp").forward(req, resp);

        } else {
            req.setAttribute("campus", campus);
            System.out.println(campus);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        //Tra ket qua cho view
        req.setAttribute("studentId", studentId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String dob = req.getParameter("dob");
        User u = new User();
        if (u.checkUser(studentId, dob)) {
            //co ton tai
            //Tao 1 pass moi
            String newpass = "";
            Random r = new Random();
            newpass = r.nextInt(100) + "";
            // Update moi nay cho   ung
            u.update(studentId, newpass);
            //tra ve pass moi ve cho view
            req.setAttribute("password", newpass);
            req.setAttribute("studentId", studentId);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("Forgot.jsp").forward(req, resp);
        }
    }

}
