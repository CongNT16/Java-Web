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
 * @author nguye
 */
public class UserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("acc");
        String dob = req.getParameter("dob");
        
        User u = new User();
        if(u.checkUser(account,dob)){
            //có tồn tại
            
            //Tạo 1 pass mới
            String newpass="";
            Random r = new Random();
            newpass=r.nextInt(100)+"";
            

                    
            //Update pass nầy cho acount tương tứng
            u.update(account,newpass);
            
            //trả về pass mới
            req.setAttribute("pass", newpass);
            req.setAttribute("account", account);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("ForgotPass.jsp").forward(req, resp);
        }
        
    }
    
    
    
    
    
}
