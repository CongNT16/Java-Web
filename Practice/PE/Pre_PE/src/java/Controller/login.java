/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //register
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        
        //check account ton tai hay khong
        
        User us = new User();
        if(us.checkUser(account,dob)){
            //có tồn tại
            
            //Thong bao
            String mess="";
            mess+="tai khoan da ton tai, vui long nhap ten khac";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
        else{
            //insertdata
            us.insert(account,pass,name,gender,address,dob);
            
            req.setAttribute("account", account);
            req.setAttribute("pass", pass);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Nhan thong tin tu view
        
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");

        
        
        
        //Xu ly thong tin
        
        
        User u = new User(account, pass);
        boolean OK = u.checklogin();
        
        if(OK){
            //tạo secsion để chứa thông tin đăng nhập
            
            
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            //get danh sách user từ DB
            ArrayList<User> list = (ArrayList<User>)u.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("Login.jsp").forward(req, resp);

        }
        //Tra ket qua ve view
        
        
        
    }
    
    
}
