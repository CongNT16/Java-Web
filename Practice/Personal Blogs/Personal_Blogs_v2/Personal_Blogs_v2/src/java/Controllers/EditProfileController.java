/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.UserDAO;
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
public class EditProfileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        String getuserid = req.getParameter("userid");
        String account = req.getParameter("user_edit_account");        
        String name = req.getParameter("user_edit_name");
        String gender = req.getParameter("user_edit_gender");
        String dob = req.getParameter("user_edit_dob");
        String email = req.getParameter("user_edit_email");
        String phone = req.getParameter("user_edit_phone");
        String address = req.getParameter("user_edit_address");
        String avatar = req.getParameter("user_edit_avatar");
        String mess = "";
        UserDAO u = new UserDAO();

        //Check user tồn tại hay không
        //Check account tồn tại hay không
        if (u.checkUserAccount(account)) {
            //có tồn tại account

            //Thong bao
            mess += "Account đã tồn tại vui lòng tạo tài khoản với account khác";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("edit_profile_page.jsp").forward(req, resp);
        }
        //check email tồn tại hay không
        if (u.checkUserEmail(email)) {
            //có tồn tại email

            //Thong bao
            mess += "Email đã tồn tại vui lòng tạo tài khoản với email khác";
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("edit_profile_page.jsp").forward(req, resp);
        } else {
            //update user infor
//            u.UpdateInfor(getuserid, account, email, name, gender, dob, address, phone, avatar);
            
            

            req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        

        req.getRequestDispatcher("edit_profile_page.jsp").forward(req, resp);
    }

}
