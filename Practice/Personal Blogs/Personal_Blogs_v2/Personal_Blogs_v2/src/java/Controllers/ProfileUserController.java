/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.UserDAO;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author nguye
 */
public class ProfileUserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String getuserid = req.getParameter("userid");
        UserDAO u = new UserDAO();
        
        Users userInfor = u.getUserInfor(getuserid);
        
        
        session.setAttribute("user_infor_id", userInfor.getUser_id());
        session.setAttribute("user_infor_account", userInfor.getUser_account());
//        session.setAttribute("user_infor_role", userInfor.getUser_role());
//        session.setAttribute("user_infor_name", userInfor.getUser_name());
        session.setAttribute("user_infor_gender", userInfor.getUser_gender());
        session.setAttribute("user_infor_dob", userInfor.getUser_dob());
        session.setAttribute("user_infor_email", userInfor.getUser_email());
        session.setAttribute("user_infor_phone", userInfor.getUser_phone());
        session.setAttribute("user_infor_address", userInfor.getUser_address());
        session.setAttribute("user_infor_avatar", userInfor.getUser_avatar());
        
        req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
    }
    
    
    
}
