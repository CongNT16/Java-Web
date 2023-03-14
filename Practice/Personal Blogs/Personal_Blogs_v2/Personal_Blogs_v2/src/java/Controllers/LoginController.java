/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.PostDAO;
import DataAccess.UserDAO;
import Models.Posts;
import Models.Users;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //change pass

        String account = req.getParameter("account");
        String email = req.getParameter("email");
        String newpassword1 = req.getParameter("newpassword1");
        String newpassword2 = req.getParameter("newpassword2");
        String mess = "";
        //check account ton tai hay khong

        UserDAO u = new UserDAO();
        if (u.checkUser(account, email)) {
            //có tồn tại

            if (newpassword1.equals(newpassword2)) {
                u.updatePassword(account, newpassword1);

                req.setAttribute("account", account);
                req.setAttribute("password", newpassword1);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {

                mess += "nhap lai pass";
                req.setAttribute("mess", mess);
                req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);
            }

        } else {
            //insertdata

            //Thong bao
            mess += "sai tai khoan hoac mat khau";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin tu view

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String mess = "";
        //Xu ly thong tin
        UserDAO u = new UserDAO();

//        Users y = new Users();
//        UsersModel u = new UsersModel();
        boolean OK = u.checklogin(account, password);
        HttpSession session = req.getSession();
//        Users y = new Users();

        if (OK) {
//
//            Users userInfor = u.getUser(account, password);
//            req.setAttribute("user_account", userInfor.getUser_account());
//            session.setAttribute("user_account", userInfor.getUser_account());
//            req.getRequestDispatcher("home.jsp").forward(req, resp);

            Users userInfor = u.getUser(account, password);
            Users userRoleId = u.getUserRoleId(userInfor.getUser_id());

            String userRole = String.valueOf(userRoleId.getRole_id());
            
            

            if (userRole.equals("4")) {
                session.setAttribute("user_login_account", userInfor.getUser_account());
                session.setAttribute("user_login_id", userInfor.getUser_id());
                
                req.getRequestDispatcher("HomeController").forward(req, resp);
            }
            if (userRole.equals("1")) {
                session.setAttribute("user_login_account", userInfor.getUser_account());
                session.setAttribute("user_login_id", userInfor.getUser_id());
                session.setAttribute("user_login_roleid", userRoleId.getRole_id());
                req.getRequestDispatcher("ManageController").forward(req, resp);
            }

        } else {
            mess += "sai tai khoan hoac mat khau";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }
        //Tra ket qua ve view
    }

}
