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
import model.Product;
import model.User;

/**
 *
 * @author nguye
 */
public class ProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin tu view

        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");

        //Xu ly thong tin
        User u = new User(account, pass);
        Product y = new Product();
        boolean OK = u.checklogin();

        if (OK) {
            //get danh sách user từ DB
//            ArrayList<User> list = (ArrayList<User>)u.getAll();
            //get danh sach product tu DB
            ArrayList<Product> list = (ArrayList<Product>) y.getAll();

            req.setAttribute("list", list);

            req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);

        }
        //Tra ket qua ve view
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        if(session.getAttribute("account")==null){
            resp.sendRedirect("Message.jsp");
            return;
        }

        Product y = new Product();
        ArrayList<Product> list = (ArrayList<Product>) y.getAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("ListProduct.jsp").forward(req, resp);
    }

}
