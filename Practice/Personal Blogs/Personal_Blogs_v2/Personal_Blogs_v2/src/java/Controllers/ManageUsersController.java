/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.RoleDAO;
import DataAccess.UserDAO;
import Models.Roles;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManageUsersController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String thread = req.getParameter("thread");
        UserDAO u = new UserDAO();
        RoleDAO r = new RoleDAO();

        if (thread.equals("1")) {
            ArrayList<Users> listUser = (ArrayList<Users>)u.getListUser();
            req.setAttribute("listUser", listUser);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
        }

        if (thread.equals("2")) {
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            
            

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);

        }

        if (thread.equals("3")) {
            String iduserdel = req.getParameter("iduserdel");
            u.deleteUserByUserId(iduserdel);
            
            ArrayList<Users> listUser = (ArrayList<Users>)u.getListUser();
            req.setAttribute("listUser", listUser);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);

        }

        if (thread.equals("4")) {
            String iduseredit = req.getParameter("iduseredit");
            
            Users userInforWithid = u.getUserInfor(iduseredit);
            req.setAttribute("user_account", userInforWithid.getUser_account());
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            
            req.setAttribute("iduseredit", iduseredit);
            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);

        }
        
        if(thread.equals("6")){
            //register
        String account = req.getParameter("user_account");        
        String email = req.getParameter("user_email");
        String password1 = req.getParameter("user_password1");
        String password2 = req.getParameter("user_password2");
        String role_id = req.getParameter("role_id");
        String mess= "";
        
        
        //check tai khoan ton tai hay khong
        
        if(u.checkUserAccount(account)){
            //có tồn tại account
            
            //Thong bao
            
            mess+="Account đã tồn tại vui lòng tạo tài khoản với account khác";
            req.setAttribute("mess", mess);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            
            req.setAttribute("thread", 2);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
        }
        
        else if(u.checkUserEmail(email)){
            //có tồn tại email
            
            //Thong bao
            
            mess+="Email đã tồn tại vui lòng tạo tài khoản với email khác";
            req.setAttribute("mess", mess);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            req.setAttribute("thread", 2);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
        }
        else{
            //insertdata
            
            if(password1.equals(password2) ){
            
            //Tạo 1 user_id mới
            String user_id="";
            
            while(u.checkUserId(user_id) == false){
            Random generator = new Random();
            user_id = String.valueOf(generator.nextInt((99999999 - 10000000) + 1) + 10000000)  ;
            
            //get time local
            LocalDate getdate = LocalDate.now();
            LocalTime gettime = LocalTime.now();
            
            String createdate = String.valueOf(getdate);
            
            String createtime = String.valueOf(gettime);
            
            
            
            u.insertUser(user_id,account,email,password1,createdate,createtime);
            u.insertUserRoleID(user_id,role_id);
            break;
            }
            
            
            
            
            ArrayList<Users> listUser = (ArrayList<Users>)u.getListUser();
            req.setAttribute("listUser", listUser);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
            
            }else{
            
            mess+="nhap lai pass";
            req.setAttribute("mess", mess);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            req.setAttribute("thread", 2);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
            }
            
            
            
        }
           
            
        }
        
        
        
        if(thread.equals("7")){
            String role_id = req.getParameter("role_id");  
            String user_id = req.getParameter("iduseredit"); 
            
             
            r.updateEditRole(user_id,role_id);
            
            
            ArrayList<Users> listUser = (ArrayList<Users>)u.getListUser();
            req.setAttribute("listUser", listUser);
            
            ArrayList<Roles> listRole = (ArrayList<Roles>)r.getListRole();
            req.setAttribute("listRole", listRole);
            
            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_users.jsp").forward(req, resp);
            
        }
    }

}
